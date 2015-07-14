package controllers.panier;

import api.ApiResponse;
import api.TiskaController;
import api.TiskaDeferredResult;
import api.status.Status;
import controllers.panier.request.LignePanierRequest;
import controllers.panier.request.PanierRequest;
import controllers.prestation.request.PrestationCategorieRequest;
import controllers.prestation.response.PrestationCategorieResponse;
import enums.TYPES_REDUCTION;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import persistence.beans.biz.*;

import javax.validation.Valid;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Adrien on 14/07/2015.
 */
@RestController
@RequestMapping("/services/panier")
public class PanierController extends TiskaController{

        private static Logger logger = LoggerFactory.getLogger(PanierController.class);

        /**
         * Création d'un panier si il n'existe pas, sinon ajout d'une ligne
         *
         * @return
         * @throws Exception
         */
        @RequestMapping(value = "/panier/", method = POST)
        public @ResponseBody
        DeferredResult<ApiResponse> addLignePanier(@Valid @RequestBody PanierRequest request) {

            DeferredResult<ApiResponse> result = new TiskaDeferredResult<>();

//        GeneratorRuntime.getGeneratorRuntime().executeTransaction(() -> {
            //on veut le panier non payé du client, normalment il n'y en a qu'un
            List<Basket> baskets = Basket.getBasketListParDatePaiementEtIdClient(null,request.getIdClient()).toBlocking().single();

            Basket basket = null;

            //cas création du panier
            if(baskets.isEmpty()){
                Basket newBasket = Basket.create();
                newBasket.setDate(LocalDateTime.now());
                newBasket.setIdClient(request.getIdClient());
                newBasket.save().toBlocking().single();
                basket = newBasket;
                logger.info("création d'un nouveau panier ");


            }else if(baskets.size() == 1){
                //cas panier existant
                basket = baskets.get(0);
                logger.info("récupération d'un panier ");

            }else{
                //cas bizarre où le client aurait 2 paniers non payés, nettoyer. Peut exister pour les paniers sans client non terminés
                logger.info("on a 2 paniers ");
            }

            int total = 0;
            //creation du total
            for(LignePanierRequest ligne : request.getLignesPanier()){

                //creation des nouvelles lignes de panier
                Basketline line = Basketline.create();
                line.setIdBasket(basket.getId());
                line.setQuantite(ligne.getQuantitee());
                line.setTypeDeReduction(ligne.getTypeReduction());
                line.setReduction(ligne.getReduction());

                //cas produit
                int price = 0;
                if(ligne.getIdProduit() != null){
                    line.setIdPrestation(ligne.getIdPrestation());
                    price = Produit.getProduit(ligne.getIdProduit()).toBlocking().single().get().getPrixVenteCalcule();
                }else if(ligne.getIdPrestation() != null){
                    line.setIdProduit(ligne.getIdProduit());
                    price = Prestation.getPrestation(ligne.getIdPrestation()).toBlocking().single().get().getPrix();
                }else{
                    //cas pas bon où on a pas passé de produit
                    logger.error("pas d'id produit ou prestation");
                }

                //aplication de la reduction
                if(ligne.getTypeReduction() == TYPES_REDUCTION.FIXE.getCode()){
                    price = price - ligne.getReduction();
                }else if(ligne.getTypeReduction() == TYPES_REDUCTION.POURCENTAGE.getCode()){
                    price = price - (price * (ligne.getReduction()/100/100));
                }

                line.setPrixAvecReduction(price);
                line.save().toBlocking().single();

                total += price;
            }

            basket.setTotal(total);
            basket.save().toBlocking().single();


            logger.info("création d'un panier ");
            result.setResult(new ApiResponse(Status.OK.getCode(),"ok"));

//        });

            return result;
        }
}

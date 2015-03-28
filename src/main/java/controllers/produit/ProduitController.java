package controllers.produit;

import api.TiskaDeferredResult;
import controllers.produit.request.ProduitCategorieRequest;
import controllers.produit.request.ProduitRequest;
import controllers.produit.response.ProduitCategorieListResponse;
import controllers.produit.response.ProduitCategorieResponse;
import controllers.produit.response.ProduitListResponse;
import controllers.produit.response.ProduitResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import persistence.beans.biz.Prestationcategorie;
import persistence.beans.biz.Produit;
import persistence.beans.biz.Produitcategorie;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Tiska on 20/12/2014.
 */

@RestController
@RequestMapping("/services/produit")
public class ProduitController {

    private static Logger logger = LoggerFactory.getLogger(controllers.prestation.PrestationController.class);

    /**
     * Création d'un categorie
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/categorie/", method = POST)
    public @ResponseBody
    DeferredResult<ProduitCategorieResponse> addProduitCategorie(@Valid @RequestBody ProduitCategorieRequest request) {

        DeferredResult<ProduitCategorieResponse> result = new TiskaDeferredResult<>();

//        GeneratorRuntime.getGeneratorRuntime().executeTransaction(() -> {
            Produitcategorie categ = Produitcategorie.create();
            categ.setLibelle(request.getLibelleProduitCategorie());
            categ.save().subscribe();
            logger.info("création du produit catégorie "+categ.getId());
            result.setResult(new ProduitCategorieResponse(String.valueOf(categ.getId()),categ.getLibelle()));

//        });

        return result;
    }

    /**
     * liste des categories
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/categorie/list", method = GET)
    public @ResponseBody
    DeferredResult<ProduitCategorieListResponse> getPrestationCategories() {

        DeferredResult<ProduitCategorieListResponse> result = new TiskaDeferredResult<>();

//        GeneratorRuntime.getGeneratorRuntime().executeTransaction(() -> {
        List<ProduitCategorieResponse> categories = new ArrayList<>();

        Produitcategorie.getList().subscribe(list -> {
            if (list != null && !list.isEmpty()) {
                for (Produitcategorie categ : list) {
                    ProduitCategorieResponse resp = new ProduitCategorieResponse(String.valueOf(categ.getId()), categ.getLibelle());
                    categories.add(resp);
                }
            }
        });

        logger.info(categories.size()+" categories trouvés");

        result.setResult(new ProduitCategorieListResponse(categories));

//        });

        return result;
    }

    /**
     * liste des produits par catégorie
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/list/byCategorie/{idCategorie}", method = GET)
    public @ResponseBody
    DeferredResult<ProduitListResponse> getProduitsByCategorie(@PathVariable("idCategorie") long idCategorie) {

        DeferredResult<ProduitListResponse> result = new TiskaDeferredResult<>();

//        GeneratorRuntime.getGeneratorRuntime().executeTransaction(() -> {
        List<ProduitResponse> produits = new ArrayList<>();

        Produit.getProduitListParIdProduitCateg(idCategorie).subscribe(list -> {
            if (list != null && !list.isEmpty()) {
                for (Produit prod : list) {
                    ProduitResponse resp = new ProduitResponse(String.valueOf(prod.getId()), prod.getLibelle(), prod.getStock(),prod.getPrixVenteCalcule());
                    produits.add(resp);
                }
            }
        });

        logger.info(produits.size()+" produits trouvés");

        result.setResult(new ProduitListResponse(produits));

//        });

        return result;
    }

    /**
     * Création d'un produit
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/", method = POST)
    public @ResponseBody
    DeferredResult<ProduitResponse> addProduit(@Valid @RequestBody ProduitRequest request) {

        DeferredResult<ProduitResponse> result = new TiskaDeferredResult<>();

//        GeneratorRuntime.getGeneratorRuntime().executeTransaction(() -> {
        Produit produit = Produit.create();
        produit.setLibelle(request.getLibelle());
        produit.setStock(request.getStock());
        produit.setPrixAchat(request.getPrixAchat());
        produit.setIdProduitCateg(request.getIdProduitCategorie());

        if(request.getCoefficiant() != null && request.getPrixVente() != null){
            produit.setPrixVenteCalcule(request.getPrixVente());
            produit.setCoefficiant(request.getCoefficiant());
        }else if(request.getCoefficiant() != null){
            produit.setPrixVenteCalcule(request.getPrixAchat()*request.getCoefficiant());
            produit.setCoefficiant(request.getCoefficiant());
        }else if(request.getPrixVente() != null){
            produit.setCoefficiant(request.getPrixVente() /request.getPrixAchat());
            produit.setPrixVenteCalcule(request.getPrixVente());
        }else{
            produit.setPrixVenteCalcule(request.getPrixAchat());
            produit.setCoefficiant(0);
        }

        produit.save().subscribe();
        logger.info("création du produit "+produit.getId());
        result.setResult(new ProduitResponse(String.valueOf(produit.getId()),produit.getLibelle(),produit.getStock(),produit.getPrixVenteCalcule()));

//        });

        return result;
    }
}

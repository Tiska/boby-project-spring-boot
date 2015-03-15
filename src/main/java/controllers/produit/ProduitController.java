package controllers.produit;

import api.TiskaDeferredResult;
import controllers.produit.request.ProduitCategorieRequest;
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
     * Création d'un contact
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
            result.setResult(new ProduitCategorieResponse(categ.getId(),categ.getLibelle()));

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
                    ProduitCategorieResponse resp = new ProduitCategorieResponse(categ.getId(),categ.getLibelle());
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
    @RequestMapping(value = "/produit/list/byCategorie/{idCategorie}", method = GET)
    public @ResponseBody
    DeferredResult<ProduitListResponse> getProduitsByCategorie(@PathVariable("idCategorie") long idCategorie) {

        DeferredResult<ProduitListResponse> result = new TiskaDeferredResult<>();

//        GeneratorRuntime.getGeneratorRuntime().executeTransaction(() -> {
        List<ProduitResponse> produits = new ArrayList<>();

        Produit.getProduitListParIdProduitCateg(idCategorie).subscribe(list -> {
            if (list != null && !list.isEmpty()) {
                for (Produit prod : list) {
                    ProduitResponse resp = new ProduitResponse(prod.getId(), prod.getLibelle(), prod.getStock());
                    produits.add(resp);
                }
            }
        });

        logger.info(produits.size()+" produits trouvés");

        result.setResult(new ProduitListResponse(produits));

//        });

        return result;
    }
}

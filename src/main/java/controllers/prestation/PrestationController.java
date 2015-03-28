package controllers.prestation;

import api.TiskaDeferredResult;
import controllers.prestation.request.PrestationCategorieRequest;
import controllers.prestation.request.PrestationRequest;
import controllers.prestation.response.PrestationCategorieListResponse;
import controllers.prestation.response.PrestationCategorieResponse;
import controllers.prestation.response.PrestationListResponse;
import controllers.prestation.response.PrestationResponse;
import controllers.produit.request.ProduitRequest;
import controllers.produit.response.ProduitListResponse;
import controllers.produit.response.ProduitResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import persistence.beans.biz.Client;
import persistence.beans.biz.Prestation;
import persistence.beans.biz.Prestationcategorie;
import persistence.beans.biz.Produit;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Tiska on 20/12/2014.
 */

@RestController
@RequestMapping("/services/prestation")
public class PrestationController {

    private static Logger logger = LoggerFactory.getLogger(PrestationController.class);

    /**
     * Création d'un contact
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/categorie/", method = POST)
    public @ResponseBody
    DeferredResult<PrestationCategorieResponse> addPrestationCategorie(@Valid @RequestBody PrestationCategorieRequest request) {

        DeferredResult<PrestationCategorieResponse> result = new TiskaDeferredResult<>();

//        GeneratorRuntime.getGeneratorRuntime().executeTransaction(() -> {
            Prestationcategorie categ = Prestationcategorie.create();
            categ.setLibelle(request.getLibellePrestationCategorie());
            categ.save().subscribe();
            logger.info("création de la prestation catégorie "+categ.getId());
            result.setResult(new PrestationCategorieResponse(String.valueOf(categ.getId()), categ.getLibelle()));

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
    DeferredResult<PrestationCategorieListResponse> getPrestationCategories() {

        DeferredResult<PrestationCategorieListResponse> result = new TiskaDeferredResult<>();

//        GeneratorRuntime.getGeneratorRuntime().executeTransaction(() -> {
        List<PrestationCategorieResponse> categories = new ArrayList<>();

        Prestationcategorie.getList().subscribe(list -> {
            if (list != null && !list.isEmpty()) {
                for (Prestationcategorie categ : list) {
                    PrestationCategorieResponse resp = new PrestationCategorieResponse(String.valueOf(categ.getId()), categ.getLibelle());
                    categories.add(resp);
                }
            }
        });

        logger.info(categories.size()+" categories trouvés");

        result.setResult(new PrestationCategorieListResponse(categories));

//        });

        return result;
    }

    /**
     * liste des prestations par catégorie
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/list/byCategorie/{idCategorie}", method = GET)
    public @ResponseBody
    DeferredResult<PrestationListResponse> getProduitsByCategorie(@PathVariable("idCategorie") long idCategorie) {

        DeferredResult<PrestationListResponse> result = new TiskaDeferredResult<>();

//        GeneratorRuntime.getGeneratorRuntime().executeTransaction(() -> {
        List<PrestationResponse> prestations = new ArrayList<>();

        Prestation.getPrestationListParIdPrestationCateg(idCategorie).subscribe(list -> {
            if (list != null && !list.isEmpty()) {
                for (Prestation presta : list) {
                    PrestationResponse resp = new PrestationResponse(String.valueOf(presta.getId()), presta.getLibelle(), presta.getPrix(), presta.getDuree());
                    prestations.add(resp);
                }
            }
        });

        logger.info(prestations.size()+" prestations trouvés");

        result.setResult(new PrestationListResponse(prestations));

//        });

        return result;
    }

    /**
     * Création d'une prestation
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/", method = POST)
    public @ResponseBody
    DeferredResult<PrestationResponse> addPrestation(@Valid @RequestBody PrestationRequest request) {

        DeferredResult<PrestationResponse> result = new TiskaDeferredResult<>();

//        GeneratorRuntime.getGeneratorRuntime().executeTransaction(() -> {
        Prestation prestation = Prestation.create();
        prestation.setLibelle(request.getLibelle());
        prestation.setDuree(request.getDuree());
        prestation.setPrix(request.getPrix());
        prestation.setIdPrestationCateg(request.getIdPrestationCategorie());

        prestation.save().subscribe();
        logger.info("création du prestation "+prestation.getId());
        result.setResult(new PrestationResponse(String.valueOf(prestation.getId()),prestation.getLibelle(),prestation.getDuree(),prestation.getPrix()));

//        });

        return result;
    }
}

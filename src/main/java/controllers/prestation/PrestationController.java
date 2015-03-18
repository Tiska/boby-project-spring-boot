package controllers.prestation;

import api.TiskaDeferredResult;
import controllers.prestation.request.PrestationCategorieRequest;
import controllers.prestation.response.PrestationCategorieListResponse;
import controllers.prestation.response.PrestationCategorieResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import persistence.beans.biz.Client;
import persistence.beans.biz.Prestationcategorie;

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
}

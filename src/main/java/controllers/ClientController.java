package controllers;

import api.TiskaDeferredResult;
import controllers.request.ClientRequest;
import controllers.response.ClientResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import persistence.GeneratorRuntime;
import persistence.beans.biz.Client;

import javax.validation.Valid;
import javax.ws.rs.PathParam;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by Tiska on 20/12/2014.
 */

@RestController
@RequestMapping("/client/")
public class ClientController {

    private static Logger logger = LoggerFactory.getLogger(ClientController.class);

    /**
     * Création d'un contact
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/add", method = POST)
    public @ResponseBody
    DeferredResult<ClientResponse> addContact(@Valid @RequestBody ClientRequest request) {

        DeferredResult<ClientResponse> result = new TiskaDeferredResult<>();

//        GeneratorRuntime.getGeneratorRuntime().executeTransaction(() -> {
            Client client = Client.create();
            client.setNom(request.getNom());
            client.setPrenom(request.getPrenom());
            client.setAdresse(request.getAdresse());
            client.setBirthday(request.getBirthday());
            client.setCodePostal(request.getCodePostal());
            client.setTelephone(request.getTelephone());
            client.setEmail(request.getEmail());
            client.setVille(request.getVille());
            client.save().subscribe();
            result.setResult(new ClientResponse(client.getId()));

//        });

        return result;
    }
}

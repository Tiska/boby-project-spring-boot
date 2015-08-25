package controllers.client;

import api.TiskaDeferredResult;
import controllers.client.request.ClientRequest;
import controllers.client.response.ClientListResponse;
import controllers.client.response.ClientResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import persistence.beans.biz.Client;

import javax.validation.Valid;
import javax.ws.rs.PathParam;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by Tiska on 20/12/2014.
 */

@RestController
@RequestMapping("/services/client")
public class ClientController {

    private static Logger logger = LoggerFactory.getLogger(ClientController.class);

    /**
     * Création d'un contact
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/", method = POST)
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
            logger.info("création du client "+client.getId());
            result.setResult(new ClientResponse(String.valueOf(client.getId()),request.getNom(),request.getPrenom(), 0));

//        });

        return result;
    }

    /**
     * liste des contacts
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/list", method = GET)
    public @ResponseBody
    DeferredResult<ClientListResponse> getContacts() {

        DeferredResult<ClientListResponse> result = new TiskaDeferredResult<>();

//        GeneratorRuntime.getGeneratorRuntime().executeTransaction(() -> {
        List<ClientResponse> clients = new ArrayList<>();

        Client.getList().subscribe(list -> {
            if (list != null && !list.isEmpty()) {
                for (Client cl : list) {
                    ClientResponse resp = new ClientResponse(String.valueOf(cl.getId()), cl.getNom(), cl.getPrenom(), cl.getPointsFidelite());
                    clients.add(resp);
                }
            }
        });

        logger.info(clients.size()+" clients trouvés");

        result.setResult(new ClientListResponse(clients));

//        });

        return result;
    }

    /**
     * liste des contacts
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{idContact}", method = GET)
    public @ResponseBody
    DeferredResult<ClientResponse> getContact(@PathVariable(value = "idContact") long idContact) {

        DeferredResult<ClientResponse> result = new TiskaDeferredResult<>();

//        GeneratorRuntime.getGeneratorRuntime().executeTransaction(() -> {

        Client cl = Client.getById(idContact).toBlocking().single().get();

        logger.info("client trouvé");

        result.setResult(new ClientResponse(String.valueOf(cl.getId()), cl.getNom(), cl.getPrenom(), cl.getPointsFidelite()));

//        });

        return result;
    }
}

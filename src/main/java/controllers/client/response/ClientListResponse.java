package controllers.client.response;

import api.ApiResponse;

import java.util.List;

/**
 * Created by Tiska on 20/12/2014.
 */
public class ClientListResponse extends ApiResponse {
    private List<ClientResponse> clients;

    public ClientListResponse(List<ClientResponse> clients) {
        this.clients = clients;
    }

    public List<ClientResponse> getClients() {
        return clients;
    }

    public void setClients(List<ClientResponse> clients) {
        this.clients = clients;
    }
}

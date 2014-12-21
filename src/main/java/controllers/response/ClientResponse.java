package controllers.response;

import api.ApiResponse;

/**
 * Created by Tiska on 20/12/2014.
 */
public class ClientResponse extends ApiResponse {
    private long id;

    public ClientResponse(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

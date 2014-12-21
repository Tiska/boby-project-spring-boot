package controllers.request;

/**
 * Created by Tiska on 20/12/2014.
 */
public class ClientRequest {
    private String name;

    public ClientRequest(String name) {
        this.name = name;
    }

    public ClientRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

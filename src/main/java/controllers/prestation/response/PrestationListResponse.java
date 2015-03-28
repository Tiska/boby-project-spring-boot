package controllers.prestation.response;

import api.ApiResponse;

import java.util.List;

/**
 * Created by Tiska on 20/12/2014.
 */
public class PrestationListResponse extends ApiResponse {
    private List<PrestationResponse> prestations;

    public PrestationListResponse(List<PrestationResponse> prestations) {
        this.prestations = prestations;
    }

    public List<PrestationResponse> getPrestations() {
        return prestations;
    }

    public void setPrestations(List<PrestationResponse> prestations) {
        this.prestations = prestations;
    }
}

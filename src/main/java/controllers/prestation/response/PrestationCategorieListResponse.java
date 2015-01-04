package controllers.prestation.response;

import api.ApiResponse;

import java.util.List;

/**
 * Created by Tiska on 20/12/2014.
 */
public class PrestationCategorieListResponse extends ApiResponse {
    private List<PrestationCategorieResponse> categories;

    public PrestationCategorieListResponse(List<PrestationCategorieResponse> categories) {
        this.categories = categories;
    }

    public List<PrestationCategorieResponse> getCategories() {
        return categories;
    }

    public void setCategories(List<PrestationCategorieResponse> categories) {
        this.categories = categories;
    }
}

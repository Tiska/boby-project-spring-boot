package controllers.produit.response;

import api.ApiResponse;

import java.util.List;

/**
 * Created by Tiska on 20/12/2014.
 */
public class ProduitCategorieListResponse extends ApiResponse {
    private List<ProduitCategorieResponse> categories;

    public ProduitCategorieListResponse(List<ProduitCategorieResponse> categories) {
        this.categories = categories;
    }

    public List<ProduitCategorieResponse> getCategories() {
        return categories;
    }

    public void setCategories(List<ProduitCategorieResponse> categories) {
        this.categories = categories;
    }
}

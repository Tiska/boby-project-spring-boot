package controllers.produit.response;

import api.ApiResponse;

import java.util.List;

/**
 * Created by Tiska on 20/12/2014.
 */
public class ProduitListResponse extends ApiResponse {
    private List<ProduitResponse> produits;

    public ProduitListResponse(List<ProduitResponse> produits) {
        this.produits = produits;
    }

    public List<ProduitResponse> getProduits() {
        return produits;
    }

    public void setProduits(List<ProduitResponse> produits) {
        this.produits = produits;
    }
}

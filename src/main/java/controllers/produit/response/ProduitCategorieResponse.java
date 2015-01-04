package controllers.produit.response;

import api.ApiResponse;

/**
 * Created by Tiska on 20/12/2014.
 */
public class ProduitCategorieResponse extends ApiResponse {
    private long id;
    private String libelleProduitCategorie;

    public ProduitCategorieResponse(long id, String libelleProduitCategorie) {
        this.id = id;
        this.libelleProduitCategorie = libelleProduitCategorie;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelleProduitCategorie() {
        return libelleProduitCategorie;
    }

    public void setLibelleProduitCategorie(String libelleProduitCategorie) {
        this.libelleProduitCategorie = libelleProduitCategorie;
    }
}

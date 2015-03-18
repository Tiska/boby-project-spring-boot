package controllers.produit.response;

import api.ApiResponse;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;

/**
 * Created by Tiska on 20/12/2014.
 */
public class ProduitCategorieResponse extends ApiResponse {
    private String id;
    private String libelleProduitCategorie;

    public ProduitCategorieResponse(String id, String libelleProduitCategorie) {
        this.id = id;
        this.libelleProduitCategorie = libelleProduitCategorie;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLibelleProduitCategorie() {
        return libelleProduitCategorie;
    }

    public void setLibelleProduitCategorie(String libelleProduitCategorie) {
        this.libelleProduitCategorie = libelleProduitCategorie;
    }
}

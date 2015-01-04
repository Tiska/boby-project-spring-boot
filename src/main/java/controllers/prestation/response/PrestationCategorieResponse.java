package controllers.prestation.response;

import api.ApiResponse;

/**
 * Created by Tiska on 20/12/2014.
 */
public class PrestationCategorieResponse extends ApiResponse {
    private long id;
    private String libellePrestationCategorie;

    public PrestationCategorieResponse(long id, String libellePrestationCategorie) {
        this.id = id;
        this.libellePrestationCategorie = libellePrestationCategorie;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibellePrestationCategorie() {
        return libellePrestationCategorie;
    }

    public void setLibellePrestationCategorie(String libellePrestationCategorie) {
        this.libellePrestationCategorie = libellePrestationCategorie;
    }
}

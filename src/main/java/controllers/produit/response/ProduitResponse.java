package controllers.produit.response;

import api.ApiResponse;

/**
 * Created by Tiska on 20/12/2014.
 */
public class ProduitResponse extends ApiResponse {
    private long id;
    private String libelleProduit;
    private Integer stock;

    public ProduitResponse(long id, String libelleProduit, Integer stock) {
        this.id = id;
        this.libelleProduit = libelleProduit;
        this.stock = stock;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelleProduit() {
        return libelleProduit;
    }

    public void setLibelleProduit(String libelleProduit) {
        this.libelleProduit = libelleProduit;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}

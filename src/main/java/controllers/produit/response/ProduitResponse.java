package controllers.produit.response;

import api.ApiResponse;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;

/**
 * Created by Tiska on 20/12/2014.
 */
public class ProduitResponse extends ApiResponse {
    private String id;
    private String libelleProduit;
    private Integer stock;
    private Integer prixVente;

    public ProduitResponse(String id, String libelleProduit, Integer stock, Integer prixVente) {
        this.id = id;
        this.libelleProduit = libelleProduit;
        this.stock = stock;
        this.prixVente = prixVente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Integer getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(Integer prixVente) {
        this.prixVente = prixVente;
    }
}

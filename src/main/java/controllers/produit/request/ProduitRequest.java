package controllers.produit.request;

import api.ApiResponse;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by Tiska on 20/12/2014.
 */
public class ProduitRequest extends ApiResponse {

    @NotEmpty(message = "Invalid name")
    @NotNull(message = "Invalid name")
    @Length(max = 100)
    private String libelle;

    @NotNull(message = "Invalid stock")
    private Integer stock;

    @NotNull(message = "Invalid prixAchat")
    private Integer prixAchat;

    private Integer prixVente;
    private Integer coefficiant;

    @NotNull(message = "Invalid idProduitCategorie")
    private long idProduitCategorie;

    public ProduitRequest() {
    }

    public ProduitRequest(String libelle, Integer stock, Integer prixAchat, Integer prixVente, Integer coefficiant, long idProduitCategorie) {
        this.libelle = libelle;
        this.stock = stock;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.coefficiant = coefficiant;
        this.idProduitCategorie = idProduitCategorie;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(Integer prixAchat) {
        this.prixAchat = prixAchat;
    }

    public Integer getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(Integer prixVente) {
        this.prixVente = prixVente;
    }

    public Integer getCoefficiant() {
        return coefficiant;
    }

    public void setCoefficiant(Integer coefficiant) {
        this.coefficiant = coefficiant;
    }

    public long getIdProduitCategorie() {
        return idProduitCategorie;
    }

    public void setIdProduitCategorie(long idProduitCategorie) {
        this.idProduitCategorie = idProduitCategorie;
    }
}

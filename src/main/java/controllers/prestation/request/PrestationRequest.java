package controllers.prestation.request;

import api.ApiResponse;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by Tiska on 20/12/2014.
 */
public class PrestationRequest extends ApiResponse {

    @NotEmpty(message = "Invalid name")
    @NotNull(message = "Invalid name")
    @Length(max = 100)
    private String libelle;

    @NotNull(message = "Invalid duree")
    private Integer duree;

    @NotNull(message = "Invalid prix")
    private Integer prix;

    @NotNull(message = "Invalid idPrestationCategorie")
    private long idPrestationCategorie;

    public PrestationRequest() {
    }

    public PrestationRequest(String libelle, Integer duree, Integer prix, long idPrestationCategorie) {
        this.libelle = libelle;
        this.duree = duree;
        this.prix = prix;
        this.idPrestationCategorie = idPrestationCategorie;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public long getIdPrestationCategorie() {
        return idPrestationCategorie;
    }

    public void setIdPrestationCategorie(long idPrestationCategorie) {
        this.idPrestationCategorie = idPrestationCategorie;
    }
}

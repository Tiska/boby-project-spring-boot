package controllers.prestation.response;

import api.ApiResponse;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by Tiska on 20/12/2014.
 */
public class PrestationResponse extends ApiResponse {
    private String id;
    private String libellePrestation;
    private Integer prix;
    private Integer duree;

    public PrestationResponse(String id, String libellePrestation, Integer prix, Integer duree) {
        this.id = id;
        this.libellePrestation = libellePrestation;
        this.prix = prix;
        this.duree = duree;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLibellePrestation() {
        return libellePrestation;
    }

    public void setLibellePrestation(String libellePrestation) {
        this.libellePrestation = libellePrestation;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }
}

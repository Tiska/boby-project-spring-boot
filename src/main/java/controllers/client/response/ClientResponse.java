package controllers.client.response;

import api.ApiResponse;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;

/**
 * Created by Tiska on 20/12/2014.
 */
public class ClientResponse extends ApiResponse {

    private String id;
    private String nom;
    private String prenom;
    private int points;

    public ClientResponse(String id, String nom, String prenom, int points) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.points = points;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}

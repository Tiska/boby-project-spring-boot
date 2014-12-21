package controllers.request;

import java.time.LocalDateTime;

/**
 * Created by Tiska on 20/12/2014.
 */
public class ClientRequest {
    private String nom;
    private String prenom;
    private Integer telephone;
    private String adresse;
    private String codePostal;
    private String ville;
    private LocalDateTime birthday;
    private String email;

    public ClientRequest() {
    }

    public ClientRequest(String nom, String prenom, Integer telephone, String codePostal, String ville, LocalDateTime birthday, String email, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.codePostal = codePostal;
        this.ville = ville;
        this.birthday = birthday;
        this.email = email;
        this.adresse = adresse;
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

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

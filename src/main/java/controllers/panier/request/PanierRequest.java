package controllers.panier.request;

import java.util.List;

/**
 * Created by Adrien on 14/07/2015.
 */
public class PanierRequest {

    private long idClient;
    private List<LignePanierRequest> lignesPanier;

    public PanierRequest(long idClient, List<LignePanierRequest> lignesPanier) {
        this.idClient = idClient;
        this.lignesPanier = lignesPanier;
    }

    public List<LignePanierRequest> getLignesPanier() {
        return lignesPanier;
    }

    public void setLignesPanier(List<LignePanierRequest> lignesPanier) {
        this.lignesPanier = lignesPanier;
    }

    public long getIdClient() {

        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }
}

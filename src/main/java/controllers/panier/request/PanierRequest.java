package controllers.panier.request;

import java.util.List;

/**
 * Created by Adrien on 14/07/2015.
 */
public class PanierRequest {

    private Long idClient;
    private List<LignePanierRequest> lignesPanier;
    private boolean usePoints;

    public PanierRequest(Long idClient, boolean usePoints, List<LignePanierRequest> lignesPanier) {
        this.idClient = idClient;
        this.usePoints = usePoints;
        this.lignesPanier = lignesPanier;
    }

    public List<LignePanierRequest> getLignesPanier() {
        return lignesPanier;
    }

    public void setLignesPanier(List<LignePanierRequest> lignesPanier) {
        this.lignesPanier = lignesPanier;
    }

    public Long getIdClient() {

        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public boolean isUsePoints() {
        return usePoints;
    }

    public void setUsePoints(boolean usePoints) {
        this.usePoints = usePoints;
    }
}

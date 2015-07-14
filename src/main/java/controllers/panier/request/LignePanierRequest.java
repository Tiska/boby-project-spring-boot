package controllers.panier.request;

/**
 * Created by Adrien on 14/07/2015.
 */
public class LignePanierRequest {

    private Long idPrestation;
    private Long idProduit;
    private Long idLignePanier;
    private int quantitee;
    private int reduction;
    private int typeReduction;

    public LignePanierRequest(Long idPrestation, Long idProduit, Long idLignePanier, int quantitee, int reduction, int typeReduction) {
        this.idPrestation = idPrestation;
        this.idProduit = idProduit;
        this.idLignePanier = idLignePanier;
        this.quantitee = quantitee;
        this.reduction = reduction;
        this.typeReduction = typeReduction;
    }

    public Long getIdLignePanier() {
        return idLignePanier;
    }

    public void setIdLignePanier(Long idLignePanier) {
        this.idLignePanier = idLignePanier;
    }

    public Long getIdPrestation() {
        return idPrestation;
    }

    public void setIdPrestation(Long idPrestation) {
        this.idPrestation = idPrestation;
    }

    public Long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }

    public int getQuantitee() {
        return quantitee;
    }

    public void setQuantitee(int quantitee) {
        this.quantitee = quantitee;
    }

    public int getReduction() {
        return reduction;
    }

    public void setReduction(int reduction) {
        this.reduction = reduction;
    }

    public int getTypeReduction() {
        return typeReduction;
    }

    public void setTypeReduction(int typeReduction) {
        this.typeReduction = typeReduction;
    }
}

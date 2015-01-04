package controllers.produit.request;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by Tiska on 20/12/2014.
 */
public class ProduitCategorieRequest {

    @NotEmpty(message = "Invalid name")
    @NotNull(message = "Invalid name")
    @Length(max = 100)
    private String libelleProduitCategorie;

    public ProduitCategorieRequest() {
    }

    public ProduitCategorieRequest(String libelleProduitCategorie) {
        this.libelleProduitCategorie = libelleProduitCategorie;
    }

    public String getLibelleProduitCategorie() {
        return libelleProduitCategorie;
    }

    public void setLibelleProduitCategorie(String libelleProduitCategorie) {
        this.libelleProduitCategorie = libelleProduitCategorie;
    }
}

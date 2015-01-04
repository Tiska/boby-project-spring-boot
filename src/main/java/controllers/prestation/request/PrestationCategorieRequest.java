package controllers.prestation.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import json.JsonDateTimeDeserializer;
import json.JsonDateTimeSerializer;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by Tiska on 20/12/2014.
 */
public class PrestationCategorieRequest {

    @NotEmpty(message = "Invalid name")
    @NotNull(message = "Invalid name")
    @Length(max = 100)
    private String libellePrestationCategorie;

    public PrestationCategorieRequest() {
    }

    public PrestationCategorieRequest(String libellePrestationCategorie) {
        this.libellePrestationCategorie = libellePrestationCategorie;
    }

    public String getLibellePrestationCategorie() {
        return libellePrestationCategorie;
    }

    public void setLibellePrestationCategorie(String libellePrestationCategorie) {
        this.libellePrestationCategorie = libellePrestationCategorie;
    }
}

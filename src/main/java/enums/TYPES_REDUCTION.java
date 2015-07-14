package enums;

/**
 * Created by Adrien on 14/07/2015.
 */
public enum TYPES_REDUCTION {

    FIXE(1),
    POURCENTAGE(1);

    int code;

    TYPES_REDUCTION(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}


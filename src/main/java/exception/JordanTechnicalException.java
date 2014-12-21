package exception;


import api.status.Status;

/**
 * Erreur technique
 * Ex : problème d'accès à la base
 * <p/>
 * Important : la stacktrace d'une JordanTechnicalException EST écrite dans les logs
 *
 * @author antoine.ansel-ext
 */
public class JordanTechnicalException extends RuntimeException {

	private int code;

	private String message;

	public JordanTechnicalException(String message) {
		this.code = Status.ERREUR_TECHNIQUE.getCode();
		this.message = message;
	}

	public JordanTechnicalException(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}

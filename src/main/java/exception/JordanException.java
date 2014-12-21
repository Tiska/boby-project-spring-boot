package exception;

/**
 * Erreur fonctionnelle.
 * Ex 1 : l'utilisateur essaie de créer un compte avec un email déjà présent en base
 * Ex 2 : appel d'un service avec un paramètre manquant
 * <p/>
 * Important : la stacktrace d'une JordanException n'est PAS écrite dans les logs
 *
 * @author antoine.ansel-ext
 */
public class JordanException extends RuntimeException {

	private int code;

	private String message;

	public JordanException(int code, String message) {
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

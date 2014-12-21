package api;

import api.status.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import exception.JordanException;
import exception.JordanTechnicalException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;

/**
 * Tout web service renvoit un objet ApiResponse, ou un objet qui étend ApiResponse
 *
 * @author antoine.ansel-ext
 */
@JsonInclude(Include.NON_NULL)
public class ApiResponse {

	private final int status;

	private final String message;


	// Réponse OK, sans résultat
	public final static ApiResponse OK = new ApiResponse();


	public ApiResponse() {
		status = Status.OK.getCode();
		message = null;
	}

	public ApiResponse(int status, String message) {
		this.status = status;
		this.message = message;
	}

	/**
	 * Créer un ApiResponse à partir d'un Throwable
	 *
	 * @param t
	 * @return
	 */
	public static ApiResponse from(Throwable t) {
		String errorMessage = getMessage(t);
		if (t instanceof JordanTechnicalException) {
			return new ApiResponse(((JordanTechnicalException) t).getCode(), errorMessage);
		} else if (t instanceof JordanException) {
			return new ApiResponse(((JordanException) t).getCode(), errorMessage);
		} else if (t instanceof MethodArgumentNotValidException) {
			return new ApiResponse(Status.ERREUR_PARAMETRES_ENTREE.getCode(), errorMessage);
		} else if (t instanceof HttpMediaTypeNotSupportedException) {
			return new ApiResponse(Status.ERREUR_REQUETE_INVALIDE.getCode(), "Invalid HTTP media type");
		} else if (t instanceof HttpMessageNotReadableException) {
			return new ApiResponse(Status.ERREUR_REQUETE_INVALIDE.getCode(), "Invalid HTTP message");
		}
		return new ApiResponse(Status.ERREUR_TECHNIQUE.getCode(), "A technical error has occured");
	}

	/**
	 * Récupérer le message à affficher pour une exception donnée
	 *
	 * @param t
	 * @return
	 */
	public static String getMessage(Throwable t) {
		if (t instanceof MethodArgumentNotValidException) {
			MethodArgumentNotValidException exception = (MethodArgumentNotValidException) t;
			BindingResult result = exception.getBindingResult();
			if (result != null) {
				if (result.getFieldError() != null) {
					String message = result.getFieldError().getDefaultMessage();
					if (!StringUtils.isEmpty(message)) {
						return message;
					}
				}
			}
		}
		return t.getMessage();
	}


	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}
}

package async;

import api.ApiResponse;
import exception.JordanException;
import exception.JordanTechnicalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.async.DeferredResult;


/**
 * Contexte de la requête http en cours de traitement
 *
 * @author antoine.ansel-ext
 */
public abstract class AbstractRequestContext {

	private Logger logger = LoggerFactory.getLogger(AbstractRequestContext.class);

	// Deferred result de la requête en cours
	private DeferredResult<ApiResponse> result;

	private String requestId;


	public AbstractRequestContext(String token) {
		this.requestId = "r123"; // TODO AA
	}


	/**
	 * Gestion des erreurs, utile notamment pour les erreurs remontées en asynchrones
	 * 
	 * @param t
	 */
	public void handleThrowable(Throwable t) {
		if (t instanceof JordanException) {
			logger.error(t.getMessage());
		} else if (t instanceof JordanTechnicalException) {
			logger.error(t.getMessage(), t);
		} else {
			logger.error("Erreur inconnue au sein d'un observable", t);
		}

		DeferredResult<ApiResponse> result = this.getResult();
		if (result != null) {
			result.setResult(ApiResponse.from(t));
		}
	}


	public DeferredResult<ApiResponse> getResult() {
		return result;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setResult(DeferredResult<ApiResponse> result) {
		this.result = result;
	}

	private static ThreadLocal<AbstractRequestContext> tlContext = new ThreadLocal<AbstractRequestContext>();

	public static AbstractRequestContext get() {
		return tlContext.get();
	}

	public static void set(AbstractRequestContext context) {
		tlContext.set(context);
	}

	/**
	 * Vider le context en cours
	 */
	public static void clear() {
		tlContext.remove();
	}

}

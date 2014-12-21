package async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.plugins.RxJavaErrorHandler;

/**
 * Gestion des erreurs remontées par des Observable RxJava
 *
 * @author antoine.ansel-ext
 */
public class ErrorHandler extends RxJavaErrorHandler {

	private static Logger logger = LoggerFactory.getLogger(ErrorHandler.class);

	@Override
	public void handleError(Throwable t) {
		AbstractRequestContext context = AbstractRequestContext.get();
		if (context != null) {
			context.handleThrowable(t);
		}
		else {
			// Cas anormal, on devrait toujours avoir un contexte
			logger.error("Erreur remontée mais aucun contexte trouvé", t);
		}
	}
}

package api;

import exception.JordanException;
import exception.JordanTechnicalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import rx.exceptions.OnErrorNotImplementedException;

import javax.servlet.http.HttpServletRequest;

/**
 * Classe mère de tous les controlleurs de la plate-forme Jordan
 *
 * @author antoine.ansel-ext
 */
@Controller
public class TiskaController {

	private Logger logger = LoggerFactory.getLogger(TiskaController.class);

	@Autowired
	private MessageSource messageSource;


	/**
	 * Traitement des exceptions remontées par les controlleurs
	 *
	 * @param req
	 * @param t
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(Throwable.class)
	public ApiResponse handleException(HttpServletRequest req, Throwable t) {
		if (t instanceof OnErrorNotImplementedException) {
			// RxJava envoit une OnErrorNotImplementedException si une exception est levée dans
			// un observable synchrone et que onError n'a pas été implémenté.
			t = t.getCause();
		}

		if (t instanceof JordanTechnicalException) {
			logger.error("Erreur technique", t);
		} else if (t instanceof JordanException) {
			logger.error("Erreur fonctionnelle : " + t.getMessage());
		}
		// Exception Spring envoyée lorsque les arguments d'entrée ne sont pas valides (@Valid)
		else if (t instanceof MethodArgumentNotValidException) {
			logger.error("Erreur arguments : " + t.getMessage());
		} else {
			logger.error("Erreur ", t);
		}

		return ApiResponse.from(t);
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

}

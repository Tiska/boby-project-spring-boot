package async;

import rx.functions.Action0;
import rx.plugins.RxJavaSchedulersHook;

/**
 * Hook RxJava permettant d'ajouter le contexte de la requête http à chaque nouveau
 * thread créé.
 *
 * @author antoine.ansel-ext
 */
public class RequestContextSchedulersHook extends RxJavaSchedulersHook {

	@Override
	public Action0 onSchedule(Action0 action) {
		return super.onSchedule(new WrappedAction0(action));
	}

	private class WrappedAction0 implements Action0 {

		private final Action0 actual;

		private final AbstractRequestContext context;

		public WrappedAction0(Action0 actual) {
			this.actual = actual;
			this.context = AbstractRequestContext.get();
		}

		@Override
		public void call() {
			AbstractRequestContext.set(context);
			actual.call();
		}
	}
}

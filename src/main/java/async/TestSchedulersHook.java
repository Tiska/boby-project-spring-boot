package async;

import rx.Scheduler;
import rx.plugins.RxJavaSchedulersHook;
import rx.schedulers.Schedulers;

/**
 * Pour les tests unitaires, on rend la plate-forme synchrone
 *
 * @author antoine.ansel-ext
 */
public class TestSchedulersHook extends RxJavaSchedulersHook {

	@Override
	public Scheduler getComputationScheduler() {
		return super.getComputationScheduler();
	}

	@Override
	public Scheduler getNewThreadScheduler() {
		return Schedulers.immediate();
	}

	@Override
	public Scheduler getIOScheduler() {
		return Schedulers.immediate();
	}
}

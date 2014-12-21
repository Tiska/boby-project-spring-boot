package api;

import async.AbstractRequestContext;
import org.springframework.web.context.request.async.DeferredResult;


public class TiskaDeferredResult<T extends ApiResponse> extends DeferredResult<T> {

	public TiskaDeferredResult() {
		super();
		AbstractRequestContext context = AbstractRequestContext.get();
		if (context != null) {
			context.setResult((DeferredResult) this);
		}
	}
}

package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ning.http.client.*;
import rx.Observable;
import rx.Observable.OnSubscribe;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;


public class ApiInvoker {
	private static ApiInvoker INSTANCE = new ApiInvoker();
	private AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
	private Map<String, String> defaultHeaderMap = new HashMap<String, String>();
	private boolean isDebug = false;

	public void enableDebug() {
		isDebug = true;
	}

	public static ApiInvoker getInstance() {
		return INSTANCE;
	}

	public void addDefaultHeader(String key, String value) {
		defaultHeaderMap.put(key, value);
	}

	public String escapeString(String str) {
		try {
			return URLEncoder.encode(str, "utf8").replaceAll("\\+", "%20");
		} catch (UnsupportedEncodingException e) {
			return str;
		}
	}

	public static <T> T deserialize(String json, String containerType, Class<T> clazz) throws ApiException {
		try {
			return JsonUtil.getJsonMapper().readValue(json, clazz);
		} catch (IOException e) {
			throw new ApiException(500, e.getMessage());
		}
	}

	public static String serialize(Object obj) throws ApiException {
		try {
			if (obj != null) {
				return JsonUtil.getJsonMapper().writeValueAsString(obj);
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new ApiException(500, e.getMessage());
		}
	}

	public <T> Observable<T> invokeAPI(String host, String path, String method, Map<String, String> queryParams, Object body, Map<String, String> headerParams, Map<String, String> formParams, String contentType, Class<T> clazz) throws ApiException {
		RequestBuilder builder = new RequestBuilder();
		builder.setMethod(method);
		builder.setUrl(host + path + getQueryString(queryParams));
		if (body != null) {
			try {
				builder.setBody(JsonUtil.getJsonMapper().writeValueAsString(body));
			} catch (JsonProcessingException e) {
				// TODO
				e.printStackTrace();
			}
		}

		for (String key : headerParams.keySet()) {
			builder.setHeader(key, headerParams.get(key));
		}

		for (String key : defaultHeaderMap.keySet()) {
			if (!headerParams.containsKey(key)) {
				builder.setHeader(key, defaultHeaderMap.get(key));
			}
		}

		Request request = builder.build();
		return Observable.create((OnSubscribe<T>) suscriber -> {
			try {
				asyncHttpClient.executeRequest(request, new AsyncCompletionHandler<Void>() {
					@Override
					public Void onCompleted(Response response) throws Exception {
						suscriber.onNext(JsonUtil.getJsonMapper().readValue(response.getResponseBody(), clazz));
						suscriber.onCompleted();
						return null;
					}

					public void onThrowable(Throwable t) {
						// TODO
					}

				});
			} catch (Exception e) {
				// TODO
				e.printStackTrace();
			}
		});

	}


	public String getQueryString(Map<String, String> queryParams) {
		StringBuilder b = new StringBuilder();
		boolean first = true;
		for (String key : queryParams.keySet()) {
			String value = queryParams.get(key);
			if (value != null) {
				if (first) {
					b.append("?");
					first = false;
				} else {
					b.append("&");
				}
				b.append(escapeString(key)).append("=").append(escapeString(value));
			}
		}
		return b.toString();
	}

}


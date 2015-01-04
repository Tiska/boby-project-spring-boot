package json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by abody on 27/10/14.
 */
public class JsonDateTimeSerializer extends JsonSerializer<LocalDateTime> {

	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

	@Override
	public void serialize(LocalDateTime date, JsonGenerator generator,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		String dateString = date.format(formatter);
		generator.writeString(dateString);
	}
}

package lab4.task3;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReader<T> {

    private final Class<T> type;
    private final ObjectMapper objectMapper;

    public JsonReader(Class<T> type) {
        this.type = type;
        this.objectMapper = new ObjectMapper();
    }

    public T read(String json) throws JsonProcessingException {
        return objectMapper.readValue(json, type);
    }
}

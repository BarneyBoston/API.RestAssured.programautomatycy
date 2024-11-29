package pl.programautomatycy.api.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtractFromResponse {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String extractStringFromResponse(String key, Response response) {
        String responseBody = response.getBody().asString();
        try {
            Object parsedResponse = objectMapper.readValue(responseBody, Object.class);
            return extractValue(parsedResponse, key, String.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Number extractNumberFromResponse(String key, Response response) {
        String responseBody = response.getBody().asString();
        try {
            Object parsedResponse = objectMapper.readValue(responseBody, Object.class);
            return extractValue(parsedResponse, key, Number.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> extractValuesFromResponse(Response response, String fieldName) {
        List<String> values = new ArrayList<>();
        String responseBody = response.getBody().asString();
        try {
            Object parsedResponse = objectMapper.readValue(responseBody, Object.class);
            extractValuesFromParsedResponse(parsedResponse, fieldName, values);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return values;
    }

    private <T> T extractValue(Object response, String key, Class<T> valueType) {
        if (response instanceof Map) {
            Map<String, Object> map = (Map<String, Object>) response;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (entry.getValue() instanceof Map) {
                    Object innerValue = ((Map<?, ?>) entry.getValue()).get(key);
                    if (valueType.isInstance(innerValue)) {
                        return valueType.cast(innerValue);
                    }
                }
            }
        } else if (response instanceof List) {
            for (Object item : (List<?>) response) {
                if (item instanceof Map) {
                    Object innerValue = ((Map<?, ?>) item).get(key);
                    if (valueType.isInstance(innerValue)) {
                        return valueType.cast(innerValue);
                    }
                }
            }
        }
        return null;
    }

    private void extractValuesFromParsedResponse(Object response, String fieldName, List<String> values) {
        if (response instanceof Map) {
            Map<String, Object> map = (Map<String, Object>) response;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (entry.getValue() instanceof Map) {
                    Object fieldValue = ((Map<?, ?>) entry.getValue()).get(fieldName);
                    if (fieldValue != null) {
                        values.add(fieldValue.toString());
                    }
                }
            }
        } else if (response instanceof List) {
            for (Object item : (List<?>) response) {
                if (item instanceof Map) {
                    Object fieldValue = ((Map<?, ?>) item).get(fieldName);
                    if (fieldValue != null) {
                        values.add(fieldValue.toString());
                    }
                }
            }
        }
    }
}

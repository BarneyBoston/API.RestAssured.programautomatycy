package pl.programautomatycy.api.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtractFromResponse {
    public String extractStringFromResponse(String key, Response response) {
        String responseBody = response.getBody().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        String valueKey = null;
        try {
            Map<String, Object> responseMap = objectMapper.readValue(responseBody, Map.class);

            for (Map.Entry<String, Object> entry : responseMap.entrySet()) {
                Map<String, Object> innerMap = (Map<String, Object>) entry.getValue();
                valueKey = (String) innerMap.get(key);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return valueKey;
    }
    public Number extractNumberFromResponse(String key, Response response) {
        String responseBody = response.getBody().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        Number valueKey = null;
        try {
            Map<String, Object> responseMap = objectMapper.readValue(responseBody, Map.class);

            for (Map.Entry<String, Object> entry : responseMap.entrySet()) {
                Map<String, Object> innerMap = (Map<String, Object>) entry.getValue();
                valueKey = (Number) innerMap.get(key);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return valueKey;
    }

    public List<String> extractValuesFromResponse(Response response, String fieldName) {
        List<String> values = new ArrayList<>();
        String responseBody = response.getBody().asString();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Map<String, Object> responseMap = objectMapper.readValue(responseBody, Map.class);

            for (Map.Entry<String, Object> entry : responseMap.entrySet()) {
                Map<String, Object> innerMap = (Map<String, Object>) entry.getValue();
                Object fieldValue = innerMap.get(fieldName);
                if (fieldValue != null) {
                    values.add(fieldValue.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return values;
    }
}

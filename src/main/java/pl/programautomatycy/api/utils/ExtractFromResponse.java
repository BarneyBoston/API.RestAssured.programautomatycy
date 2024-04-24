package pl.programautomatycy.api.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

import java.util.Map;

public class ExtractFromResponse {
    public String extractFromResponse(String value, Response response) {
        String responseBody = response.getBody().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        String valueKey = null;
        try {
            Map<String, Object> responseMap = objectMapper.readValue(responseBody, Map.class);

            for (Map.Entry<String, Object> entry : responseMap.entrySet()) {
                Map<String, Object> innerMap = (Map<String, Object>) entry.getValue();
                valueKey = (String) innerMap.get(value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return valueKey;
    }
}

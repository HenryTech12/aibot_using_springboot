package com.ai.demo.service;

import com.ai.demo.dto.AiResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;

@Service
public class AiService {

    private static final Logger log = LoggerFactory.getLogger(AiService.class);
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;
    @Value("${spring.ai.openai.api-key}")
    private String apiKey;
    @Value("${spring.ai.openai.base-url}")
    private String apiUrl;
    public AiService() {
        httpClient = HttpClient.newHttpClient();
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES,false);
    }

    public AiResponse chat(String prompt) {
        prompt = (prompt.isBlank() || prompt.isEmpty()) ? "Hi" : prompt;
        try {

            // Create the main JSON object
            JSONObject rootObject = new JSONObject();

            // Create the contents JSON array
            JSONArray contentsArray = new JSONArray();

            // Create the object for parts
            JSONObject contentObject = new JSONObject();

            // Create the parts JSON array
            JSONArray partsArray = new JSONArray();

            // Create the part object containing the text
            JSONObject partObject = new JSONObject();
            partObject.put("text", prompt);

            // Add partObject to partsArray
            partsArray.put(partObject);

            // Add partsArray to contentObject
            contentObject.put("parts", partsArray);

            // Add contentObject to contentsArray
            contentsArray.put(contentObject);

            // Add contentsArray to the rootObject
            rootObject.put("contents", contentsArray);

            // Output the result as a formatted JSON string
            System.out.println(rootObject.toString(4));  // 4 is for indentation level

            HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI(apiUrl+apiKey))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(rootObject.toString()))
                .build();

        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        if(!Objects.isNull(response)) {
            System.out.println("RESPONSE BODY: " + response.body());

            AiResponse aiResponse = objectMapper.readValue(response.body(), new TypeReference<AiResponse>() {
            });

            System.out.println(aiResponse.getCandidates().get(0).getContent().getParts().get(0).getText());

            return aiResponse;
        }
        }
        catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return null;
    }

    public String extractData(AiResponse aiResponse) {
        return aiResponse.getCandidates().get(0).getContent().getParts().get(0).getText();
    }
}

package com.example.springBootAndChatGpt.infra.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * This class represents a configuration class that defines the configuration for the RestTemplate
 * used to interact with the OpenAI API. It sets up the necessary authentication headers to access
 * the API using the provided API key.
 */
@Configuration
public class OpenAIRestTemplateConfig {

    @Value("${openai.api.key}")
    private String openaiApiKey;

    /**
     * Creates and configures the RestTemplate bean that will be used to make HTTP requests to the
     * OpenAI API. The bean is named "openaiRestTemplate" and can be accessed using the qualifier
     * "@Qualifier("openaiRestTemplate")".
     *
     * @return The configured RestTemplate bean.
     */
    @Bean
    @Qualifier("openaiRestTemplate")
    public RestTemplate openaiRestTemplate() {
        // Create a new instance of RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Add an interceptor to the RestTemplate to include the API key in the request headers
        restTemplate.getInterceptors().add((request, body, execution) -> {
            // Add the "Authorization" header with the API key in the format "Bearer {apiKey}"
            request.getHeaders().add("Authorization", "Bearer " + openaiApiKey);
            return execution.execute(request, body);
        });

        // Return the configured RestTemplate bean
        return restTemplate;
    }
}

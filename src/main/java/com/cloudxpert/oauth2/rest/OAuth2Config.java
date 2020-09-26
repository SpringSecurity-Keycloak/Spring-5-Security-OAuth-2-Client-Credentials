package com.cloudxpert.oauth2.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.AuthorizedClientServiceOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Configuration
@EnableWebSecurity
public class OAuth2Config {
	
	
    /**
     * Create a instance of the OAuth2AuthorizedClientManager
     * @param clientRegistrationRepository
     * @param authorizedClientService
     * @return
     */
    @Bean
    public OAuth2AuthorizedClientManager authorizedClientManager(ClientRegistrationRepository clientRegistrationRepository
    															,OAuth2AuthorizedClientService authorizedClientService) {
    
        OAuth2AuthorizedClientProvider authorizedClientProvider = OAuth2AuthorizedClientProviderBuilder.builder()
                                                                  .clientCredentials()
                                                                  .build();

        AuthorizedClientServiceOAuth2AuthorizedClientManager authorizedClientManager = 
        													 new AuthorizedClientServiceOAuth2AuthorizedClientManager(
        													 clientRegistrationRepository, authorizedClientService);
        authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);
    
        
        return authorizedClientManager;
    }
    
    /**
     * Create a Webclient wired with the OAuth2AuthorizedClientManager to generate the Authorization token
     * @param authorizedClientManager
     * @return
     */
    @Bean
    WebClient webClient(OAuth2AuthorizedClientManager authorizedClientManager) {
        
        ServletOAuth2AuthorizedClientExchangeFilterFunction oauth2Client = 
        													new ServletOAuth2AuthorizedClientExchangeFilterFunction(
        													authorizedClientManager);
        			
        oauth2Client.setDefaultClientRegistrationId("studentservice");
        return WebClient.builder()
                .apply(oauth2Client.oauth2Configuration())
                .filter(this.logRequest())
                .build();
    }
    
    /**
     * Log request for debugging purposes
     * @return
     */
    private static ExchangeFilterFunction logRequest() {
        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
            log.info("Request: {} {}", clientRequest.method(), clientRequest.url());
            clientRequest.headers().forEach((name, values) -> values.forEach(value -> log.info("{}={}", name, value)));
            
            return Mono.just(clientRequest);
        });
    }


}

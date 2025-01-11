package com.aws.cognito.jwt.service_aws_cognito.service;
import com.aws.cognito.jwt.service_aws_cognito.model.CognitoResponse;
import org.apache.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CognitoAgentImpl implements ICognitoAgent{
    @Value("${cognito.url}")
    private String clientUrl;
    @Value("${cognito.client.id}")
    private String clientId;
    @Value("${cognito.client.secret}")
    private String clientSecret;
    @Value("${cognito.scope}")
    private String scope;
    @Value("${cognito.grant.type}")
    private String grantType;

    private WebClient getCognitoClient() {
        return WebClient.builder()
                //URL: get from cognito app client page
                .baseUrl(clientUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .build();
    }
    @Override
    public CognitoResponse getAccess(){
        //params are get from cognito app client page
        return getCognitoClient().post()
                .uri("/oauth2/token")
                .body(BodyInserters
                        .fromFormData("client_id", clientId)
                        .with("client_secret", clientSecret)
                        .with("scope",scope)
                        .with("grant_type",grantType)
                )
                .retrieve()
                .bodyToMono(CognitoResponse.class)
                .block();
    }

}

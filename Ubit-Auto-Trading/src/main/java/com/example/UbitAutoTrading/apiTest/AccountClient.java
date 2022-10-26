package com.example.UbitAutoTrading.apiTest;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;

import java.util.List;

@RequiredArgsConstructor
@Component
public class AccountClient {

    public static final String ACCOUNTS_URL = UpbitApiPaths.BASE_SERVER_URL + "/accounts";
    private final JwtTokenProvider jwtTokenProvider;
    private final RestTemplate restTemplate;

    public List<AccountResponse> getAccounts() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(jwtTokenProvider.createToken());
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<?> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(ACCOUNTS_URL, HttpMethod.GET, entity,
                new ParameterizedTypeReference<List<AccountResponse>>() {
                }).getBody();
    }
}

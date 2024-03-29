package com.tqt.airmon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    public String callPostApi(String apiUrl, Object dataObject) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<Object> request = new HttpEntity<>(dataObject, headers);
            ResponseEntity<Object> response  = restTemplate.exchange(apiUrl, HttpMethod.POST,request,Object.class);
            return response.getBody().toString();
        } catch (Exception e) {
            return null;
        }
    }
}

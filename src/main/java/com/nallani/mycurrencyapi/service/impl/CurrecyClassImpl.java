package com.nallani.mycurrencyapi.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nallani.mycurrencyapi.service.CurrecyClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrecyClassImpl implements CurrecyClass {

    @Override
    public Double inr() throws Exception {
        ResponseEntity<String> response= null;
        JsonNode rootNode = null;
        String status = "inr";

        RestTemplate restTemplate = new RestTemplate();
        response = restTemplate.getForEntity("http://api.currencylayer.com/live?access_key=480f4b22850aaa3e955e5d30d8a06c14&currencies=INR", String.class);
        String result =  response.getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        rootNode = objectMapper.readTree(result);
        status = rootNode.findPath("USDINR").asText();
        return Double.parseDouble(status);
    }

    @Override
    public String getAll() throws Exception {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("http://api.currencylayer.com/live?access_key=480f4b22850aaa3e955e5d30d8a06c14", String.class);
        return response.getBody();
    }
}

package com.nallani.mycurrencyapi.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.nallani.mycurrencyapi.service.CurrecyClass;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = {"http://localhost:8080"})
@RestController
public class ApiRestService {

    @Autowired private CurrecyClass currecyClass;

    @RequestMapping(
            value = "/get-inr",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Double getINR() throws Exception {
       return currecyClass.inr();
    }

    @RequestMapping(
            value = "/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String getAll() throws Exception {
        return currecyClass.getAll();
    }

    @GetMapping("/health")
    public String healthcheck() {
        return "OK";
    }
}

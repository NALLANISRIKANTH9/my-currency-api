package com.nallani.mycurrencyapi.service;

import org.springframework.http.ResponseEntity;

public interface CurrecyClass {

    Double inr() throws Exception;

    String getAll() throws Exception;
}

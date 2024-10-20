package com.nourcine.backend.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class PharmacieUtils {
    private PharmacieUtils(){

    }
    public static ResponseEntity<String> getResponseEntity(String responseMessage , HttpStatus httpStatus){
        return new ResponseEntity<String>("{\"messag\":\""+responseMessage+"\"}", httpStatus);
    }
}

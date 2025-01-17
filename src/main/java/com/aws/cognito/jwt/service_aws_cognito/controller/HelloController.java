package com.aws.cognito.jwt.service_aws_cognito.controller;

import com.aws.cognito.jwt.service_aws_cognito.model.CognitoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jwt")
public class HelloController {
    //this URI will deploy to AWS and authenticated by AWS cognito jwt auth
    @GetMapping(path = "/hello")
    public ResponseEntity<String> createJWTToken() {

        String hello="Hello world!";

        return new ResponseEntity<>(hello, HttpStatus.OK);
    }
}

package com.aws.cognito.jwt.service_aws_cognito.controller;

import com.aws.cognito.jwt.service_aws_cognito.model.CognitoResponse;
import com.aws.cognito.jwt.service_aws_cognito.service.CognitoAgentImpl;
import com.aws.cognito.jwt.service_aws_cognito.service.ICognitoAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cognito")
public class CognitoController {
    ICognitoAgent cognitoAgent;

    @Autowired
    public CognitoController(CognitoAgentImpl cognitoAgentImpl){
        this.cognitoAgent = cognitoAgentImpl;
    }
    @PostMapping(path = "/token")
    public ResponseEntity<CognitoResponse> createJWTToken() {

        CognitoResponse token = cognitoAgent.getAccess();

        return new ResponseEntity<>(token, HttpStatus.OK);
    }
}

package com.aws.cognito.jwt.service_aws_cognito.service;

import com.aws.cognito.jwt.service_aws_cognito.model.CognitoResponse;

import java.util.Map;

public interface ICognitoAgent {
    CognitoResponse getAccess();
}

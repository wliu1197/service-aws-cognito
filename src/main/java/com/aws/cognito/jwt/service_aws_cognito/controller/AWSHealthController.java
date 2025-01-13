package com.aws.cognito.jwt.service_aws_cognito.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AWSHealthController {

	@GetMapping(path = "/")
	public String healthCheck() {
		//In AWS it will do auto health check by root path
		//and it's response of 200 ok status
		//In filterChain need to do a permitAll for this root path
		return "UP";
	}
	
}

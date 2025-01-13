# service-aws-cognito
Sample Micro-service to get AWS cognito asscess token
This token can be used to access micro-services that are secured by AWS JWT cognito auth in AWS api-gateway

Build docker image and run image in container
$ docker build -t service-aws-cognito:v1 .
$ docker run -d -t --name service-aws-cognito -p 80:80 service-aws-cognito:v1
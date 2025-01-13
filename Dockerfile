FROM openjdk:17-jdk-slim
ADD /target/service-aws-cognito-0.0.1-SNAPSHOT.jar /home/app/springboot.jar
EXPOSE 80
CMD exec java -jar /home/app/springboot.jar
FROM openjdk:8-jdk-alpine
EXPOSE 8080
EXPOSE 8443
ADD target/uaa-0.0.1-SNAPSHOT.jar /security-uaa.jar
ENTRYPOINT [  "java", "-jar", "/security-uaa.jar","--spring.profiles.active=dev" ]

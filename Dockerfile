FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY /target/achat-1.0.jar /app/achat-1.0.jar
COPY src/main/resources/application.properties /app
ENTRYPOINT ["java","-jar","achat-1.0.jar", "-Dspring.config.location=", "/app/application.properties"]

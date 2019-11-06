FROM openjdk:8-alpine

COPY target/uberjar/bsg-sb-ai.jar /bsg-sb-ai/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/bsg-sb-ai/app.jar"]

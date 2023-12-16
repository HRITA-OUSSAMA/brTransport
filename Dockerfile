
FROM openjdk:17-oracle

COPY target/*.jar brTransport_app.jar

EXPOSE 9011

ENTRYPOINT ["java","-jar","brTransport_app.jar"]

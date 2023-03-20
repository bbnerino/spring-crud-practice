FROM openjdk:11

RUN mkdir -p /images


COPY build/libs/dubu-0.0.1-SNAPSHOT.jar app.jar


ENTRYPOINT ["java","-jar","/app.jar"]

EXPOSE 8080

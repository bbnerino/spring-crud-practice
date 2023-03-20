FROM openjdk:11

RUN mkdir -p /images

RUN gradle build

COPY build/libs/dubu-0.0.1-SNAPSHOT.jar app.jar


ENTRYPOINT ["java","-jar","/app.jar"]

# 만약 배포용 properties를 사용하지 않는다면
# Default properties 실행 명령어
# ENTRYPOINT ["java","-jar","app.jar"]
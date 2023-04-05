FROM openjdk:11-jdk
# RUN mkdir -p /images
LABEL maintainer="email"
ARG JAR_FILE=build/libs/dubu-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} dubu-practice.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/dubu-practice.jar"]

EXPOSE 8080





# docker run   -p 8080:8080 \
# -v /var/run/docker.sock:/var/run/docker.sock \
# --name jenkin1 -d  jenkins/jenkins

# -v 옵션은 호스트의 Docker 소켓을 컨테이너 내부의 Docker 데몬과 연결합니다.

# docker exec -it --user=root jenkin1 bash
# apt-get update
# apt-get install -y docker.io
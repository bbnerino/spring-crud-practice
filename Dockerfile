
# 베이스 이미지로 Java 11을 사용합니다.
FROM openjdk:11-jdk

# 작업 디렉토리를 생성합니다.
RUN mkdir /app
# 작업 디렉토리로 이동합니다.
WORKDIR /app

# Gradle Wrapper를 복사합니다.
COPY gradlew .
COPY gradle gradle

# Gradle 빌드를 위한 의존성 파일을 복사합니다.
COPY build.gradle .
COPY settings.gradle .

COPY src src
# Gradle 빌드를 실행합니다.
RUN ./gradlew build

# 빌드된 jar 파일을 실행합니다.
CMD ["java", "-jar", "build/libs/dubu-0.0.1-SNAPSHOT.jar"]

# COPY build/libs/dubu-0.0.1-SNAPSHOT.jar app.jar


# ENTRYPOINT ["java","-jar","/app.jar"]










# 1단계: Gradle 빌드 단계
FROM openjdk:21-jdk-slim AS build

# Gradle 다운로드 및 설치
RUN apt-get update && apt-get install -y wget unzip \
    && wget https://services.gradle.org/distributions/gradle-8.5-bin.zip -P /tmp \
    && unzip /tmp/gradle-8.5-bin.zip -d /opt \
    && ln -s /opt/gradle-8.5/bin/gradle /usr/local/bin/gradle

# Gradle 설치 확인 (디버깅용)
RUN gradle -v  # Gradle 버전 확인

# 프로젝트 소스 코드 복사
WORKDIR /app
# 현재 디렉토리의 모든 파일을 컨테이너로 복사
COPY BookingService .

# Gradle 빌드 실행
RUN gradle build --no-daemon

# 빌드 후 JAR 파일 경로 확인 (디버깅용)
RUN echo "Listing contents of /app/build/libs" && ls -l /app/build/libs

# 2단계: 애플리케이션 실행 단계
FROM openjdk:21-jdk-slim AS runtime

# 실행할 JAR 파일 복사
WORKDIR /app

# 빌드한 JAR 파일 중 'BookingService-0.0.1-SNAPSHOT-plain.jar'를 사용
COPY --from=build /app/build/libs/*.jar booking-service.jar

# 애플리케이션이 사용할 포트
EXPOSE 8080

# 애플리케이션 실행
ENTRYPOINT ["java", "-Xmx1024m", "-jar", "booking-service.jar"]

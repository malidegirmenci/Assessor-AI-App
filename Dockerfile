FROM eclipse-temurin:17

LABEL authors="Mehmet Ali Degirmenci"

RUN apt-get update && \
    apt-get install -y ffmpeg && \
    rm -rf /var/lib/apt/lists/

COPY ./target/assessorai-0.0.1-SNAPSHOT.jar app.jar
COPY  ./src/main/resources resources

ENTRYPOINT ["java", "-jar", "/app.jar"]
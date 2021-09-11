FROM maven:3.8.2-openjdk-11-slim as builder

WORKDIR /app
COPY pom.xml ./
COPY src ./src/
COPY libs ./libs/

RUN mvn package -DskipTests

CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/target/movie_selector-1.0-SNAPSHOT.jar"]
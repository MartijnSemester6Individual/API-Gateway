FROM openjdk:16-alpine3.13

WORKDIR /app

COPY .env /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]

EXPOSE 8081/tcp

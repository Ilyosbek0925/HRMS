# 1-bosqich: Build qilish
FROM maven:3.9.4-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# 2-bosqich: runtime uchun yengil imidj
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/HRMS-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
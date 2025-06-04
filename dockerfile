# Java 17 bazaviy imij
FROM openjdk:21-jdk-slim

# Loyiha fayllarini konteynerga nusxalash
COPY target/HRMS-0.0.1-SNAPSHOT.jar app.jar

# Port ochish (masalan: 8080)
EXPOSE 8080

# Loyihani ishga tushirish
ENTRYPOINT ["java", "-jar", "app.jar"]

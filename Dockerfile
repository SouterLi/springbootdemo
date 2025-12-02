FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY target/focus-1.0.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
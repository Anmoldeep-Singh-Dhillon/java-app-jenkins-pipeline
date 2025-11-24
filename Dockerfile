# Use a lightweight JRE runtime image
FROM eclipse-temurin:17-jre-alpine

# Create app directory
WORKDIR /app

# Copy the JAR produced by Maven
COPY target/*.jar app.jar

# Expose port (example)
EXPOSE 8080

# Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]

# Stage 1: Build the application using a Maven image
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app

# Copy project files into the container
COPY pom.xml .
COPY src ./src

# Compile and package the application into a .jar file
RUN mvn clean package -DskipTests

# Stage 2: Run the application using a lightweight JRE image
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Expose the port Spring Boot runs on
EXPOSE 8080

# Copy only the compiled .jar file from the 'builder' stage
COPY --from=builder /app/target/api-0.0.1-SNAPSHOT.jar app.jar

# Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]

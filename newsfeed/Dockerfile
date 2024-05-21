# Use a base image with Java 17 installed
FROM openjdk:17-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the host machine to the container
COPY target/newsfeed-0.0.1-SNAPSHOT.jar newsfeed-0.0.1-SNAPSHOT.jar

# Expose the port your application listens on
EXPOSE 8080

# Specify the command to run your application
CMD ["java", "-jar", "newsfeed-0.0.1-SNAPSHOT.jar"]
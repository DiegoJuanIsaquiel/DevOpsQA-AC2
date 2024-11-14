FROM openjdk:17

# Set the working directory in the container
WORKDIR /DevOpsQA-AC2

# Copy the JAR file into the container at /educacaoGamificada
COPY target/*.jar /DevOpsQA-AC2/DevOpsQA-AC2-0.0.1-SNAPSHOT.jar

# Expose the port that your application will run on
EXPOSE 8585

# Specify the command to run on container start
CMD ["java", "-jar", "DevOpsQA-AC2-0.0.1-SNAPSHOT.jar"]
FROM openjdk:11
ADD /var/artifacts/simple-java-maven-app.jar simple-java-maven-app.jar
ENTRYPOINT ["java", "-jar","simple-java-maven-app.jar"]
EXPOSE 9000
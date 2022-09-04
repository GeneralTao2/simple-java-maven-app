FROM openjdk:11
ADD target/simple-java-maven-app-1.0-SNAPSHOT.jar simple-java-maven-app-1.0-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","simple-java-maven-app-1.0-SNAPSHOT.jar"]
EXPOSE 9000
LABEL com.centurylinklabs.watchtower.enable=true
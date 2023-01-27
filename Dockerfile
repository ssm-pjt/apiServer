FROM openjdk:11
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} apiServer.jar
ENTRYPOINT ["java","-jar","/apiServer.jar"]
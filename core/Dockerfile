FROM openjdk:11-jre-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} core-service.jar
ENTRYPOINT ["java","-jar","/core-service.jar"]
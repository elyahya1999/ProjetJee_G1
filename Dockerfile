FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} applic.jar
ENTRYPOINT ["java","-jar","/applic.jar"]
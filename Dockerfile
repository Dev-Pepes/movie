FROM openjdk:17-alpine
ARG JAR_FILE=./Api/build/libs/app.jar
COPY ${JAR_FILE} app.jar

ARG PROFILE=dev
ENV PROFILE=dev
ENTRYPOINT ["java","-Dspring.profiles.active=${PROFILE}", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
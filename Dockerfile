FROM  --platform=linux/amd64 openjdk:17-alpine
ARG JAR_FILE=Api/build/libs/app.jar
ARG ACTIVE_PROFILES=local
COPY ${JAR_FILE} /
USER root
EXPOSE 8080
ENTRYPOINT ["java","-Dspring.profiles.active=${ACTIVE_PROFILES}","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

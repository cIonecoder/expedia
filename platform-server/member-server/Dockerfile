FROM gradle:jdk11

WORKDIR /app
COPY build/libs/member-server-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8082
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
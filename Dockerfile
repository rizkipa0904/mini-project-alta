FROM openjdk:8-jdk-alpine
RUN addgroup -S springdocker && adduser -S springdocker -G springdocker
USER springdocker:springdocker
ARG JAR_FILE=ecommerce-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} ecommerce-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/ecommerce-0.0.1-SNAPSHOT.jar"]
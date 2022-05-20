FROM openjdk:11
ARG JAR_FILE=target/ecommerce-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} ecommerce-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/ecommerce-0.0.1-SNAPSHOT.jar"]

FROM maven:4.0.0-jdk-17-alpine AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package


# Package stage
#
FROM openjdk:17-jre-alpine
COPY --from=build /home/app/target/FactuPlus-0.0.1-SNAPSHOT.jar /usr/local/lib/FactuPlus.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/FactuPlus.jar"]

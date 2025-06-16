# write a simple docker file for a modern java project using spring boot and maven

FROM maven:3.9.9

WORKDIR /app

COPY pom.xml /app

# install deps
RUN mvn dependency:go-offline

COPY src /app/src

EXPOSE 8080

CMD [ "mvn", "spring-boot:run" ]

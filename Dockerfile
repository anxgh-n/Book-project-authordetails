FROM openjdk:17-oracle
COPY ./target/authordetails-0.0.1-SNAPSHOT.jar authordetails.jar
CMD ["java","-jar","authordetails.jar"]

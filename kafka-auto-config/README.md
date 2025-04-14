### Spring boot and Kafka
This is an example of Integrating Kafka with Spring Boot for both Producer and Consumer.
We will be using auto-configuration from Spring Boot.  We just need to enter the Kafka server info into the application.yml

- Producer will post a Topic to Kafka Broker
- Consumer will be listening to the specific Topic


### Pre-req
- Java 17 or later
- IDE
- Spring boot 3 or later
- Spring Initializr (https://start.spring.io)
- Docker container
- Postman


### Docker
- Image:
    - docker pull apache/kafka:latest
- Container:
    - docker run -d -p 9092:9092 --name kafka-broker apache/kafka:latest
- Topics list:
    - kafka-topics --bootstrap-server localhost:9092 --list

### Dependencies
- spring-boot-starter-web
- spring-kafka

### Run the application
- Postman
  - Post request URL: http://localhost:8081/api/v1/send
  - Request body:
    - "Enter your topic test message"
  - Result will get status 200
  - The listener will immediately receive the message display in the console
  
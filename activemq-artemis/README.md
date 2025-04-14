### Spring boot and ActiveMQ Artemis

We will explore how to connect a Spring Boot 3 application to an Apache ActiveMQ Artemis broker using the AMQP protocol and configure it to support transactions.

### Pre-requisites:
- Java 17 or higher
- Apache ActiveMQ Artemis broker (Docker container)
- Spring Boot 3 and JMS

### Docker Container 
1. Pull latest image </br>
    - docker pull apache/activemq-artemis:latest
2. Run
   - docker run --name activemq -p 61616:61616 -p 8161:8161 apache/activemq-artemis:latest-alpine
3. Web Management Console
    - http://localhost:8161/
    - default username & password artemis

### Maven Dependencies
- spring-boot-starter-activemq
- artemis-jms-client
- spring-boot-starter-web
- jackson-core
- jakarta.jms-api

### Running the application

1. Start up by running ActivemqArtemisApplication
2. Use Postman 
    Url: http://localhost:8081/api/v1/send
    Param: String message input
3. Successful with status code 200
MS-Student-Enrollment Project

MS-Student-Enrollment is a simple microservices-based project created for learning, designing, and understanding microservice architecture.
The project is currently under active development and will be completed step-by-step. More APIs will be added progressively depending on the project’s development needs and new functional requirements.

✔ CRUD Operations for Both Student and University Services

Both the Student Service and University Service provide full CRUD functionality. The Student Service retrieves detailed student information and, using FeignClient, also fetches the related University data based on the student’s university ID. This means that when a student is fetched by ID, the response contains a combined result, including:

Student details, University details (fetched from University Service). This demonstrates communication between microservices and how data aggregation works in a distributed system.

This repository includes the following core components:

✔ Eureka Server (Service Discovery)

Used for service registration and discovery.

✔ API Gateway

Acts as the single entry point for routing requests to microservices.

✔ Two Main Microservices

-Student Service

-University Service

These two services communicate with each other using OpenFeign (Feign Client).

✔ Databases (MySQL on Docker)

Each microservice uses its own independent MySQL database, all running inside Docker containers.
Service-to-database connections are orchestrated using a Docker Compose YAML file.

✔ Planned Features (Upcoming Enhancements)

This project will continue evolving and will soon include:

✔ Notification Service

A dedicated service that will send notifications (e.g., “Enrollment completed successfully”) to students.

✔ Distributed Tracing

Using Zipkin to track and monitor requests across all microservices.

✔ Message Broker

For asynchronous communication using Kafka or RabbitMQ.

✔ Caching Layer

Implementing Redis to improve application performance and reduce load.

✔ Security

Integrating Keycloak for authentication and authorization (OAuth2 / OpenID Connect).

✔ Containerization & Orchestration

All services will continue to be Dockerized, with the potential to migrate to Kubernetes in the future.
# MS-Student-Enrollment-System
>>>>>>> 90b1d7de576d96acdd0030e3987608eb76055716

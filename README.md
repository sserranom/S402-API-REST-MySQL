# S04T02N02 - CRUD REST API with Spring Boot and MySQL

## Description

This project is a REST API application developed in Java using Spring Boot that implements CRUD operations to manage a `Fruit` entity. Data is persisted in a MySQL database. The application follows best practices for REST API design, including global exception handling to improve robustness and clarity in error responses.

---

## Technologies Used

- Java 17 (or higher)
- Spring Boot (latest stable version)
- Spring Web
- Spring Data JPA
- MySQL
- Docker & Docker Compose
- Maven

---

## Project Structure

- **cat.itacademy.s04.t02.n02.model**  
  Contains the `Fruit` entity representing the database table with attributes such as `id`, `name`, and `quilsQuantity`.

- **cat.itacademy.s04.t02.n02.repository**  
  Interface `FruitRepository` extending `JpaRepository` to perform database operations.

- **cat.itacademy.s04.t02.n02.services**  
  `FruitService` class contains business logic for adding, updating, deleting, and retrieving fruits. It includes validations to prevent duplicates and handle missing elements.

- **cat.itacademy.s04.t02.n02.controller**  
  REST controller `FruitController` exposing endpoints to interact with the API.

- **cat.itacademy.s04.t02.n02.exceptions**  
  Custom exception classes: `NotFoundException`, `AlreadyExistException`, and `GlobalExceptionHandler` to manage exceptions globally.

---

## Available Endpoints

| Method | URL                     | Description                     | Expected HTTP Response Codes              |
|--------|-------------------------|---------------------------------|------------------------------------------|
| POST   | `/fruit/add`             | Add a new fruit                 | 201 Created / 409 Conflict (if exists)   |
| PUT    | `/fruit/update`          | Update an existing fruit        | 200 OK / 404 Not Found                    |
| DELETE | `/fruit/delete/{id}`     | Delete a fruit by ID            | 204 No Content / 404 Not Found            |
| GET    | `/fruit/getOne/{id}`     | Get a fruit by ID               | 200 OK / 404 Not Found                    |
| GET    | `/fruit/getAll`          | Get all fruits                 | 200 OK                                   |

---

## Exception Handling

- **NotFoundException:** thrown when attempting to update, delete, or retrieve a fruit by a non-existing ID.  
- **AlreadyExistException:** thrown when attempting to create a fruit with a name that already exists.  
- **GlobalExceptionHandler:** centralizes exception handling and returns JSON responses containing timestamp, message, path, status, and appropriate HTTP error type.

---

## Build and Run with Docker

The project includes a `Dockerfile` to build the application image and a `docker-compose.yml` file that runs two containers:

- `s402-api-rest-mysql` service for the Spring Boot application.
- `mysql` service with MySQL and persistent volume.

### Commands to start the app

```bash````
docker-compose build
docker-compose up

## Additional Information

- **The API will be available at:**  
  `http://localhost:8080`

- **MySQL listens on port:**  
  `3307`

---

## Resources Used

- [Spring Boot Guide - Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)  
- [Baeldung - Exception Handling in Spring Boot](https://www.baeldung.com/exception-handling-for-rest-with-spring)  
- [Docker Documentation - Docker Compose](https://docs.docker.com/compose/)

---

## Final Notes

- The API follows REST best practices, including proper HTTP status codes usage.  
- Global exception handling standardizes error responses across the app.  
- Data persistence is handled with MySQL, configured via `application.properties`, and fully dockerized for easy deployment.  
- The codebase follows layered architecture (model, repository, service, controller) for maintainability and scalability.


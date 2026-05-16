# Project: Calculadora REST (calculadoraspring)

Simple RESTful API for basic mathematical operations built with Spring Boot.

## Project Overview

- **Purpose:** Provide a calculator service via REST endpoints.
- **Type:** Java / Spring Boot Web Application.
- **Primary Technologies:**
  - Java 17
  - Spring Boot (Parent version 4.0.3 - *Note: This version is unconventional as of current standards*)
  - Spring Web MVC
  - Maven
  - Lombok (for DTOs and boilerplate reduction)
  - JUnit 5 (for testing)

## Architecture

The project follows a standard Spring Boot architecture:
- **Controllers:** `cl.usm.calculadoraspring.controllers` - Handles incoming HTTP requests.
- **Services:** `cl.usm.calculadoraspring.services` - Contains the business logic for calculations.
- **Entities/DTOs:** `cl.usm.calculadoraspring.entities` - Data structures for requests (e.g., `CalculadoraRequest`).

## Building and Running

This project uses the Maven Wrapper (`mvnw`).

- **Build:**
  ```bash
  ./mvnw clean install
  ```
- **Run:**
  ```bash
  ./mvnw spring-boot:run
  ```
- **Test:**
  ```bash
  ./mvnw test
  ```

## Development Conventions

- **REST API:**
  - Endpoint: `POST /calcular`
  - Request Body: JSON with `operation`, `n1`, and `n2`.
  - Supported Operations: `+`, `-`, `*`, `/`.
- **Error Handling:** Returns `400 Bad Request` for invalid operations or division by zero, and `500 Internal Server Error` for other exceptions.
- **Testing:**
  - Unit tests are located in `src/test/java`.
  - Service tests focus on logic (manual instantiation of service).
  - Controller tests (noted in file structure) focus on endpoint behavior.
- **Lombok:** Used for getters, setters, and constructors in entity classes. Ensure your IDE has the Lombok plugin installed.

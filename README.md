# Project Name

Welcome this section is documentation of the API developed with Spring and Java back-end technologies. This API follows the hexagonal architecture and has been developed following Test Driven Development (TDD) practices, making use of patterns such as DTO (Data Transfer Object) and employing the Builder design pattern.

## Project Summary

The project uses Spring Boot for back-end development and Java as the main language. Hexagonal architecture, also known as port and adapter architecture, has been followed to facilitate separation of concerns and promote clean and maintainable code.

## Tecnologías Utilizadas

<details>
<summary><b>Spring Boot</b></summary>
  Framework de aplicación de Java para crear servicios web.
</details>

<details>
<summary><b>Java</b></summary>
  Lenguaje de programación principal.
</details>

<details>
<summary><b>JUnit y Mockito</b></summary>
  Utilizados para realizar pruebas unitarias y seguir la metodología TDD.
</details>

## Project Structure

The project structure follows the hexagonal architecture, dividing responsibilities into layers:

- **Domain:** Contains the business logic and domain entities.
- Application: **Implements use cases and orchestrates the business logic.
- Adapters:** Contains adapters for the user interface, databases and other external services.


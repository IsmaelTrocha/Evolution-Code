# Nombre del Proyecto

Bienvenido este apartado es documentación de la API desarrollada con tecnologías de back-end Spring y Java. Esta API sigue la arquitectura hexagonal y ha sido desarrollada siguiendo prácticas de Desarrollo Dirigido por Pruebas (TDD), haciendo uso de patrones como DTO (Data Transfer Object) y empleando el patrón de diseño Builder.

## Resumen del Proyecto

El proyecto utiliza Spring Boot para el desarrollo del back-end y Java como lenguaje principal. La arquitectura hexagonal, también conocida como arquitectura de puertos y adaptadores, se ha seguido para facilitar la separación de preocupaciones y promover un código limpio y mantenible.

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

## Estructura del Proyecto

La estructura del proyecto sigue la arquitectura hexagonal, dividiendo las responsabilidades en capas:

- **Dominio:** Contiene la lógica de negocio y las entidades del dominio.
- **Aplicación:** Implementa casos de uso y orquesta la lógica de negocio.
- **Adaptadores:** Contiene adaptadores para la interfaz de usuario, bases de datos y otros servicios externos.


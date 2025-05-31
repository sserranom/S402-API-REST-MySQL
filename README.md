# S04T02N02 - CRUD REST API con Spring Boot y MySQL

## Descripción

Este proyecto es una aplicación REST API desarrollada en Java con Spring Boot que implementa operaciones CRUD para gestionar una entidad `Fruit`. Los datos se almacenan en una base de datos MySQL. La aplicación sigue buenas prácticas de diseño de APIs REST, incluyendo un manejo global de excepciones para mejorar la robustez y la claridad en las respuestas de error.

---

## Tecnologías utilizadas

- Java 17 (o superior)
- Spring Boot (última versión estable)
- Spring Web
- Spring Data JPA
- MySQL
- Docker & Docker Compose
- Maven

---

## Estructura del proyecto

- **cat.itacademy.s04.t02.n02.model**  
  Contiene la entidad `Fruit` que representa la tabla en la base de datos con los atributos `id`, `name` y `quilsQuantity`.

- **cat.itacademy.s04.t02.n02.repository**  
  Interface `FruitRepository` que extiende `JpaRepository` para realizar operaciones sobre la base de datos.

- **cat.itacademy.s04.t02.n02.services**  
  Clase `FruitService` que contiene la lógica de negocio para añadir, actualizar, borrar y obtener frutas. Incluye validaciones para evitar duplicados y manejar elementos no encontrados.

- **cat.itacademy.s04.t02.n02.controller**  
  Controlador REST `FruitController` que expone los endpoints para interactuar con la API.

- **cat.itacademy.s04.t02.n02.exceptions**  
  Clases para manejo de excepciones personalizadas: `NotFoundException`, `AlreadyExistException` y `GlobalExceptionHandler` para gestionar errores globalmente.

---

## Endpoints disponibles

| Método | URL                   | Descripción                         | Código respuesta esperado             |
|--------|-----------------------|-----------------------------------|-------------------------------------|
| POST   | `/fruit/add`           | Añadir una nueva fruta             | 201 Created / 409 Conflict (si existe) |
| PUT    | `/fruit/update`        | Actualizar fruta existente         | 200 OK / 404 Not Found                |
| DELETE | `/fruit/delete/{id}`   | Eliminar fruta por ID              | 204 No Content / 404 Not Found       |
| GET    | `/fruit/getOne/{id}`   | Obtener fruta por ID               | 200 OK / 404 Not Found                |
| GET    | `/fruit/getAll`        | Obtener todas las frutas           | 200 OK                              |

---

## Manejo de excepciones

- **NotFoundException:** lanzada cuando se intenta actualizar, borrar o consultar un ID que no existe.  
- **AlreadyExistException:** lanzada cuando se intenta crear una fruta con un nombre que ya está registrado.  
- **GlobalExceptionHandler:** centraliza el manejo de excepciones y responde con JSON que incluye timestamp, mensaje, path, status y tipo de error HTTP adecuado.

---

## Construcción y ejecución con Docker

El proyecto incluye un `Dockerfile` para construir la imagen de la aplicación y un archivo `docker-compose.yml` que levanta dos contenedores:

- Servicio `s402-api-rest-mysql` para la aplicación Spring Boot.
- Servicio `mysql` con MySQL y volumen persistente.

### Comandos para levantar la app

```bash
docker-compose build
docker-compose up

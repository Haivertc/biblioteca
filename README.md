# Sistema de Gestión de Préstamos - Biblioteca UPTC Sogamoso

Este proyecto implementa un sistema de gestión de préstamos de material bibliográfico para la biblioteca de la UPTC Seccional Sogamoso. Está desarrollado con Spring Boot, utilizando JPA para la persistencia y desplegado con una base de datos en la nube (Supabase). Además, la API está documentada con Swagger.

## 👤 Autor

- **Nombre:** Haiver Trujillo
- **Materia:** Electiva 2
- **Tipo de entrega:** Parcial práctico
- **Universidad:** UPTC - Seccional Sogamoso

---

## 📌 Descripción

La aplicación permite:

- Registrar préstamos de libros por parte de los usuarios.
- Consultar qué usuarios tienen préstamos con retardo en la devolución.
- Buscar recursos por diferentes criterios (nombre, tipo, disponibilidad, etc.).
- Ver listados de los préstamos activos.
- Controlar y registrar devoluciones de los materiales.

---

## 🛠️ Tecnologías utilizadas

- Java 17
- Spring Boot 3
- Spring Data JPA
- PostgreSQL (Supabase)
- Maven
- Swagger (Springdoc OpenAPI)
- Git y GitHub

---

## 🧩 Diagrama de Clases

A continuación se presenta el diagrama de clases que ilustra los objetos del sistema y sus relaciones:

![Diagrama de clases](ruta/a/tu/diagrama.png)

> 💡 Reemplaza `` con la ruta correcta donde subas tu imagen en el repositorio.

---

## 🌐 Documentación de la API

Puedes explorar y probar todos los endpoints de la API desde Swagger:

🔗 [http://localhost:8080/swagger-ui/index.html#/](http://localhost:8080/swagger-ui/index.html#/)

---

## 🚀 Configuración del proyecto

Asegúrate de configurar las variables de conexión a la base de datos Supabase en tu archivo `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://aws-0-us-east-2.pooler.supabase.com:6543/postgres?user=postgres.hpbciebrlddtizykrzgk
spring.datasource.username=postgres
spring.datasource.password=biblioteca
spring.jpa.hibernate.ddl-auto=update
springdoc.swagger-ui.path=/swagger-ui.html

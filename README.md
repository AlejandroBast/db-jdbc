# db-jdbc

Proyecto Java con JDBC para gestionar estudiantes en una base de datos MySQL desde consola.

## Requisitos

- Java 25
- Maven 3.9+
- MySQL 8+

## Configuración rápida

1. Crear la base de datos y tablas ejecutando el script:
   - `src/main/resources/mysql_database.sql`
2. Revisar credenciales en:
   - `src/main/resources/db.properties`
3. Ajustar `db.url`, `db.user` y `db.password` según tu entorno.

## Ejecutar el proyecto

Desde la raíz del proyecto:

```bash
mvn clean compile
mvn exec:java
```

## Menú disponible

- Insertar estudiante
- Listar estudiantes
- Salir

## Estructura principal

- `src/main/java/Main.java`: punto de entrada.
- `src/main/java/connection/DatabaseConnection.java`: conexión JDBC usando `db.properties`.
- `src/main/java/dao/StudentDAO.java`: operaciones de inserción y listado.
- `src/main/java/menu/mainMenu.java`: menú en consola.
- `src/main/java/model/Student.java`: modelo de estudiante.

## Nota

El archivo `src/main/resources/sql_server_database.sql` está vacío actualmente.

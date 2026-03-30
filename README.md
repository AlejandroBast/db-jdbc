# Hospital MongoDB

Proyecto en Java con MongoDB para manejar operaciones CRUD desde consola.

## Requisitos

- Java 25
- Maven 3.9+
- MongoDB en local

## Configuración

Revisa este archivo y cambia los datos si necesitas:

- src/main/resources/mongo.properties

## Ejecutar

Desde la raíz del proyecto:

```bash
mvn clean compile
mvn exec:java
```

## Colecciones

- Consultas
- Habitaciones
- Hospitalizaciones
- Medicos
- Pacientes
- Tratamientos

## Operaciones disponibles

- Crear
- Listar
- Actualizar
- Eliminar

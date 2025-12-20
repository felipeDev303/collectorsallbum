# 📚 Collectors Album API

Sistema de gestión de álbumes de colección desarrollado con Spring Boot. Esta API permite administrar álbumes, láminas, realizar carga masiva y generar reportes de faltantes y repetidas para coleccionistas.

## 📋 Tabla de Contenidos

- [Descripción del Proyecto](#-descripción-del-proyecto)
- [Tecnologías Utilizadas](#-tecnologías-utilizadas)
- [Seguimiento del Proyecto](#-seguimiento-del-proyecto)
- [Endpoints de la API](#-endpoints-de-la-api)
- [Configuración del Entorno](#-configuración-del-entorno)

---

## 🎯 Descripción del Proyecto

**Collectors Album API** es una solución backend diseñada para resolver la gestión de colecciones de láminas.

- ✅ **Automatización:** Genera espacios vacíos automáticamente al crear un álbum.
- ✅ **Integridad:** Validaciones de datos con Bean Validation (IL2).
- ✅ **Eficiencia:** Consultas optimizadas a nivel de base de datos (IL4).
- ✅ **Auditoría:** Registro de fechas de creación de registros.

---

## 🛠️ Tecnologías Utilizadas

| Tecnología        | Propósito                                    |
| ----------------- | -------------------------------------------- |
| **Java 21**       | Lenguaje de programación                     |
| **Spring Boot**   | Framework principal (3.x)                    |
| **PostgreSQL**    | Base de datos actual (En transición a MySQL) |
| **Lombok**        | Reducción de código boilerplate              |
| **JPA/Hibernate** | Mapeo objeto-relacional y persistencia       |
| **Maven**         | Gestión de dependencias y construcción       |

---

## 📊 Seguimiento del Proyecto

**Última Actualización:** 19 de diciembre de 2025  
**Estado General:** 🟢 Completamente Funcional con todas las funcionalidades core implementadas

### Estado de Sprints

- **Sprint 1 (Cimientos):** [██████████] 100% ✅ - Proyecto configurado, BD conectada, CRUD completo
- **Sprint 2 (Lógica):** [██████████] 100% ✅ - Generación automática, queries optimizadas, reportes
- **Sprint 3 (Entrega):** [████████░░] 80% ⚠️ - Validaciones completas, manejo de errores, falta testing

### 📈 Progreso por Componente

| Componente                   | Estado       | Completado |
| ---------------------------- | ------------ | ---------- |
| **Arquitectura MVC**         | ✅ Completo  | 100%       |
| **Modelos con Validaciones** | ✅ Completo  | 100%       |
| **Repositorios JPA**         | ✅ Completo  | 100%       |
| **Servicios Optimizados**    | ✅ Completo  | 100%       |
| **Controladores REST**       | ✅ Completo  | 100%       |
| **Manejo de Errores**        | ✅ Completo  | 100%       |
| **Testing**                  | ❌ Pendiente | 0%         |

### ✅ Funcionalidades Implementadas

- [x] **Arquitectura MVC** completa (Controller-Service-Repository-Model)
- [x] **Validaciones completas**:
  - Album: `@NotBlank` en nombre, `@NotNull` en fecha, `@Min(1)` en totalLaminas
  - Lamina: `@NotBlank` en nombre, `@NotNull` y `@Min` en numero y cantidad
- [x] **Relaciones JPA**: Album ↔ Lamina con cascada
- [x] **Consultas Optimizadas**: Queries a nivel de repositorio (no filtros en memoria)
- [x] **Generación Automática**: Al crear álbum se generan sus láminas con cantidad=0
- [x] **CRUD Completo**: POST, GET (all/by ID), DELETE para álbumes
- [x] **Carga Masiva** de láminas (batch processing)
- [x] **Reportes**: Endpoints para láminas faltantes y repetidas
- [x] **Manejo de Errores Global**: `@ControllerAdvice` con respuestas JSON consistentes
- [x] **Excepciones Personalizadas**: `ResourceNotFoundException` para 404
- [x] **Lombok**: Reducción de boilerplate con `@Data`

### 🎯 Mejoras Pendientes

1. **ALTA** - Testing

   - Implementar tests unitarios para servicios
   - Implementar tests de integración para controladores
   - Cobertura mínima recomendada: 70%

2. **MEDIA** - Documentación

   - Agregar ejemplos de request/response en Swagger
   - Documentar códigos de error en README
   - Crear colección Postman

3. **MEDIA** - Seguridad

   - Externalizar credenciales a variables de entorno
   - Considerar agregar Spring Security (opcional)

4. **BAJA** - Optimizaciones
   - Resolver warnings de null safety (análisis estático)
   - Actualizar Spring Boot 3.5.8 → 3.5.9
   - Agregar índices en columnas frecuentemente consultadas

### 🏆 Logros Recientes

- ✅ Campo `totalLaminas` agregado en Album
- ✅ Validaciones completas en ambos modelos
- ✅ `@ControllerAdvice` con manejo global de errores
- ✅ CRUD completo con GET by ID y DELETE
- ✅ Métodos de servicio optimizados con queries directas
- ✅ Verificación de existencia antes de operaciones críticas

---

## 🌐 Endpoints de la API

### Gestión de Álbumes

| Método   | Endpoint            | Descripción                              | Códigos |
| -------- | ------------------- | ---------------------------------------- | ------- |
| `POST`   | `/api/albumes`      | Crea un álbum y genera sus láminas       | 200/400 |
| `GET`    | `/api/albumes`      | Lista todos los álbumes                  | 200     |
| `GET`    | `/api/albumes/{id}` | Obtiene un álbum específico              | 200/404 |
| `DELETE` | `/api/albumes/{id}` | Elimina un álbum y sus láminas (cascada) | 204/404 |

### Gestión de Láminas

| Método | Endpoint                            | Descripción              | Códigos |
| ------ | ----------------------------------- | ------------------------ | ------- |
| `POST` | `/api/albumes/laminas/carga-masiva` | Carga masiva de láminas  | 200/400 |
| `GET`  | `/api/albumes/{id}/faltantes`       | Láminas con cantidad = 0 | 200/404 |
| `GET`  | `/api/albumes/{id}/repetidas`       | Láminas con cantidad > 1 | 200/404 |

### Códigos de Respuesta

- **200 OK**: Operación exitosa
- **204 No Content**: Eliminación exitosa
- **400 Bad Request**: Error de validación
- **404 Not Found**: Recurso no encontrado
- **500 Internal Server Error**: Error del servidor

---

## ⚙️ Configuración del Entorno

### 1. Requisitos

- JDK 21
- PostgreSQL (Base de datos: `collectorsallbumdb`)
- Maven

### 2. Base de Datos

```sql
CREATE DATABASE collectorsallbumdb;
```

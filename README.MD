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
**Estado General:** 🟢 Funcional con optimizaciones aplicadas

### Estado de Sprints

- **Sprint 1 (Cimientos):** [██████████] 100% ✅ - Proyecto configurado, BD conectada, CRUD de álbumes funcionando
- **Sprint 2 (Lógica):** [████████░░] 85% ⚠️ - Generación automática implementada, falta campo `totalLaminas` en Album
- **Sprint 3 (Entrega):** [██░░░░░░░░] 20% 🚧 - Validaciones parciales, sin manejo de errores global ni testing

### 📈 Progreso por Componente

| Componente                   | Estado         | Completado |
| ---------------------------- | -------------- | ---------- |
| **Arquitectura MVC**         | ✅ Completo    | 100%       |
| **Modelos con Validaciones** | ⚠️ Parcial     | 70%        |
| **Repositorios JPA**         | ✅ Completo    | 100%       |
| **Servicios Optimizados**    | ⚠️ Con errores | 75%        |
| **Controladores REST**       | ✅ Funcional   | 90%        |
| **Manejo de Errores**        | ❌ Falta       | 0%         |
| **Testing**                  | ❌ Falta       | 0%         |

### ✅ Funcionalidades Implementadas

- [x] **Arquitectura MVC** completa (Controller-Service-Repository-Model)
- [x] **Validaciones en Album**: `@NotBlank` en nombre, `@NotNull` en fecha
- [x] **Relaciones JPA**: Album ↔ Lamina con cascada
- [x] **Consultas Optimizadas**: Métodos `findByAlbumIdAndCantidad()` y `findByAlbumIdAndCantidadGreaterThan()`
- [x] **Carga Masiva** de láminas (batch processing)
- [x] **Reportes**: Endpoints para láminas faltantes (cantidad=0) y repetidas (cantidad>1)
- [x] **Lombok**: Reducción de boilerplate con `@Data`
- [x] **Auditoría**: `@CreatedDate` en entidades (preparado)

### ⚠️ Problemas Actuales

1. **CRÍTICO** - Falta campo `totalLaminas` en modelo Album
   - Error: `The method getTotalLaminas() is undefined for the type Album`
   - Impacto: Generación automática de láminas no funciona
2. **ALTA** - Sin validaciones en modelo Lamina
   - Falta: `@NotBlank`, `@Min`, `@NotNull`
3. **ALTA** - Sin manejo global de excepciones
   - Falta: `@ControllerAdvice` para respuestas de error consistentes
4. **MEDIA** - Endpoints CRUD incompletos

   - Falta: `GET /api/albumes/{id}` y `DELETE /api/albumes/{id}`

5. **BAJA** - Warning de null safety en AlbumService línea 74

### 🎯 Próximos Pasos

1. Agregar campo `totalLaminas` en Album.java
2. Agregar validaciones en Lamina.java
3. Implementar @ControllerAdvice para manejo de errores
4. Completar endpoints GET by ID y DELETE
5. Crear tests unitarios básicos

---

## 🌐 Endpoints de la API

### Gestión de Álbumes

- `POST /api/albumes` : Crea un álbum y genera sus láminas automáticamente.
- `GET /api/albumes` : Lista todos los álbumes registrados.

### Gestión de Láminas

- `POST /api/albumes/laminas/carga-masiva` : Carga un listado de láminas mediante JSON.
- `GET /api/albumes/{id}/faltantes` : Devuelve láminas con cantidad = 0.
- `GET /api/albumes/{id}/repetidas` : Devuelve láminas con cantidad > 1.

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

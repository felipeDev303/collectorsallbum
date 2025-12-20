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

| Tecnología      | Propósito                               |
| --------------- | --------------------------------------- |
| **Java 21** | Lenguaje de programación                |
| **Spring Boot** | Framework principal (3.x)               |
| **PostgreSQL** | Base de datos actual (En transición a MySQL) |
| **Lombok** | Reducción de código boilerplate         |
| **JPA/Hibernate**| Mapeo objeto-relacional y persistencia |
| **Maven** | Gestión de dependencias y construcción  |

---

## 📊 Seguimiento del Proyecto

### Estado de Sprints
- **Sprint 1 (Cimientos):** [██████████] 100% - CRUD de álbumes y conexión a BD.
- **Sprint 2 (Lógica):** [██████████] 100% - Generación automática de slots y reportes.
- **Sprint 3 (Entrega):** [██░░░░░░░░] 20% - Multimedia e Informe Final.

### ✅ Hitos Logrados
- [x] Configuración de arquitectura MVC (Controller-Service-Repository).
- [x] Lógica de **Generación Automática**: Al crear álbum, se crean sus láminas con cantidad 0.
- [x] Implementación de **Carga Masiva** de láminas.
- [x] Filtros de **Faltantes y Repetidas** optimizados en Repositorio.
- [x] Uso de **Lombok** para limpieza de código.

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
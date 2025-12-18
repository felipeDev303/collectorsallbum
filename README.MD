# 📚 Collectors Album API

Sistema de gestión de álbumes de colección desarrollado con Spring Boot. Permite administrar álbumes, láminas, realizar carga masiva de láminas y generar reportes de faltantes y repetidas.

## 📋 Tabla de Contenidos

- [Descripción del Proyecto](#descripción-del-proyecto)
- [Tecnologías Utilizadas](#tecnologías-utilizadas)
- [Seguimiento del Proyecto](#seguimiento-del-proyecto)
- [Configuración del Entorno](#configuración-del-entorno)
- [Metodología de Trabajo](#metodología-de-trabajo)
- [Planificación de Sprints](#planificación-de-sprints)
- [Endpoints de la API](#endpoints-de-la-api)
- [Testing](#testing)
- [Contribuir](#contribuir)

---

## 🎯 Descripción del Proyecto

**Collectors Album API** es una aplicación backend RESTful que permite:

- ✅ Crear y gestionar álbumes de colección
- ✅ Generar automáticamente espacios para láminas al crear un álbum
- ✅ Realizar carga masiva de láminas (batch processing)
- ✅ Consultar láminas faltantes y repetidas
- ✅ Subir imágenes asociadas a las láminas
- ✅ Documentación interactiva con Swagger/OpenAPI

**Nota:** Este proyecto no incluye frontend ni sistema de autenticación, enfocándose 100% en la robustez de la API.

---

## 🛠️ Tecnologías Utilizadas

| Tecnología      | Versión | Propósito                       |
| --------------- | ------- | ------------------------------- |
| Java            | 21      | Lenguaje de programación        |
| Spring Boot     | 3.5.8   | Framework principal             |
| Spring Data JPA | -       | Persistencia de datos           |
| PostgreSQL      | 8.x     | Base de datos                   |
| Lombok          | -       | Reducción de código boilerplate |
| Validation      | -       | Validación de datos             |
| Swagger/OpenAPI | -       | Documentación de API            |
| JUnit/Mockito   | -       | Testing                         |
| Maven           | -       | Gestión de dependencias         |

---

## 📊 Seguimiento del Proyecto

### Estado General del Proyecto

**Inicio:** 18 de diciembre de 2025  
**Duración:** 9 días (3 Sprints de 3 días)  
**Progreso Global:** 11% (3/27 tareas completadas)  
**Última actualización:** 18 de diciembre de 2025

### Progress Dashboard

```
Sprint 1: [███░░░░░░░] 3/9 tareas   - Cimientos y Gestión de Álbumes (EN PROGRESO)
Sprint 2: [░░░░░░░░░░] 0/9 tareas   - Lógica de Negocio (Láminas)
Sprint 3: [░░░░░░░░░░] 0/9 tareas   - Multimedia, Testing y Documentación
```

### 🏆 Hitos Completados

- [ ] **Hito 1:** API funcional con CRUD de Álbumes
- [ ] **Hito 2:** Sistema de láminas con carga masiva funcionando
- [ ] **Hito 3:** Proyecto completo con documentación y tests

---

## ⚙️ Configuración del Entorno

### Prerrequisitos

- Java JDK 21
- PostgreSQL 
- Maven 3.6+
- Git
- Postman (para pruebas)

### Instalación

1. **Clonar el repositorio**

```bash
git clone https://github.com/felipeDev303/collectorsallbum.git
cd collectorsallbum
```

2. **Configurar la base de datos**

```sql
CREATE DATABASE coleccion_db;
CREATE USER coleccion_user WITH PASSWORD 'tu_password';
GRANT ALL PRIVILEGES ON DATABASE coleccion_db TO coleccion_user;
```

3. **Configurar application.properties**

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/coleccion_db
spring.datasource.username=coleccion_user
spring.datasource.password=tu_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

4. **Ejecutar la aplicación**

```bash
mvn clean install
mvn spring-boot:run
```

5. **Acceder a Swagger UI**

```
http://localhost:8080/swagger-ui.html
```

---

## 🔄 Metodología de Trabajo

### Git Flow Simplificado

```
main (Código estable y funcional)
  ↑
  └── feature/setup-infra
  └── feature/album-crud
  └── feature/lamina-logic
  └── feature/images-docs
```

### Reglas de Trabajo

1. **Rama main:** Solo código estable y testeado
2. **Ramas feature/\*:** Una rama por funcionalidad o Sprint
3. **Pull Requests:** Revisión obligatoria antes de merge
4. **Commits:** Pequeños y descriptivos
5. **Testing:** Todas las funcionalidades deben estar testeadas

### Ejemplo de Flujo de Trabajo

```bash
# Crear nueva rama para funcionalidad
git checkout -b feature/album-crud

# Realizar cambios y commits
git add .
git commit -m "feat: add Album entity and repository"

# Subir cambios
git push origin feature/album-crud

# Crear Pull Request en GitHub
# Después de revisión: Merge a main
```

---

## 📅 Planificación de Sprints

### 🚀 SPRINT 1: Cimientos y Gestión de Álbumes

**Objetivo:** Proyecto configurado, conectado a BD y gestión de Álbum funcionando

#### 📆 Día 1: Configuración e Infraestructura

**Rama:** `feature/setup-infra`

**Tareas:**

- [x] Inicializar proyecto en Spring Initializr
- [x] Crear repositorio en GitHub
- [x] Configurar `application.properties`
- [ ] Crear base de datos `coleccion_db` en PostgreSQL
- [ ] Configurar Swagger/OpenAPI
- [ ] Verificar que corre en localhost:8080

**Entregable:** ✅ Proyecto corriendo y Swagger UI visible

**Checklist de Validación:**

- [x] El proyecto compila sin errores
- [ ] Swagger UI accesible en `/swagger-ui.html`
- [ ] Conexión a PostgreSQL exitosa

---

#### 📆 Día 2: Dominio Álbum (CRUD Básico)

**Rama:** `feature/album-crud`

**Tareas:**

- [ ] Crear entidad `Album` (id, nombre, fecha, totalLaminas)
- [ ] Crear `AlbumRepository` extendiendo JpaRepository
- [ ] Crear `AlbumService` con métodos CRUD
  - [ ] Crear álbum
  - [ ] Listar todos los álbumes
  - [ ] Buscar por ID
  - [ ] Eliminar álbum
- [ ] Crear `AlbumController` con endpoints REST
- [ ] Agregar anotaciones de Lombok (@Data, @Entity, etc.)

**Entregable:** ✅ API CRUD de Álbumes funcional

**Endpoints Implementados:**

- [ ] POST `/api/albums` - Crear álbum
- [ ] GET `/api/albums` - Listar álbumes
- [ ] GET `/api/albums/{id}` - Obtener por ID
- [ ] DELETE `/api/albums/{id}` - Eliminar álbum

---

#### 📆 Día 3: Pruebas de Sprint 1 y Merge

**PR:** `#1 - Setup e Infraestructura + CRUD Álbumes`

**Tareas:**

- [ ] Agregar validaciones (@NotNull, @NotBlank en Album)
- [ ] Validar que nombre del álbum no sea vacío
- [ ] Validar que totalLaminas sea mayor a 0
- [ ] Pruebas manuales en Postman de todos los endpoints
- [ ] Crear Postman Collection v1.0
- [ ] Documentar request/response examples
- [ ] Crear Pull Request y revisar código
- [ ] Merge a `main`

**Entregable:** 🎯 **HITO 1 COMPLETADO** - API funcional con CRUD de Álbumes

**Criterios de Aceptación:**

- [ ] Todos los endpoints responden correctamente
- [ ] Validaciones funcionando
- [ ] PR aprobado y mergeado

---

### 🔧 SPRINT 2: Lógica de Negocio (Láminas)

**Objetivo:** Manejar creación automática de espacios y control de repetidas

#### 📆 Día 4: Entidad Lámina y Generación Automática

**Rama:** `feature/lamina-logic`

**Tareas:**

- [ ] Crear entidad `Lamina` con relación @ManyToOne a Album
  - [ ] Campos: id, numero, cantidad, urlImagen, album
- [ ] Modificar `AlbumService` para generar láminas automáticamente
  - [ ] Al crear álbum, crear N registros de Lamina (1 a totalLaminas)
  - [ ] Inicializar cantidad = 0 en todas
- [ ] Crear `LaminaRepository`
- [ ] Crear endpoint GET `/api/albums/{id}/laminas`

**Entregable:** ✅ Lógica de slots vacíos automática

**Validaciones Clave:**

- [ ] Al crear álbum con 50 láminas, se crean 50 registros
- [ ] Todas las láminas inician con cantidad = 0
- [ ] Relación bidireccional Album-Lamina funciona

---

#### 📆 Día 5: Carga Masiva (Batch Processing)

**Rama:** `feature/lamina-logic` (continúa)

**Tareas:**

- [ ] Crear DTO `BatchLaminasDTO` (lista de Integers)
- [ ] Crear `LaminaService` con lógica de carga masiva
  - [ ] Recibir lista de números [5, 10, 10, 20]
  - [ ] Por cada número, hacer cantidad++
  - [ ] Manejar duplicados en la lista
- [ ] Crear endpoint POST `/api/albums/{id}/laminas/batch`
- [ ] Validar que los números estén dentro del rango del álbum
- [ ] Retornar resumen: agregadas, actualizadas, errores

**Entregable:** ✅ Endpoint de carga masiva funcional

**Casos de Prueba:**

- [ ] Cargar [1, 2, 3] suma correctamente
- [ ] Cargar [1, 1, 1] suma 3 a la lámina 1
- [ ] Cargar [999] con álbum de 500 retorna error
- [ ] Cargar lista vacía retorna mensaje apropiado

---

#### 📆 Día 6: Reportes y Consultas JPA

**PR:** `#2 - Lógica de Láminas y Batch Processing`

**Tareas:**

- [ ] Crear queries en `LaminaRepository`
  - [ ] `findByAlbumIdAndCantidad(Long albumId, int cantidad)`
  - [ ] `findByAlbumIdAndCantidadGreaterThan(Long albumId, int cantidad)`
- [ ] Endpoint GET `/api/albums/{id}/laminas/faltantes`
- [ ] Endpoint GET `/api/albums/{id}/laminas/repetidas`
- [ ] Agregar estadísticas: total faltantes, total repetidas
- [ ] Pruebas en Postman de escenario completo
- [ ] Crear Pull Request
- [ ] Merge a `main`

**Entregable:** 🎯 **HITO 2 COMPLETADO** - Sistema útil con reportes

**Flujo de Prueba Completo:**

1. [ ] Crear álbum de 100 láminas
2. [ ] Cargar batch [1, 5, 5, 10, 20]
3. [ ] Verificar faltantes (debería mostrar 96)
4. [ ] Verificar repetidas (debería mostrar solo la 5)

---

### 🎨 SPRINT 3: Multimedia, Testing y Documentación

**Objetivo:** Refinamiento, manejo de imágenes y entrega final

#### 📆 Día 7: Gestión de Imágenes (Upload)

**Rama:** `feature/images-docs`

**Tareas:**

- [ ] Crear carpeta `uploads/` en el proyecto
- [ ] Crear `FileStorageService`
  - [ ] Método para guardar archivo
  - [ ] Validar tipo de archivo (jpg, png)
  - [ ] Generar nombre único
- [ ] Endpoint POST `/api/laminas/{id}/imagen`
- [ ] Endpoint GET `/uploads/{filename}` (servir imagen)
- [ ] Actualizar entidad Lamina con campo urlImagen
- [ ] Configurar resource handler en Spring

**Entregable:** ✅ Sistema de almacenamiento de imágenes

**Validaciones:**

- [ ] Solo acepta imágenes (jpg, png, gif)
- [ ] Tamaño máximo 5MB
- [ ] Las imágenes se pueden visualizar en navegador

---

#### 📆 Día 8: Pruebas Unitarias y Escenarios

**Rama:** `feature/images-docs` (continúa)

**Tareas:**

- [ ] Test unitarios con JUnit/Mockito
  - [ ] `AlbumServiceTest`: Probar creación de álbum
  - [ ] `LaminaServiceTest`: Probar carga masiva
  - [ ] Probar casos edge (números fuera de rango)
- [ ] Test de integración
  - [ ] `AlbumControllerTest`
  - [ ] `LaminaControllerTest`
- [ ] Ejecutar batería completa en Postman
- [ ] Capturar screenshots de Swagger
- [ ] Capturar screenshots de Postman
- [ ] Documentar request/response en PDF

**Entregable:** ✅ Tests en verde y evidencias

**Coverage Esperado:**

- [ ] Servicios: 80%+ cobertura
- [ ] Controllers: 70%+ cobertura
- [ ] Casos edge cubiertos

---

#### 📆 Día 9: Documentación y Cierre

**PR:** `#3 - Imágenes, Tests y Documentación Final`

**Tareas:**

- [ ] Revisar y mejorar descripciones en Swagger
  - [ ] Agregar @Operation en cada endpoint
  - [ ] Documentar parámetros y responses
- [ ] Actualizar este README.md con:
  - [ ] Instrucciones de instalación
  - [ ] Ejemplos de uso
  - [ ] Lista completa de endpoints
- [ ] Crear documento PDF de entrega
  - [ ] Arquitectura del proyecto
  - [ ] Screenshots de Postman
  - [ ] Diagramas de BD
- [ ] Crear Pull Request final
- [ ] Merge a `main`
- [ ] Crear tag v1.0.0

**Entregable:** 🎯 **HITO 3 COMPLETADO** - Proyecto terminado

**Checklist Final:**

- [ ] Todos los PRs mergeados
- [ ] Tests pasando (100%)
- [ ] Documentación completa
- [ ] Postman Collection exportada
- [ ] PDF de entrega generado
- [ ] Repositorio limpio y ordenado

---

## 🌐 Endpoints de la API

### Álbumes

| Método | Endpoint           | Descripción              | Estado |
| ------ | ------------------ | ------------------------ | ------ |
| POST   | `/api/albums`      | Crear nuevo álbum        | ⏳     |
| GET    | `/api/albums`      | Listar todos los álbumes | ⏳     |
| GET    | `/api/albums/{id}` | Obtener álbum por ID     | ⏳     |
| DELETE | `/api/albums/{id}` | Eliminar álbum           | ⏳     |

### Láminas

| Método | Endpoint                             | Descripción                | Estado |
| ------ | ------------------------------------ | -------------------------- | ------ |
| GET    | `/api/albums/{id}/laminas`           | Listar láminas de un álbum | ⏳     |
| POST   | `/api/albums/{id}/laminas/batch`     | Carga masiva de láminas    | ⏳     |
| GET    | `/api/albums/{id}/laminas/faltantes` | Listar láminas faltantes   | ⏳     |
| GET    | `/api/albums/{id}/laminas/repetidas` | Listar láminas repetidas   | ⏳     |
| POST   | `/api/laminas/{id}/imagen`           | Subir imagen de lámina     | ⏳     |
| GET    | `/uploads/{filename}`                | Obtener imagen             | ⏳     |

**Leyenda:** ✅ Completado | 🚧 En progreso | ⏳ Pendiente

---

## 🧪 Testing

### Ejecutar Tests

```bash
# Todos los tests
mvn test

# Tests específicos
mvn test -Dtest=AlbumServiceTest

# Con coverage
mvn clean test jacoco:report
```

### Estrategia de Testing

1. **Tests Unitarios:** Servicios y lógica de negocio
2. **Tests de Integración:** Controllers y repositorios
3. **Tests Manuales:** Postman Collection

---

## 💡 Consejos y Buenas Prácticas

### ✅ Do's

- ✅ Usa Lombok para reducir código boilerplate
- ✅ Usa DTOs, no expongas entidades directamente
- ✅ Commits pequeños y descriptivos
- ✅ Documenta endpoints en Swagger
- ✅ Prueba cada funcionalidad antes del PR

### ❌ Don'ts

- ❌ No hagas commits enormes
- ❌ No expongas entidades JPA en controllers
- ❌ No te atasques en un problema más de 30 minutos
- ❌ No hagas merge a main sin PR
- ❌ No dejes código comentado en producción

---

## 📞 Contribuir

1. Fork el proyecto
2. Crea una rama (`git checkout -b feature/nueva-funcionalidad`)
3. Commit tus cambios (`git commit -m 'feat: agregar nueva funcionalidad'`)
4. Push a la rama (`git push origin feature/nueva-funcionalidad`)
5. Abre un Pull Request

---

## 📝 Registro de Cambios

### [Unreleased]

- Proyecto en desarrollo

### Sprint 1 (Días 1-3)

- [ ] Configuración inicial del proyecto
- [ ] Implementación CRUD de Álbumes

### Sprint 2 (Días 4-6)

- [ ] Lógica de láminas y generación automática
- [ ] Sistema de carga masiva (batch)
- [ ] Reportes de faltantes y repetidas

### Sprint 3 (Días 7-9)

- [ ] Gestión de imágenes
- [ ] Tests unitarios y de integración
- [ ] Documentación final

---

## 📄 Licencia

Este proyecto es parte de un ejercicio académico/profesional.

---

## 👨‍💻 Autor

**Felipe Dev**

- GitHub: [@felipeDev303](https://github.com/felipeDev303)
- Proyecto: [collectorsallbum](https://github.com/felipeDev303/collectorsallbum)

---

## 🎯 Resumen de Entregables

| Día | Foco     | Entregable Clave               | Estado |
| --- | -------- | ------------------------------ | ------ |
| 1   | Setup    | Repo Git + Swagger funcionando | ⏳     |
| 2   | Álbum    | API CRUD de Álbumes lista      | ⏳     |
| 3   | Calidad  | PR #1 + Postman Collection v1  | ⏳     |
| 4   | Láminas  | Lógica de slots vacíos         | ⏳     |
| 5   | Lógica   | Endpoint de carga masiva       | ⏳     |
| 6   | Reportes | PR #2 + Faltantes/Repetidas    | ⏳     |
| 7   | Imágenes | Sistema de almacenamiento      | ⏳     |
| 8   | Testing  | Tests + Screenshots            | ⏳     |
| 9   | Cierre   | PR #3 + Documentación final    | ⏳     |

---

**🚀 ¡Manos a la obra! Actualiza este README conforme avances en el proyecto.**

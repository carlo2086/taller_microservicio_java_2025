Arquitectura en microservicios 

Flujo típico de arranque
Config Server → 2) Service Discovery → 3) API Gateway → 4) Servicios de negocio (curso, docente, semestre).

## 1) Resumen de la arquitectura

Arquitectura de **microservicios** sobre **Spring (Boot/Cloud)** con tres bloques principales:

* **Configuración centralizada**: *Spring Cloud Config Server* (servidor) + repositorio de configuración (archivos `yml/properties`).
* **Descubrimiento de servicios**: *Service Discovery* (p. ej., Eureka Server) para registro y localización dinámica.
* **API Gateway**: *Spring Cloud Gateway* que actúa como punto único de entrada, ruteando hacia los microservicios de dominio.
* **Servicios de dominio**: `gestion-curso`, `gestion-docente`, `gestion-semestre` (cada uno independiente, con su propia capa web y acceso a datos).

**Tráfico**: *Cliente* → **Gateway** → (usa **Discovery** para resolver destinos) → **Servicios**. Todos los servicios leen su configuración desde **Config Server** al arrancar.

---
Arquitectura de microservicios basada en Spring Cloud, con estos patrones/blocks:
- API Gateway como punto de entrada (carpeta ms-administration-gateway).
- Service Discovery (tipo Eureka Server) para registro/descubrimiento (ms-administration-server-record).
- Configuración centralizada con Spring Cloud Config Server (ms-administration-server-configuration) y su repo de configs (ms-administration-data-configuration).
- Servicios de dominio independientes (curso, docente, semestre), cada uno con su propio esquema/datos (scripts BD_*.sql).
- 
## 2) Diagrama (Mermaid)

```mermaid
flowchart LR
    subgraph Client[Cliente]
      UI[SPA / Postman / curl]
    end

    UI -->|HTTP| GW[API Gateway]

    subgraph Platform[Plataforma]
      CFG[Config Server]
      DISC[(Service Discovery)]
    end

    subgraph Domain[Servicios de dominio]
      C1[ms-negocio-gestion-curso]
      D1[ms-negocio-gestion-docente]
      S1[ms-negocio-gestion-semestre]
    end

    %% Ruteo
    GW -->|/api/cursos/**| C1
    GW -->|/api/docentes/**| D1
    GW -->|/api/semestres/**| S1

    %% Descubrimiento
    C1 <--> DISC
    D1 <--> DISC
    S1 <--> DISC
    GW <--> DISC

    %% Configuración
    C1 -. lee .-> CFG
    D1 -. lee .-> CFG
    S1 -. lee .-> CFG
    GW -. lee .-> CFG
```

> Si lo prefieres en PlantUML, se puede agregar una versión equivalente.

---

## 3) Estructura sugerida de módulos

```
root/
├─ ms-administration-server-configuration/   # Config Server
├─ ms-administration-data-configuration/     # Archivos de configuración (git repo)
├─ ms-administration-server-record/          # Service Discovery (Eureka)
├─ ms-administration-gateway/                # Spring Cloud Gateway
├─ ms-negocio-gestion-curso/                 # Servicio de dominio: cursos
├─ ms-negocio-gestion-docente/               # Servicio de dominio: docentes
└─ ms-negocio-gestion-semestre/              # Servicio de dominio: semestres
```

---

## 4) Orden de arranque recomendado

1. **Config Server**
2. **Service Discovery**
3. **API Gateway**
4. **Servicios de dominio** (`curso`, `docente`, `semestre`)

> Esto asegura que los servicios obtengan configuración y puedan registrarse antes de exponer rutas vía gateway.

---

## 5) Puertos & variables de entorno (ejemplo)

> Adapta estos valores a tu entorno real.

* **Config Server**: `PORT=8888`
* **Service Discovery (Eureka)**: `PORT=8761`
* **Gateway**: `PORT=8080`
* **Servicios**: `8091` (curso), `8092` (docente), `8093` (semestre)

Variables de entorno comunes:

```bash
# Config Server\ nSPRING_PROFILES_ACTIVE=native  # o git
SERVER_PORT=8888

# Eureka Server\ nSERVER_PORT=8761
EUREKA_CLIENT_REGISTER_WITH_EUREKA=false
EUREKA_CLIENT_FETCH_REGISTRY=false

# Gateway\ nSERVER_PORT=8080
SPRING_CLOUD_CONFIG_URI=http://localhost:8888
EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://localhost:8761/eureka/

# Servicios de dominio (ejemplo curso)
SERVER_PORT=8091
SPRING_CLOUD_CONFIG_URI=http://localhost:8888
EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://localhost:8761/eureka/
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/taller
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=postgres
```

---

## 6) Nombres de configuración (convención típica)

En `ms-administration-data-configuration` (repo de configs), se suelen tener archivos como:

```
application.yml                         # Configs compartidas
ms-administration-gateway.yml           # Config del gateway
ms-administration-server-record.yml     # Config del discovery
ms-negocio-gestion-curso.yml            # Config del servicio curso
ms-negocio-gestion-docente.yml          # Config del servicio docente
ms-negocio-gestion-semestre.yml         # Config del servicio semestre
```

Con perfiles por entorno:

```
ms-negocio-gestion-curso-dev.yml
ms-negocio-gestion-curso-qa.yml
ms-negocio-gestion-curso-prod.yml
```

> Los nombres exactos dependen del `spring.application.name` de cada módulo.

---


## 7) Endpoints útiles y verificación

* **Eureka Dashboard**: `http://localhost:8761`
* **Gateway (health)**: `http://localhost:8080/actuator/health`
* **Servicios (health)**: `http://localhost:8091/actuator/health` (y 8092, 8093)

**Smoke tests** (si existen controladores base):

```bash
# Cursos
curl http://localhost:8080/api/cursos

# Docentes
curl http://localhost:8080/api/docentes

# Semestres
curl http://localhost:8080/api/semestres
```

---

## 8) Notas sobre base de datos

* Ejecuta los scripts SQL `BD_CURSO.sql`, `BD_DOCENTE.sql`, `BD_SEMESTRE.sql` en tu motor (p. ej., PostgreSQL).
* Asegura variables `SPRING_DATASOURCE_*` por servicio.
* Recomendado: crear bases/esquemas separados por servicio y usar migraciones (Flyway/Liquibase) en cada microservicio.

---

## 9) Observabilidad (opcional recomendado)

* **Actuator** en todos los servicios (`/actuator/health`, `/actuator/info`).
* **Tracing**: Spring Cloud Sleuth / Micrometer Tracing + OpenTelemetry Collector.
* **Logs** estructurados (JSON) y correlación via `traceId`/`spanId` propagados por el Gateway.

---

## 10) Seguridad (opcional recomendado)

* Autenticación/autorización en el **Gateway** (Spring Security + JWT, OAuth2).
* Policies de CORS en el Gateway.
* *Rate limiting* y filtros de auditoría.


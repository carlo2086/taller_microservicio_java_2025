Arquitectura en microservicios 

Flujo típico de arranque
Config Server → 2) Service Discovery → 3) API Gateway → 4) Servicios de negocio (curso, docente, semestre).

Arquitectura de microservicios basada en Spring Cloud, con estos patrones/blocks:
- API Gateway como punto de entrada (carpeta ms-administration-gateway).
- Service Discovery (tipo Eureka Server) para registro/descubrimiento (ms-administration-server-record).
- Configuración centralizada con Spring Cloud Config Server (ms-administration-server-configuration) y su repo de configs (ms-administration-data-configuration).
- Servicios de dominio independientes (curso, docente, semestre), cada uno con su propio esquema/datos (scripts BD_*.sql).

-- Database: BD_DOCENTE

-- DROP DATABASE IF EXISTS "BD_DOCENTE";

CREATE DATABASE "BD_DOCENTE"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Peru.1252'
    LC_CTYPE = 'Spanish_Peru.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
	

create schema sys;


CREATE SEQUENCE IF NOT EXISTS sys.docente_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE sys.docente_id_seq
    OWNER TO postgres;
	



CREATE TABLE IF NOT EXISTS sys.docente
(
    id_docente integer NOT NULL DEFAULT nextval('sys.docente_id_seq'::regclass),
    nombre character varying(100) COLLATE pg_catalog."default",
    ap_paterno character varying(100) COLLATE pg_catalog."default",
    ap_materno character varying(100) COLLATE pg_catalog."default",
    url character varying(100) COLLATE pg_catalog."default",
    correo character varying(100) COLLATE pg_catalog."default",
    direccion character varying(100) COLLATE pg_catalog."default",
    dni character varying(8) COLLATE pg_catalog."default",
    CONSTRAINT docente_pkey PRIMARY KEY (id_docente)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS sys.docente
    OWNER to postgres;
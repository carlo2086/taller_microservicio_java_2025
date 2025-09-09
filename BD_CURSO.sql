-- Database: BD_CURSO

-- DROP DATABASE IF EXISTS "BD_CURSO";

CREATE DATABASE "BD_CURSO"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Peru.1252'
    LC_CTYPE = 'Spanish_Peru.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
	
	create schema sys;
	
	CREATE SEQUENCE IF NOT EXISTS sys.curso_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE sys.curso_id_seq
    OWNER TO postgres;
	

CREATE TABLE IF NOT EXISTS sys.curso
(
    id_curso integer NOT NULL DEFAULT nextval('sys.curso_id_seq'::regclass),
    nombre character varying(100) COLLATE pg_catalog."default",
    credito integer,
    id_docente integer,
    CONSTRAINT curso_pkey PRIMARY KEY (id_curso)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS sys.curso
    OWNER to postgres;
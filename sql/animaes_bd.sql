/*Crear la base de datos con el nombre "animaes_bd" */
CREATE DATABASE animaes_bd
  WITH OWNER = animaes;

\connect animaes_bd

CREATE TABLE usuario(
id_usuario SERIAL PRIMARY KEY,
username VARCHAR(20) UNIQUE NOT NULL,
password VARCHAR(32) NOT NULL,
correo VARCHAR(20) UNIQUE NOT NULL,
fecha_de_registro TIMESTAMP NOT NULL
);

CREATE TABLE administrador(
id_admin SERIAL PRIMARY KEY,
id_usuario INTEGER REFERENCES usuario(id_usuario) ON DELETE CASCADE UNIQUE NOT NULL
);

CREATE TABLE grado(
id_grado SERIAL PRIMARY KEY,
nombre VARCHAR(50) NOT NULL
);

CREATE TABLE estudiante(
id_estudiante SERIAL PRIMARY KEY,
id_usuario INTEGER REFERENCES usuario(id_usuario) ON DELETE CASCADE UNIQUE NOT NULL,
nombre VARCHAR(20) NOT NULL,
apellido_pat VARCHAR(20) NOT NULL,
apellido_mat VARCHAR(20) NOT NULL,
edad INTEGER NOT NULL,
grado INTEGER REFERENCES grado(id_grado) ON DELETE CASCADE NOT NULL 
);

CREATE TABLE asignatura(
id_asignatura SERIAL PRIMARY KEY,
nombre VARCHAR(50) NOT NULL,
grado INTEGER REFERENCES grado(id_grado) ON DELETE CASCADE NOT NULL
);

CREATE TABLE imagen(
id_imagen SERIAL PRIMARY KEY,
id_estudiante INTEGER REFERENCES estudiante(id_estudiante) ON DELETE CASCADE UNIQUE NOT NULL,
imagen BYTEA NOT NULL,
nombre VARCHAR(20) NOT NULL
);

CREATE TABLE juego(
id_juego SERIAL PRIMARY KEY,
tema VARCHAR(128) NOT NULL,
asignatura INTEGER REFERENCES asignatura(id_asignatura) ON DELETE CASCADE NOT NULL,
ruta VARCHAR(256) UNIQUE NOT NULL,
nombre VARCHAR(128) NOT NULL,
autor VARCHAR(128) NOT NULL,
version VARCHAR(32) NOT NULL,
descripcion TEXT NOT NULL,
publicado BOOLEAN NOT NULL,
id_admin INTEGER REFERENCES administrador(id_admin) ON DELETE CASCADE NOT NULL, 
fecha_registro TIMESTAMP NOT NULL
);

CREATE TABLE comentario(
id_comentario SERIAL PRIMARY KEY,
id_estudiante INTEGER REFERENCES estudiante(id_estudiante) ON DELETE CASCADE NOT NULL,
id_juego INTEGER REFERENCES juego(id_juego) ON DELETE CASCADE NOT NULL,
fecha TIMESTAMP NOT NULL
);

CREATE TABLE favorito(
id_favorito SERIAL PRIMARY KEY,
id_estudiante INTEGER REFERENCES estudiante(id_estudiante) ON DELETE CASCADE NOT NULL,
id_juego INTEGER REFERENCES juego(id_juego) ON DELETE CASCADE NOT NULL
);

CREATE TABLE juego_estudiante(
id_juego_estudiante SERIAL PRIMARY KEY,
id_estudiante INTEGER REFERENCES estudiante(id_estudiante) ON DELETE CASCADE NOT NULL,
id_juego INTEGER REFERENCES juego(id_juego) ON DELETE CASCADE NOT NULL,
fecha TIMESTAMP NOT NULL
);



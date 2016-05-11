/*Crear la base de datos con el nombre "PVJuegos*/
/*CREATE DATABASE "PVJuegos"
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Spanish_Mexico.1252'
       LC_CTYPE = 'Spanish_Mexico.1252'
       CONNECTION LIMIT = -1;*/

CREATE TABLE Administrador(
id_admin SERIAL PRIMARY KEY,
username_admin varchar(20) NOT NULL,
password_admin varchar(50) NOT NULL,
nombre_admin varchar(30) NOT NULL
);

CREATE TABLE Usuario(
id_usuario SERIAL PRIMARY KEY,
id_admin integer,
username_usuario varchar(20) NOT NULL,
password_usuario varchar(50) NOT NULL,
nombre_usuario varchar(30) NOT NULL,
tipo_usuario integer NOT NULL,
CONSTRAINT fk_usuario_idAdmin FOREIGN KEY (id_admin) REFERENCES Administrador (id_admin) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Estudiante(
id_estudiante SERIAL PRIMARY KEY,
id_usuario integer NOT NULL,
edad integer NOT NULL,
grado varchar(20) NULL,
CONSTRAINT fk_estudiante_idUsuario FOREIGN KEY (id_usuario) REFERENCES Usuario (id_usuario) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Asignatura(
id_asignatura SERIAL PRIMARY KEY,
nombre varchar(50) NOT NULL,
grado varchar(20) NOT NULL
);

CREATE TABLE Videojuego(
id_videojuego SERIAL PRIMARY KEY,
id_admin integer NOT NULL,
id_asignatura integer NOT NULL,
nombre_juego varchar(50) NOT NULL,
tamanio_juego bit[] NOT NULL,
nombre_autor varchar(30) NULL,
version_juego varchar(10) NOT NULL,
bool_publicar boolean NOT NULL,
descripcion varchar(200) NULL,
CONSTRAINT fk1_videojuego_idAdmin FOREIGN KEY (id_admin) REFERENCES Administrador (id_admin) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
CONSTRAINT fk2_videojuego_idAsignatura FOREIGN KEY (id_asignatura) REFERENCES Asignatura (id_asignatura) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Juegos(
id_juego SERIAL PRIMARY KEY,
id_usuario integer NOT NULL,
id_videojuego integer NOT NULL,
CONSTRAINT fk1_juego_idUsuario FOREIGN KEY (id_usuario) REFERENCES Usuario (id_usuario) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
CONSTRAINT fk2_juego_idVideojuego FOREIGN KEY (id_videojuego) REFERENCES Videojuego (id_videojuego) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE
);
/*Crear la base de datos con el nombre "PVJuegos*/
CREATE DATABASE "PVJuegos"
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Spanish_Mexico.1252'
       LC_CTYPE = 'Spanish_Mexico.1252'
       CONNECTION LIMIT = -1;

CREATE TABLE Administrador(
id_admin integer NOT NULL,
username_admin varchar(20) NOT NULL,
password_admin varchar(50) NOT NULL,
nombre_admin varchar(30) NOT NULL,
CONSTRAINT pk_admin PRIMARY KEY (id_admin)	
);

CREATE TABLE Usuario(
id_usuario integer NOT NULL,
id_admin integer NOT NULL,
username_usuario varchar(20) NOT NULL,
password_usuario varchar(50) NOT NULL,
nombre_usuario varchar(30) NOT NULL,
tipo_usuario integer NOT NULL,
CONSTRAINT pk_usuario PRIMARY KEY (id_usuario),
CONSTRAINT fk_usuario_idAdmin FOREIGN KEY (id_admin) REFERENCES Administrador (id_admin) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Estudiante(
id_estudiante integer NOT NULL,
id_usuario integer NOT NULL,
edad integer NOT NULL,
grado varchar(20) NULL,
CONSTRAINT pk_estudiante PRIMARY KEY (id_estudiante),
CONSTRAINT fk_estudiante_idUsuario FOREIGN KEY (id_usuario) REFERENCES Usuario (id_usuario) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Asignatura(
id_asignatura integer NOT NULL,
nombre varchar(50) NOT NULL,
grado varchar(20) NOT NULL,
CONSTRAINT pk_asignatura PRIMARY KEY (id_asignatura)
);

CREATE TABLE Videojuego(
id_videojuego integer NOT NULL,
id_admin integer NOT NULL,
id_asignatura integer NOT NULL,
nombre_juego varchar(50) NOT NULL,
tamanio_juego bit[] NOT NULL,
nombre_autor varchar(30) NULL,
version_juego varchar(10) NOT NULL,
bool_publicar boolean NOT NULL,
descripcion varchar(200) NULL,
CONSTRAINT pk_videojuego PRIMARY KEY (id_videojuego),
CONSTRAINT fk1_videojuego_idAdmin FOREIGN KEY (id_admin) REFERENCES Administrador (id_admin) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
CONSTRAINT fk2_videojuego_idAsignatura FOREIGN KEY (id_asignatura) REFERENCES Asignatura (id_asignatura) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Juegos(
id_juego integer NOT NULL,
id_usuario integer NOT NULL,
id_videojuego integer NOT NULL,
CONSTRAINT pk_juego PRIMARY KEY (id_juego),
CONSTRAINT fk1_juego_idUsuario FOREIGN KEY (id_usuario) REFERENCES Usuario (id_usuario) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
CONSTRAINT fk2_juego_idVideojuego FOREIGN KEY (id_videojuego) REFERENCES Videojuego (id_videojuego) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE
);
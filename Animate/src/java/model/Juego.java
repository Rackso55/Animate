package model;
// Generated Jun 3, 2016 5:58:00 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

/**
 * Juego generated by hbm2java
 */
@Entity
@Table(name="juego"
    ,schema="public"
    , uniqueConstraints = @UniqueConstraint(columnNames="ruta") 
)
public class Juego  implements java.io.Serializable {


     private int idJuego;
     private String version;
     private Administrador administrador;
     private Asignatura asignatura;
     private String tema;
     private String ruta;
     private String nombre;
     private String autor;
     private String descripcion;
     private boolean publicado;
     private Date fechaRegistro;
     private Set favoritos = new HashSet(0);
     private Set juegoEstudiantes = new HashSet(0);
     private Set comentarios = new HashSet(0);

    public Juego() {
    }

	
    public Juego(int idJuego, Administrador administrador, Asignatura asignatura, String tema, String ruta, String nombre, String autor, String descripcion, boolean publicado, Date fechaRegistro) {
        this.idJuego = idJuego;
        this.administrador = administrador;
        this.asignatura = asignatura;
        this.tema = tema;
        this.ruta = ruta;
        this.nombre = nombre;
        this.autor = autor;
        this.descripcion = descripcion;
        this.publicado = publicado;
        this.fechaRegistro = fechaRegistro;
    }
    public Juego(int idJuego, Administrador administrador, Asignatura asignatura, String tema, String ruta, String nombre, String autor, String descripcion, boolean publicado, Date fechaRegistro, Set favoritos, Set juegoEstudiantes, Set comentarios) {
       this.idJuego = idJuego;
       this.administrador = administrador;
       this.asignatura = asignatura;
       this.tema = tema;
       this.ruta = ruta;
       this.nombre = nombre;
       this.autor = autor;
       this.descripcion = descripcion;
       this.publicado = publicado;
       this.fechaRegistro = fechaRegistro;
       this.favoritos = favoritos;
       this.juegoEstudiantes = juegoEstudiantes;
       this.comentarios = comentarios;
    }
   
     @Id 

    
    @Column(name="id_juego", unique=true, nullable=false)
    public int getIdJuego() {
        return this.idJuego;
    }
    
    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }

    @Version
    @Column(name="version", nullable=false, length=32)
    public String getVersion() {
        return this.version;
    }
    
    public void setVersion(String version) {
        this.version = version;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_admin", nullable=false)
    public Administrador getAdministrador() {
        return this.administrador;
    }
    
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="asignatura", nullable=false)
    public Asignatura getAsignatura() {
        return this.asignatura;
    }
    
    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    
    @Column(name="tema", nullable=false, length=128)
    public String getTema() {
        return this.tema;
    }
    
    public void setTema(String tema) {
        this.tema = tema;
    }

    
    @Column(name="ruta", unique=true, nullable=false, length=256)
    public String getRuta() {
        return this.ruta;
    }
    
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    
    @Column(name="nombre", nullable=false, length=128)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="autor", nullable=false, length=128)
    public String getAutor() {
        return this.autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }

    
    @Column(name="descripcion", nullable=false)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    @Column(name="publicado", nullable=false)
    public boolean isPublicado() {
        return this.publicado;
    }
    
    public void setPublicado(boolean publicado) {
        this.publicado = publicado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_registro", nullable=false, length=29)
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }
    
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="juego")
    public Set getFavoritos() {
        return this.favoritos;
    }
    
    public void setFavoritos(Set favoritos) {
        this.favoritos = favoritos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="juego")
    public Set getJuegoEstudiantes() {
        return this.juegoEstudiantes;
    }
    
    public void setJuegoEstudiantes(Set juegoEstudiantes) {
        this.juegoEstudiantes = juegoEstudiantes;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="juego")
    public Set getComentarios() {
        return this.comentarios;
    }
    
    public void setComentarios(Set comentarios) {
        this.comentarios = comentarios;
    }




}



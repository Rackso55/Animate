package model;
// Generated Jun 3, 2016 5:58:00 PM by Hibernate Tools 4.3.1


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
import javax.persistence.UniqueConstraint;

/**
 * Estudiante generated by hbm2java
 */
@Entity
@Table(name="estudiante"
    ,schema="public"
    , uniqueConstraints = @UniqueConstraint(columnNames="id_usuario") 
)
public class Estudiante  implements java.io.Serializable {


     private int idEstudiante;
     private Grado grado;
     private Usuario usuario;
     private String nombre;
     private String apellidoPat;
     private String apellidoMat;
     private int edad;
     private Set favoritos = new HashSet(0);
     private Set imagens = new HashSet(0);
     private Set comentarios = new HashSet(0);
     private Set juegoEstudiantes = new HashSet(0);

    public Estudiante() {
    }

	
    public Estudiante(int idEstudiante, Grado grado, Usuario usuario, String nombre, String apellidoPat, String apellidoMat, int edad) {
        this.idEstudiante = idEstudiante;
        this.grado = grado;
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.edad = edad;
    }
    public Estudiante(int idEstudiante, Grado grado, Usuario usuario, String nombre, String apellidoPat, String apellidoMat, int edad, Set favoritos, Set imagens, Set comentarios, Set juegoEstudiantes) {
       this.idEstudiante = idEstudiante;
       this.grado = grado;
       this.usuario = usuario;
       this.nombre = nombre;
       this.apellidoPat = apellidoPat;
       this.apellidoMat = apellidoMat;
       this.edad = edad;
       this.favoritos = favoritos;
       this.imagens = imagens;
       this.comentarios = comentarios;
       this.juegoEstudiantes = juegoEstudiantes;
    }
   
     @Id 

    
    @Column(name="id_estudiante", unique=true, nullable=false)
    public int getIdEstudiante() {
        return this.idEstudiante;
    }
    
    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="grado", nullable=false)
    public Grado getGrado() {
        return this.grado;
    }
    
    public void setGrado(Grado grado) {
        this.grado = grado;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_usuario", unique=true, nullable=false)
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    @Column(name="nombre", nullable=false, length=20)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="apellido_pat", nullable=false, length=20)
    public String getApellidoPat() {
        return this.apellidoPat;
    }
    
    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    
    @Column(name="apellido_mat", nullable=false, length=20)
    public String getApellidoMat() {
        return this.apellidoMat;
    }
    
    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }

    
    @Column(name="edad", nullable=false)
    public int getEdad() {
        return this.edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="estudiante")
    public Set getFavoritos() {
        return this.favoritos;
    }
    
    public void setFavoritos(Set favoritos) {
        this.favoritos = favoritos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="estudiante")
    public Set getImagens() {
        return this.imagens;
    }
    
    public void setImagens(Set imagens) {
        this.imagens = imagens;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="estudiante")
    public Set getComentarios() {
        return this.comentarios;
    }
    
    public void setComentarios(Set comentarios) {
        this.comentarios = comentarios;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="estudiante")
    public Set getJuegoEstudiantes() {
        return this.juegoEstudiantes;
    }
    
    public void setJuegoEstudiantes(Set juegoEstudiantes) {
        this.juegoEstudiantes = juegoEstudiantes;
    }




}


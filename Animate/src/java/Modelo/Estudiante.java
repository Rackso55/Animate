package Modelo;
// Generated 9/05/2016 04:34:32 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Estudiante generated by hbm2java
 */
@Entity
@Table(name="estudiante"
    ,schema="public"
)
public class Estudiante  implements java.io.Serializable {


     private int idEstudiante;
     private Usuario usuario;
     private int edad;
     private String grado;

    public Estudiante() {
    }

	
    public Estudiante(int idEstudiante, Usuario usuario, int edad) {
        this.idEstudiante = idEstudiante;
        this.usuario = usuario;
        this.edad = edad;
    }
    public Estudiante(int idEstudiante, Usuario usuario, int edad, String grado) {
       this.idEstudiante = idEstudiante;
       this.usuario = usuario;
       this.edad = edad;
       this.grado = grado;
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
    @JoinColumn(name="id_usuario", nullable=false)
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    @Column(name="edad", nullable=false)
    public int getEdad() {
        return this.edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }

    
    @Column(name="grado", length=20)
    public String getGrado() {
        return this.grado;
    }
    
    public void setGrado(String grado) {
        this.grado = grado;
    }




}



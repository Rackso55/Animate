package Modelo;
// Generated 17/05/2016 01:23:43 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Asignatura generated by hbm2java
 */
@Entity
@Table(name="asignatura"
    ,schema="public"
)
public class Asignatura  implements java.io.Serializable {


     private int idAsignatura;
     private String nombre;
     private String grado;
     private Set videojuegos = new HashSet(0);

    public Asignatura() {
    }

	
    public Asignatura(int idAsignatura, String nombre, String grado) {
        this.idAsignatura = idAsignatura;
        this.nombre = nombre;
        this.grado = grado;
    }
    public Asignatura(int idAsignatura, String nombre, String grado, Set videojuegos) {
       this.idAsignatura = idAsignatura;
       this.nombre = nombre;
       this.grado = grado;
       this.videojuegos = videojuegos;
    }
   
     @Id 

    
    @Column(name="id_asignatura", unique=true, nullable=false)
    public int getIdAsignatura() {
        return this.idAsignatura;
    }
    
    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    
    @Column(name="nombre", nullable=false, length=50)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="grado", nullable=false, length=20)
    public String getGrado() {
        return this.grado;
    }
    
    public void setGrado(String grado) {
        this.grado = grado;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="asignatura")
    public Set getVideojuegos() {
        return this.videojuegos;
    }
    
    public void setVideojuegos(Set videojuegos) {
        this.videojuegos = videojuegos;
    }




}



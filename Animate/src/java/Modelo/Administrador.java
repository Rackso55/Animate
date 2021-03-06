package Modelo;
// Generated 9/05/2016 04:34:32 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Administrador generated by hbm2java
 */
@Entity
@Table(name="administrador"
    ,schema="public"
)
public class Administrador  implements java.io.Serializable {


     private int idAdmin;
     private String usernameAdmin;
     private String passwordAdmin;
     private String nombreAdmin;
     private Set videojuegos = new HashSet(0);
     private Set usuarios = new HashSet(0);

    public Administrador() {
    }

	
    public Administrador(int idAdmin, String usernameAdmin, String passwordAdmin, String nombreAdmin) {
        this.idAdmin = idAdmin;
        this.usernameAdmin = usernameAdmin;
        this.passwordAdmin = passwordAdmin;
        this.nombreAdmin = nombreAdmin;
    }
    public Administrador(int idAdmin, String usernameAdmin, String passwordAdmin, String nombreAdmin, Set videojuegos, Set usuarios) {
       this.idAdmin = idAdmin;
       this.usernameAdmin = usernameAdmin;
       this.passwordAdmin = passwordAdmin;
       this.nombreAdmin = nombreAdmin;
       this.videojuegos = videojuegos;
       this.usuarios = usuarios;
    }
   
     @Id 

    
    @Column(name="id_admin", unique=true, nullable=false)
    public int getIdAdmin() {
        return this.idAdmin;
    }
    
    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    
    @Column(name="username_admin", nullable=false, length=20)
    public String getUsernameAdmin() {
        return this.usernameAdmin;
    }
    
    public void setUsernameAdmin(String usernameAdmin) {
        this.usernameAdmin = usernameAdmin;
    }

    
    @Column(name="password_admin", nullable=false, length=50)
    public String getPasswordAdmin() {
        return this.passwordAdmin;
    }
    
    public void setPasswordAdmin(String passwordAdmin) {
        this.passwordAdmin = passwordAdmin;
    }

    
    @Column(name="nombre_admin", nullable=false, length=30)
    public String getNombreAdmin() {
        return this.nombreAdmin;
    }
    
    public void setNombreAdmin(String nombreAdmin) {
        this.nombreAdmin = nombreAdmin;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="administrador")
    public Set getVideojuegos() {
        return this.videojuegos;
    }
    
    public void setVideojuegos(Set videojuegos) {
        this.videojuegos = videojuegos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="administrador")
    public Set getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set usuarios) {
        this.usuarios = usuarios;
    }




}



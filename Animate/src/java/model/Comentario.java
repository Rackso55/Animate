package model;
// Generated Jun 3, 2016 5:58:00 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Comentario generated by hbm2java
 */
@Entity
@Table(name="comentario"
    ,schema="public"
)
public class Comentario  implements java.io.Serializable {


     private int idComentario;
     private Estudiante estudiante;
     private Juego juego;
     private Date fecha;

    public Comentario() {
    }

    public Comentario(int idComentario, Estudiante estudiante, Juego juego, Date fecha) {
       this.idComentario = idComentario;
       this.estudiante = estudiante;
       this.juego = juego;
       this.fecha = fecha;
    }
   
     @Id 

    
    @Column(name="id_comentario", unique=true, nullable=false)
    public int getIdComentario() {
        return this.idComentario;
    }
    
    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_estudiante", nullable=false)
    public Estudiante getEstudiante() {
        return this.estudiante;
    }
    
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_juego", nullable=false)
    public Juego getJuego() {
        return this.juego;
    }
    
    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha", nullable=false, length=29)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }




}



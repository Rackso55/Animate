package logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import model.Asignatura;
import model.Comentario;
import model.Estudiante;
import model.Juego;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Util;

public class JuegoL {
    
    private Session con;
    private Transaction trans;
    private List<Juego> juegos;
    private List<Comentario> comentarios;
        
    public List<Juego> getJuegos(Asignatura a) {
        try {
            if (con == null || !con.isOpen()) {
                con = Util.getSessionFactory().openSession();
            }
            Query q = con.createQuery("select j from Asignatura a join a.juegos j where "
                    + "a.idAsignatura = :id")
                    .setInteger("id", a.getIdAsignatura());
            juegos = q.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        return juegos;
    }
    
    public Asignatura getAsignatura(int id) {
        Asignatura a = null;
        try {
            if (con == null || !con.isOpen()) {
                con = Util.getSessionFactory().openSession();
            }
            a = (Asignatura)con.get(Asignatura.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            con.close();
            return a;
        }
    }
    
    public Juego getJuego(int id) {
        Juego a = null;
        try {
            if (con == null || !con.isOpen()) {
                con = Util.getSessionFactory().openSession();
            }
            a = (Juego)con.get(Juego.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            con.close();
            return a;
        }
    }
    
    public FacesMessage comentar(Comentario c) {
        FacesMessage mensaje = null;
        try {
            if (con == null || !con.isOpen())
                con = Util.getSessionFactory().openSession();
            trans = con.beginTransaction();
            con.save(c);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al publicar comentario", null);
            e.printStackTrace();
        } finally {
            con.close();
            return mensaje;
        }
        
    }
    
    public List<Comentario> getComentarios(Juego j) {
        try {
            if (con == null || !con.isOpen()) {
                con = Util.getSessionFactory().openSession();
            }
            Query q = con.createQuery("select c from Juego j join j.comentarios c where "
                    + "j.idJuego = :id")
                    .setInteger("id", j.getIdJuego());
            comentarios = q.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        return comentarios;
    }
}

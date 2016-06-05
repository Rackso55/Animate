/* Conexión relacionada a Grados */
package logic;

import java.util.List;
import model.Asignatura;
import model.Grado;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Util;

public class GradoL {

    private Session con;
    private Transaction trans;
    private List<Asignatura> asignaturas;

    /* Regresa el grado con el id dado */
    public Grado getGrado(int id) {
        try {
            if (con == null || !con.isOpen()) {
                con = Util.getSessionFactory().openSession();
            }
            trans = con.beginTransaction();
            /* Buscamos al Grado */
            Query q = con.createSQLQuery("select * from grado where "
                    + "id_grado = :id")
                    .addEntity(Grado.class)
                    .setInteger("id", id);
            return (Grado) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
        } finally {
            con.close();
        }
        return null;
    }

    /* Regresa el Grado con el nombre dado */
    public Grado getGrado(String nombre) {
        try {
            if (con == null || !con.isOpen()) {
                con = Util.getSessionFactory().openSession();
            }
            trans = con.beginTransaction();
            /* Buscamos al Grado */
            Query q = con.createSQLQuery("select * from grado where "
                    + "nombre like :nombre")
                    .addEntity(Grado.class)
                    .setString("nombre", nombre);
            return (Grado) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
        } finally {
            con.close();
        }
        return null;
    }

    public List<Asignatura> getAsignaturas(Grado g) {
        try {
            if (con == null || !con.isOpen()) {
                con = Util.getSessionFactory().openSession();
            }
            Query q = con.createQuery("select a from Grado g join g.asignaturas a where "
                    + "g.idGrado = :id")
                    .setInteger("id", g.getIdGrado());
            asignaturas = q.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return asignaturas;
    }

}

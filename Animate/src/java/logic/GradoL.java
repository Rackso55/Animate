/* Conexión relacionada a Grados */
package logic;

import model.Grado;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Util;

public class GradoL {

    private Session con;
    private Transaction trans;

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

}

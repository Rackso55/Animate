package logic;

import java.util.List;
import model.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;

import model.Usuario;
import util.Cripta;
import util.Util;
import model.Administrador;

public class SesionL {

    private Cripta encripta;
    private Session sesion;

    public Usuario verificarDatos(Usuario p) throws Exception {
        encripta = new Cripta();
        Usuario pa = null;
        try {
            if (sesion == null || !sesion.isOpen()) {
                sesion = Util.getSessionFactory().openSession();
            }
            String hql = "FROM Usuario WHERE username = '" + p.getUsername()
                    + "' and password = '" + encripta.encripta(p.getPassword()) + "'";
            Query query = sesion.createQuery(hql);
            if (!query.list().isEmpty()) {
                pa = (Usuario) query.list().get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sesion.close();
            return pa;
        }
    }

    public Usuario verificarDatosAdmin(Usuario u) throws Exception {
        encripta = new Cripta();
        Usuario adm = null;
        try {
            if (sesion == null || !sesion.isOpen()) {
                sesion = Util.getSessionFactory().openSession();
            }
            String hql = "FROM Usuario WHERE username = '" + u.getUsername()
                    + "' and password = '" + encripta.encripta(u.getPassword()) + "'";
            Query query = sesion.createQuery(hql);
            List<Usuario> l = query.list();
            if (!l.isEmpty()) {
                adm = l.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sesion.close();
            return adm;
        }
    }
    
    public boolean verificarTipo(Usuario u){
        boolean b = false;
        try {
            if (sesion == null || !sesion.isOpen()) {
                sesion = Util.getSessionFactory().openSession();
            }
            String hql = "FROM Usuario u join u.administradors a WHERE "
                    + "u.idUsuario = " + u.getIdUsuario();
            Query query = sesion.createQuery(hql);
            List<?> l = query.list();
            if (!l.isEmpty()) {
                b = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sesion.close();
            return b;
        }
    }

}

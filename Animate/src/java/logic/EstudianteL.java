package logic;

import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import model.Asignatura;
import model.Estudiante;
import model.Grado;
import model.Usuario;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Cripta;
import util.Util;

public class EstudianteL {

    private Session con;
    private Transaction trans;
    private Cripta cripta;
    private List<Grado> lstGrados;
    private List<Estudiante> lstEstudiantes;
    private List<Asignatura> lstAsignaturas;

    public FacesMessage registrar(Usuario u, Estudiante e, String confirmacion) {
        FacesMessage mensaje = null;
        if (!confirmacion.equals(u.getPassword())) {
            return new FacesMessage(FacesMessage.SEVERITY_INFO, "Las contraseñas no coinciden", null);
        }
        try {
            cripta = new Cripta();
            if (con == null || !con.isOpen()) {
                con = Util.getSessionFactory().openSession();
            }
            Query query = con.createQuery("from Usuario where correo = :correo");
            query.setParameter("correo", u.getCorreo());
            List<Usuario> l = query.list();
            if (!l.isEmpty()) {
                mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Este correo ya está registrado");
            } else {
                query = con.createQuery("from Usuario where username = :username");
                query.setParameter("username", u.getUsername());
                l = query.list();
                if (!l.isEmpty()) {
                    mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Este nombre de usuario ya está registrado");
                } else {
                    trans = con.beginTransaction();
                    u.setPassword(cripta.encripta(confirmacion));
                    Date fecha = new Date();
                    u.setFechaDeRegistro(fecha);
                    con.save(u);
                    e.setUsuario(u);
                    con.save(e);
                    trans.commit();
                }
            }
        } catch (Exception ex) {
            trans.rollback();
            mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al registrar estudiante", null);
            ex.printStackTrace();
        } finally {
            con.close();
            return mensaje;
        }
    }

    /* Modifica el perfil del estudiante que se pasa como parámetro */
    public void modifica(Estudiante es) {
        try {
            if (con == null || !con.isOpen()) {
                con = Util.getSessionFactory().openSession();
            }
            /* La transacción para modificar al estudiante */
            trans = con.beginTransaction();
            con.update(es);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
        } finally {
            con.close();
        }
    }

    public List<Grado> listarGrados() {
        try {
            if (con == null || !con.isOpen()) {
                con = Util.getSessionFactory().openSession();
            }
            Criteria cri = con.createCriteria(Grado.class);
            lstGrados = cri.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstGrados;
    }
    
    public List<Asignatura> listarAsignaturas() {
        try {
            if (con == null || !con.isOpen()) {
                con = Util.getSessionFactory().openSession();
            }
            Criteria cri = con.createCriteria(Asignatura.class);
            lstAsignaturas = cri.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstAsignaturas;
    }

    /* Regresa al estudiante con el id dado */
    public Estudiante getEstudiante(int id) {
        try {
            if (con == null || !con.isOpen()) {
                con = Util.getSessionFactory().openSession();
            }
            trans = con.beginTransaction();
            /* Buscamos al usuario */
            Query q = con.createSQLQuery("select * from estudiante where "
                    + "id_estudiante = :id")
                    .addEntity(Estudiante.class)
                    .setInteger("id", id);
            return (Estudiante) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
        } finally {
            con.close();
        }
        return null;
    }
    
     /* Regresa al estudiante asociado al usuario */
    public Estudiante getEstudiante(Usuario u) {
        Estudiante e = null;
        try {
            if (con == null || !con.isOpen()) {
                con = Util.getSessionFactory().openSession();
            }
            Query q = con.createQuery("select e from Estudiante e join e.usuario u where "
                    + "u.idUsuario = :id")
                    .setInteger("id", u.getIdUsuario());
            e = (Estudiante) q.uniqueResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            con.close();
            return e;
        }
    }
    
    public List<Estudiante> listarEstudiantes() {
        try {
            if (con == null || !con.isOpen()) {
                con = Util.getSessionFactory().openSession();
            }
            Criteria cri = con.createCriteria(Estudiante.class);
            lstEstudiantes = cri.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstEstudiantes;
    }

    public FacesMessage eliminaEstudiante(Estudiante e) {
        FacesMessage mensaje = null;
        try {
            if (con == null || !con.isOpen()) {
                con = Util.getSessionFactory().openSession();
            }
            Query q = con.createQuery("select u from Usuario u join "
                    + "u.estudiantes e where e.idEstudiante = :id")
                    .setInteger("id",e.getIdEstudiante());
            Usuario u = (Usuario) q.uniqueResult();
            trans = con.beginTransaction();
            con.delete(u);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
            mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Error", "Error al eliminar estudiante");
            ex.printStackTrace();
        } finally {
            con.close();
            return mensaje;
        }
    }
}

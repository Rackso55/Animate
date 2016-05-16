package Logica;

import Modelo.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;

import Modelo.Usuario;
import Utiles.Encriptacion;
import Utiles.HibernateUtil;
import Modelo.Administrador;


public class SesionL {
    private Encriptacion encripta;
    private Session sesion;

	public Usuario verificarDatos(Usuario p) throws Exception {
                encripta = new Encriptacion();
		Usuario pa = null;
                try {
			sesion = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Pasajero WHERE usernameUsuario = '" + p.getUsernameUsuario()
					+ "' and passwordUsuario = '" + encripta.encripta(p.getPasswordUsuario()) + "'";
			Query query = sesion.createQuery(hql);
			if (!query.list().isEmpty())
				pa = (Usuario) query.list().get(0);			

		} catch (Exception e) {
			throw e;
		}

		return pa;
	}
    
        	public Administrador verificarDatos(Administrador a) throws Exception {
                encripta = new Encriptacion();
		Administrador adm = null;
                try {
			sesion = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Pasajero WHERE usernameAdmin = '" + a.getUsernameAdmin()
					+ "' and passwordAdmin = '" + encripta.encripta(a.getPasswordAdmin()) + "'";
			Query query = sesion.createQuery(hql);
			if (!query.list().isEmpty())
				adm = (Administrador) query.list().get(0);			

		} catch (Exception e) {
			throw e;
		}

		return adm;
	}
}

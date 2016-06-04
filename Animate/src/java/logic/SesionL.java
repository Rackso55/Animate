package logic;

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
			sesion = Util.getSessionFactory().openSession();
			String hql = "FROM Usuario WHERE username = '" + p.getUsername()
					+ "' and password = '" + encripta.encripta(p.getPassword()) + "'";
			Query query = sesion.createQuery(hql);
			if (!query.list().isEmpty())
				pa = (Usuario) query.list().get(0);			

		} catch (Exception e) {
			throw e;
		}

		return pa;
	}
    
        	/*public Administrador verificarDatos(Administrador a) throws Exception {
                encripta = new Cripta();
		Administrador adm = null;
                try {
			sesion = Util.getSessionFactory().openSession();
			String hql = "FROM Pasajero WHERE usernameAdmin = '" + a.getUsernameAdmin()
					+ "' and passwordAdmin = '" + encripta.encripta(a.getPasswordAdmin()) + "'";
			Query query = sesion.createQuery(hql);
			if (!query.list().isEmpty())
				adm = (Administrador) query.list().get(0);			

		} catch (Exception e) {
			throw e;
		}

		return adm;
	}*/
}
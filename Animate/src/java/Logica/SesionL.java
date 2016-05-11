package Logica;

import Modelo.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;

import Modelo.Estudiante;
import Utiles.Encriptacion;
import Utiles.HibernateUtil;
import Modelo.Administrador;


public class SesionL {
    private Encriptacion encripta;
    private Session sesion;

	public Estudiante verificarDatos(Estudiante p) throws Exception {
                encripta = new Encriptacion();
		Estudiante pa = null;
		Usuario us = p.getUsuario();
                try {
			sesion = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Pasajero WHERE Pcorreo = '" + us.getUsernameUsuario()
					+ "' and Pcontrasenia = '" + encripta.encripta(us.getPasswordUsuario()) + "'";
			Query query = sesion.createQuery(hql);
			if (!query.list().isEmpty())
				pa = (Estudiante) query.list().get(0);			

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
			String hql = "FROM Pasajero WHERE Pcorreo = '" + a.getUsernameAdmin()
					+ "' and Pcontrasenia = '" + encripta.encripta(a.getPasswordAdmin()) + "'";
			Query query = sesion.createQuery(hql);
			if (!query.list().isEmpty())
				adm = (Administrador) query.list().get(0);			

		} catch (Exception e) {
			throw e;
		}

		return adm;
	}
}

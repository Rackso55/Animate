package Logica;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import org.hibernate.Session;
import Modelo.ConexionBD;
import Modelo.Estudiante;
import org.hibernate.Transaction;
import Utiles.Encriptacion;
import Modelo.Usuario;


public class EstudianteL implements Serializable{
    private Session con;
    private Transaction trans;

    
    public FacesMessage registrar(Estudiante es, Usuario usuario, String confirmacion){
        FacesMessage mensaje = null;
        try{
            System.out.println("inicia registro de estudiante");
            con = ConexionBD.getSessionFactory().openSession();
            System.out.println("Conexion realizadaaaaaaaaaaaaa, COMIENZA TRANSACCION");
            trans = con.beginTransaction();
            System.out.println("A PUNTO DE SALVAR ESTUDIANTE");
            con.save(usuario);
            es.setUsuario(usuario);
            con.save(es);
            trans.commit();
            System.out.println("Ya lo guardo!!!!");
        }catch(Exception e){
            trans.rollback();
            mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error con el registro del usuario", null);
            System.out.println("Esta es la excepcion "+e.getClass().getName());
            e.printStackTrace();
        }finally{
            con.close();
            return mensaje;
        }
     
    }
}


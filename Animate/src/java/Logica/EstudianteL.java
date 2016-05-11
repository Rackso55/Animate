package Logica;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import org.hibernate.Session;
import Modelo.ConexionBD;
import Modelo.Estudiante;
import org.hibernate.Transaction;
import Utiles.Encriptacion;


public class EstudianteL implements Serializable{
    private Session con;
    private Transaction trans;

    
    public FacesMessage registrar(Estudiante es, String confirmacion){
        FacesMessage mensaje = null;
        try{
            con = ConexionBD.getSessionFactory().openSession();
            System.out.println("Conexion realizada");
            trans = con.beginTransaction();
            con.save(es);
            trans.commit();
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


package Logica;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import org.hibernate.Session;
import Modelo.ConexionBD;
import Modelo.Usuario;
import org.hibernate.Transaction;
import Utiles.Encriptacion;


public class UsuarioL implements Serializable{
    private Session con;
    private Transaction trans;
    private Encriptacion cripta;
    


    
    public FacesMessage registrar(Usuario u, String confirmacion){
        FacesMessage mensaje = null;
        if(!confirmacion.equals(u.getPasswordUsuario())) 
                return new FacesMessage(FacesMessage.SEVERITY_INFO, "Las contraseñas no coinciden", null);
        System.out.println("\n\n\n\n\nComienza registro de usuario");
        try{
            cripta = new Encriptacion();
            con = ConexionBD.getSessionFactory().openSession();
            System.out.println("Conexion realizada");
            trans = con.beginTransaction();
            u.setPasswordUsuario(cripta.encripta(confirmacion));
            con.save(u);
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

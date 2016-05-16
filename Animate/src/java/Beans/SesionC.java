package Beans;

import javax.inject.Named;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import Logica.SesionL;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import Modelo.Estudiante;
import Modelo.Usuario;
import Modelo.Administrador;


@Named(value = "sesionC")
@SessionScoped
@ManagedBean
public class SesionC implements Serializable {

   private Usuario es = new Usuario();
   private boolean tipo;
   private FacesMessage mensaje;
   private Administrador a = new Administrador();



    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }
   
    public Usuario getEstudiante() {
        return es;
    }

    public void setEstudiante(Usuario es) {
        this.es = es;
    }

    public String verificarDatos() throws Exception {
        SesionL sl = new SesionL();
        String resultado;
        if(tipo == false) {
            Usuario est;
            try {
            est = sl.verificarDatos(this.es);
            if (est != null) {
                FacesContext.getCurrentInstance().getExternalContext()
                        .getSessionMap().put("usuario", est);
                resultado = "inicioUsuario";
                es = est;
            } else {
                mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario o contraseña incorrectos", null);
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
                resultado = "";
            }
           
            } catch (Exception e) {
            throw e;
            }
        } else {    
            Administrador adm;
            try {
            adm = sl.verificarDatos(this.a);
            if (adm != null) {
                FacesContext.getCurrentInstance().getExternalContext()
                        .getSessionMap().put("usuario", adm);
                resultado = "inicioAdmin";
                a = adm;
            } else {
                mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario o contraseña incorrectos", null);
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
                resultado = "";
            }
            } catch (Exception e) {
            throw e;
            }
        }
        return resultado;
    }

    public boolean verificarSesion() {
        boolean estado;
        if (FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().get("usuario") == null) {
            estado = false;
        } else {
            estado = true;
        }

        return estado;
    }

    public String cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext()
                .invalidateSession();
        /* is all of this necessary?*/
        es = null;
        a = null;
        return "PaginaPrincipal";
    }    
    
    public boolean verificarTipo() {
        String tipo = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario").getClass().getSimpleName();
        if(tipo.equals("Administrador"))
            return true;
        return false;
    }

        
}

package Beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import javax.faces.application.FacesMessage;

import Modelo.Usuario;
import Logica.UsuarioL;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpServletRequest;


@ManagedBean
@ViewScoped
public class UsuarioC implements Serializable {

    private Usuario usuario = new Usuario();
    private String confirmacion;
    private UsuarioL ayudante = new UsuarioL();
    private FacesMessage mensaje;
    private boolean exito;
    
    
    public UsuarioC() {
    }

    public boolean isExito() {
        return exito;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setPasajero(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String registro() {
        mensaje = ayudante.registrar(usuario,confirmacion);
        ayudante = new UsuarioL();
        if(mensaje != null) {
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
            return "";
        }
        mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Tu registro fue exitoso... Ya puedes iniciar sesión", null);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
        exito = true;
        System.out.println("Este es el valor de registro: "+exito);
        return "";
    }
    
    public void setConfirmacion(String contrasenia){
        confirmacion = contrasenia;
    }

    public String getConfirmacion() {
        return confirmacion;
    }
}

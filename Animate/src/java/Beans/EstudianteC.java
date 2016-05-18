package Beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import javax.faces.application.FacesMessage;

import Modelo.Estudiante;
import Modelo.Usuario;
import Logica.EstudianteL;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpServletRequest;


@ManagedBean
@ViewScoped
public class EstudianteC implements Serializable {

    private Estudiante est = new Estudiante();
    private String confirmacion;
    private Usuario usuario = new Usuario();
    private EstudianteL ayudante = new EstudianteL();
    private FacesMessage mensaje;
    private boolean exito;
    
    
    public EstudianteC() {
    }

    public boolean isExito() {
        return exito;
    }
    
    public Estudiante getEstudiante() {
        return est;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setEstudiante(Estudiante est) {
        this.est = est;
    }
    
    public String registro() {
        mensaje = ayudante.registrar(est, usuario, confirmacion);
        ayudante = new EstudianteL();
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


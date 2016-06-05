/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.IOException;
import javax.inject.Named;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import logic.SesionL;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import model.Estudiante;
import model.Usuario;
import model.Administrador;

@Named(value = "sesionC")
@SessionScoped
@ManagedBean
public class SesionC implements Serializable {

    private Usuario es = new Usuario();
    private boolean tipo;
    private FacesMessage mensaje;

    public Usuario getUsuario() {
        return es;
    }

    public void setUsuario(Usuario es) {
        this.es = es;
    }

    public String verificarDatos() throws Exception {
        SesionL sl = new SesionL();
        String resultado = "";
        if (tipo == false) {
            Usuario est;
            try {
                est = sl.verificarDatos(this.es);
                if (est != null) {
                    FacesContext.getCurrentInstance().getExternalContext()
                            .getSessionMap().put("usuario", est);
                    resultado = "index?faces-redirect=true";
                    es = est;
                } else {
                    mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario o contraseña incorrectos", null);
                    FacesContext.getCurrentInstance().addMessage(null, mensaje);
                    resultado = "";
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }

    public String verificarDatosAdmin() throws Exception {
        SesionL sl = new SesionL();
        String resultado = "";
        Usuario est;
        try {
            est = sl.verificarDatosAdmin(es);
            if (est != null) {
                FacesContext.getCurrentInstance().getExternalContext()
                        .getSessionMap().put("usuario", est);
                resultado = "InicioAdminIH?faces-redirect=true";
                es = est;
            } else {
                mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario o contraseña incorrectos", null);
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
                resultado = "";
            }

        } catch (Exception e) {
            e.printStackTrace();
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

    public void cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext()
                .invalidateSession();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //True si es admin
    public boolean verificarTipo() {
        SesionL sL = new SesionL();
        if(verificarSesion())
            return sL.verificarTipo(es);
        return false;
    }

}

package beans;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import logic.EstudianteL;
import model.Estudiante;
import model.Grado;
import model.Usuario;

@Named(value = "registroEstudianteC")
@ManagedBean
@RequestScoped
public class RegistroEstudianteC implements Serializable {

    Estudiante estudiante;
    Usuario usuario;
    EstudianteL ayudante;
    String confirmacion;
    FacesMessage mensaje;
    List<Grado> lstGrados;
    
    public RegistroEstudianteC() {
        estudiante = new Estudiante();
        usuario = new Usuario();
        ayudante = new EstudianteL();
        lstGrados = ayudante.listarGrados();
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(String confirmacion) {
        this.confirmacion = confirmacion;
    }

    public List<Grado> getLstGrados() {
        return lstGrados;
    }

    public void setLstGrados(List<Grado> lstGrados) {
        this.lstGrados = lstGrados;
    }
    
    public void registrar() {
        mensaje = ayudante.registrar(usuario, estudiante, confirmacion);
    }
}

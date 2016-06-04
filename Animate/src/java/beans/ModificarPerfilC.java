/* Controlador para modificar el perfil del Estudiante */
package beans;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import logic.EstudianteL;
import model.Estudiante;
import model.Grado;

@Named(value = "modificarPerfilC")
@ManagedBean
@RequestScoped
public class ModificarPerfilC {

    /* El estudiante a modificar */
    private Estudiante estudiante;
    /* Conexión con la base */
    private EstudianteL helper;
    /* Mensaje */
    private FacesMessage mensaje;
    /*Lista de los Grados disponibles en la base */
    private List<Grado> grados;

    /* Constructor */
    public ModificarPerfilC() {
        estudiante = (Estudiante) FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().get("usuario");
        helper = new EstudianteL();
        grados = helper.listarGrados();
    }

    /* Regresa la lista de Grados */
    public List<Grado> getGrados() {
        return grados;
    }

    /* Define la lista de Grados */
    public void setGrados(List<Grado> grados) {
        this.grados = grados;
    }

    /* Modifica el perfil del estudiante */
    public String modifica() {
        helper.modifica(this.estudiante);
        mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Datos actualizados con éxito", null);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
        return "index";
    }

    /* Nos regresa al estudiante */
    public Estudiante getEstudiante() {
        return estudiante;
    }

    /* Cambia al estudiante por el que se pasa en el parámetro */
    public void setEstudiante(Estudiante e) {
        this.estudiante = e;
    }

}

package beans;

import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import logic.EstudianteL;
import model.Estudiante;

@Named(value = "administrarEstudiantesC")
@ManagedBean
@ViewScoped
public class AdministrarEstudiantesC implements Serializable {

    private EstudianteL helper;
    private List<Estudiante> estudiantes;
    private FacesMessage mensaje;

    public AdministrarEstudiantesC() {
        helper = new EstudianteL();
        estudiantes = helper.listarEstudiantes();
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public void eliminaEstudiante(Estudiante e) {
        mensaje = helper.eliminaEstudiante(e);
        if (mensaje == null) {
            mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Exito", "Estudiante eliminado");
            estudiantes = helper.listarEstudiantes();
        }
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
}

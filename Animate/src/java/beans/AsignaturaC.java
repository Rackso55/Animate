package beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import logic.GradoL;
import model.Asignatura;
import model.Grado;

@Named(value = "asignaturaC")
@ViewScoped
@ManagedBean
public class AsignaturaC {

    Grado grado;
    GradoL helper;
    List<Asignatura> asignaturas;
    
    public AsignaturaC() {
        helper = new GradoL();
    }
    
    public void init() {
        int id = Integer.parseInt(FacesContext
                .getCurrentInstance().getExternalContext()
                .getRequestParameterMap().get("gradoId"));
        grado = helper.getGrado(id);
        asignaturas = helper.getAsignaturas(grado);
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }
    
}

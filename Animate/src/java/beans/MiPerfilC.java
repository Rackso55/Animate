package beans;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import logic.EstudianteL;
import logic.GradoL;
import model.Estudiante;
import model.Usuario;

@Named(value = "miPerfilC")
@ManagedBean
@RequestScoped
public class MiPerfilC {
    
    private Estudiante estudiante;
    private Usuario usuario;
    private EstudianteL helper;

    public MiPerfilC() {
        helper = new EstudianteL();
        usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().get("usuario");
        estudiante = helper.getEstudiante(usuario);
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
    
    public String getGrado() {
        GradoL g = new GradoL();
        return g.getGrado(estudiante.getGrado().getIdGrado()).getNombre();
    }
    
}

package beans;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import logic.JuegoL;
import model.Asignatura;
import model.Juego;

@Named(value = "temasC")
@ManagedBean
@RequestScoped
public class TemasC {
    
    private List<Juego> juegos;
    private JuegoL helper;
    private Asignatura asignatura;

    public TemasC() {
        helper = new JuegoL();
    }

    public void init() {
        int id = Integer.parseInt(FacesContext
                .getCurrentInstance().getExternalContext()
                .getRequestParameterMap().get("asignaturaId"));
        asignatura = helper.getAsignatura(id);
        juegos = helper.getJuegos(asignatura);
    }
    
    public List<Juego> getJuegos() {
        return juegos;
    }

    public void setJuegos(List<Juego> juegos) {
        this.juegos = juegos;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }
}

package beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import logic.EstudianteL;
import logic.GradoL;
import model.Grado;

@Named(value = "gradosC")
@ManagedBean
@RequestScoped
public class GradosC {

    private List<Grado> grados;
    private EstudianteL helper;
    
    public GradosC() {
        helper = new EstudianteL();
        grados = helper.listarGrados();
    }
    
    public int getPrimero() {
        return grados.get(0).getIdGrado();
    }
    
    public int getSegundo() {
        return grados.get(1).getIdGrado();
    }
    
    public int getTercero() {
        return grados.get(2).getIdGrado();
    }
    
    public int getCuarto() {
        return grados.get(3).getIdGrado();
    }
    
    public int getQuinto() {
        return grados.get(4).getIdGrado();
    }
    
    public int getSexto() {
        return grados.get(5).getIdGrado();
    }
}

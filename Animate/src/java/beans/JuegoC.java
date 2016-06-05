package beans;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import logic.EstudianteL;
import logic.JuegoL;
import model.Comentario;
import model.Estudiante;
import model.Juego;
import model.Usuario;

@Named(value = "juegoC")
@ManagedBean
@ViewScoped
public class JuegoC {

    private JuegoL helper;
    private Juego juego;
    private Comentario comentario;
    private List<Comentario> comentarios;
    
    public JuegoC() {
        helper = new JuegoL();
        comentario = new Comentario();
    }
    
    public void init() {
        int id = Integer.parseInt(FacesContext
                .getCurrentInstance().getExternalContext()
                .getRequestParameterMap().get("juegoId"));
        juego = helper.getJuego(id);
        comentarios = helper.getComentarios(juego);
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    
    public void comentar(Usuario u) {
        EstudianteL eL = new EstudianteL();
        Estudiante e = eL.getEstudiante(u);
        comentario.setEstudiante(e);
        comentario.setFecha(new Date());
        comentario.setJuego(juego);
        helper.comentar(comentario);
    }
    
    public String formateaFecha(Date fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        return sdf.format(fecha);
    }
}

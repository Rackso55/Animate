package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import model.Administrador;
import model.Usuario;

@Named(value = "registroAdministradorC")
@ManagedBean
@RequestScoped
public class RegistroAdministradorC {
    
    Usuario usuario;
    Administrador administrador;
    
    public RegistroAdministradorC() {
        usuario = new Usuario();
        administrador = new Administrador();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    
    public void registrar() {
        
    }
    
}

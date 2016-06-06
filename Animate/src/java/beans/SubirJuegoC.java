package beans;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import logic.EstudianteL;
import logic.GradoL;
import logic.JuegoL;
import model.Asignatura;
import model.Juego;
import model.Usuario;

@Named(value = "subirJuegoC")
@ManagedBean
@ViewScoped
public class SubirJuegoC implements Serializable {

    private UploadedFile archivo;
    private Juego juego;
    private JuegoL helper;
    private List<Asignatura> asignaturas;
    private EstudianteL gL;
    private FacesMessage mensaje;

    public SubirJuegoC() {
        helper = new JuegoL();
        gL = new EstudianteL();
        asignaturas = gL.listarAsignaturas();
        juego = new Juego();
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }
    
    public UploadedFile getArchivo() {
        return archivo;
    }

    public void setArchivo(UploadedFile archivo) {
        this.archivo = archivo;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }
    
    public String subir(Usuario u) throws IOException {
        String path = guardar();
        System.out.println(path);
        juego.setRuta(path);
        juego.setPublicado(true);
        juego.setFechaRegistro(new Date());
        mensaje = helper.registra(juego,u);
        if(mensaje == null)
            return "index?faces-redirect=true";
        else {
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
            return "";
        }
    }
    
    public String guardar() throws IOException {
        String s = "uhm";
        if (archivo != null) {
            InputStream inputStr;
            try {
                inputStr = archivo.getInputstream();
            } catch (IOException e) {
                System.out.println("EROR");
            }
            String destPath = "/home/chepe/juegos";
            System.out.println(destPath);
            File directorio = new File(destPath);
            directorio.mkdir();
            ZipInputStream zin = new ZipInputStream(archivo.getInputstream());
            ZipEntry entry = zin.getNextEntry();
            s = destPath + File.separator + entry.getName();
            while(entry != null) {
                String filepath = destPath + File.separator + entry.getName();
                if(!entry.isDirectory()) {
                    extractFile(zin,filepath);
                } else {
                    File dir = new File(filepath);
                    dir.mkdir();
                }
                zin.closeEntry();
                entry = zin.getNextEntry();
            }
        } else {
            System.out.println("VACIO");
        }
        return s;
    }
    
    public void extractFile(ZipInputStream zin, String path) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path));
        byte[] ba = new byte[4096];
        int read = 0;
        while((read = zin.read(ba)) != -1) {
            bos.write(ba,0,read);
        }
    }

}

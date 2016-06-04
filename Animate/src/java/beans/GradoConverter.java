package beans;
 
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import logic.EstudianteL;
import model.Grado;
 
@FacesConverter("gradoConverter")
public class GradoConverter implements Converter {
 
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                RegistroEstudianteC service = (RegistroEstudianteC) fc.getExternalContext().getApplicationMap().get("registroEstudianteC");
                return service.getLstGrados().get(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Grado no valido."));
            }
        }
        else {
            return null;
        }
    }
 
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Grado) object).getIdGrado());
        }
        else {
            return null;
        }
    }   
}

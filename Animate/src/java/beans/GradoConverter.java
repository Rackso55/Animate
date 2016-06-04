package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import logic.GradoL;
import model.Grado;

@ManagedBean(name = "gradoConverterBean")
@FacesConverter(value = "gradoConverter")
public class GradoConverter implements Converter {

    /* Conexión con la base */
    private GradoL helper;

    /* Constructor */
    public GradoConverter() {
        this.helper = new GradoL();
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        return this.helper.getGrado(value);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        return ((Grado) object).toString();
    }
}

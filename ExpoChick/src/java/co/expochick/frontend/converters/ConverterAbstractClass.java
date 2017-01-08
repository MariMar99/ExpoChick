package co.expochick.frontend.converters;

import co.expochick.backend.persistence.entity.IEntityIdentified;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Mariana
 */
public abstract class ConverterAbstractClass implements Converter{

    protected String nombreManagedBean;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Integer key = Integer.valueOf(value);
        IConverterManagedBean converterManagedBean = (IConverterManagedBean) context.getApplication().getELResolver().getValue(context.getELContext(), null, nombreManagedBean);
        return converterManagedBean.getObjectByKey(key);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof IEntityIdentified) {
            IEntityIdentified objetoEntity = (IEntityIdentified) value;
            return objetoEntity.getPK();
        }
        return null;
    }
    
}

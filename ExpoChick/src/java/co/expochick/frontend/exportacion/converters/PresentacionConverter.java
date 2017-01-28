package co.expochick.frontend.exportacion.converters;

import co.expochick.backend.persistence.entity.Presentacion;
import co.expochick.frontend.converters.ConverterAbstractClass;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Mariana
 */
@FacesConverter (forClass = Presentacion.class)
public class PresentacionConverter extends ConverterAbstractClass {

    public PresentacionConverter() {
        this.nombreManagedBean = "presentacionManagedBean";
    }
    
}

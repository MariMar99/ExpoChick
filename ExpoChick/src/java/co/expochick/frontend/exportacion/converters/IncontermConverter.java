package co.expochick.frontend.exportacion.converters;

import co.expochick.backend.persistence.entity.Inconterm;
import co.expochick.frontend.converters.ConverterAbstractClass;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Mariana
 */
@FacesConverter (forClass = Inconterm.class)
public class IncontermConverter extends ConverterAbstractClass{

    public IncontermConverter() {
        this.nombreManagedBean = "incontermManagedBean";
    }
    
}

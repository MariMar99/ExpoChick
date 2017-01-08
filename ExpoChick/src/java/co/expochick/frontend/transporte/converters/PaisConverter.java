package co.expochick.frontend.transporte.converters;

import co.expochick.backend.persistence.entity.Pais;
import co.expochick.frontend.converters.ConverterAbstractClass;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Mariana
 */
@FacesConverter (forClass = Pais.class)
public class PaisConverter extends ConverterAbstractClass {

    public PaisConverter() {
        this.nombreManagedBean = "paisManagedBean";
    }
    
}

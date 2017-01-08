package co.expochick.frontend.transporte.converters;

import co.expochick.backend.persistence.entity.Continente;
import co.expochick.frontend.converters.ConverterAbstractClass;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Mariana
 */
@FacesConverter (forClass = Continente.class)
public class ContinenteConverter extends ConverterAbstractClass{

    public ContinenteConverter() {
        this.nombreManagedBean = "continenteManagedBean";
    }
    
}

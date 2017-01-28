package co.expochick.frontend.exportacion.converters;

import co.expochick.backend.persistence.entity.TipoEmpaque;
import co.expochick.frontend.converters.ConverterAbstractClass;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Mariana
 */
@FacesConverter (forClass = TipoEmpaque.class)
public class TipoEmpaqueConverter extends ConverterAbstractClass{

    public TipoEmpaqueConverter() {
        this.nombreManagedBean = "tipoEmpaqueManagedBean";
    }
    
}

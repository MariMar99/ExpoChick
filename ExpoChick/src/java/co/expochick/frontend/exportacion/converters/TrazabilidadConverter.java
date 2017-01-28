package co.expochick.frontend.exportacion.converters;

import co.expochick.backend.persistence.entity.Trazabilidad;
import co.expochick.frontend.converters.ConverterAbstractClass;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Mariana
 */
@FacesConverter (forClass = Trazabilidad.class)
public class TrazabilidadConverter extends ConverterAbstractClass {
    public TrazabilidadConverter(){
        this.nombreManagedBean = "trazabilidadManagedBean";
    }
}

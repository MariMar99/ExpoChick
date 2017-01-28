package co.expochick.frontend.exportacion.converters;

import co.expochick.backend.persistence.entity.PrecioCantidad;
import co.expochick.frontend.converters.ConverterAbstractClass;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Mariana
 */
@FacesConverter(forClass = PrecioCantidad.class)
public class PrecioXCantidadConverter extends ConverterAbstractClass {
    public PrecioXCantidadConverter(){
        this.nombreManagedBean = "precioXCantidadManagedBean";
    }
}

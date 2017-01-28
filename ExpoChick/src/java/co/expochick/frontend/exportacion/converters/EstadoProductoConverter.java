package co.expochick.frontend.exportacion.converters;

import co.expochick.backend.persistence.entity.EstadoProducto;
import co.expochick.frontend.converters.ConverterAbstractClass;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Mariana
 */
@FacesConverter (forClass = EstadoProducto.class)
public class EstadoProductoConverter extends ConverterAbstractClass{

    public EstadoProductoConverter() {
        this.nombreManagedBean = "estadoPedidoManagedBean";
    }
    
}

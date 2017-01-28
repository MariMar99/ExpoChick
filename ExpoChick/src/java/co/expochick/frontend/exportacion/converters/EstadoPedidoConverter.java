package co.expochick.frontend.exportacion.converters;

import co.expochick.backend.persistence.entity.EstadoPedido;
import co.expochick.frontend.converters.ConverterAbstractClass;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Mariana
 */
@FacesConverter (forClass = EstadoPedido.class)
public class EstadoPedidoConverter extends ConverterAbstractClass{

    public EstadoPedidoConverter() {
        this.nombreManagedBean = "estadoPedidoManagedBean";
    }
    
}

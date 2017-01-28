package co.expochick.frontend.exportacion.converters;

import co.expochick.backend.persistence.entity.Pedido;
import co.expochick.frontend.converters.ConverterAbstractClass;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Mariana
 */
@FacesConverter (forClass = Pedido.class)

public class PedidoConverter extends ConverterAbstractClass{

    public PedidoConverter() {
        this.nombreManagedBean = "pedidoManagedBean";
    }
    
}

package co.expochick.frontend.exportacion.converters;

import co.expochick.backend.persistence.entity.DetallePedido;
import co.expochick.frontend.converters.ConverterAbstractClass;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Mariana
 */
@FacesConverter (forClass = DetallePedido.class)
public class DetallePedidoConverter extends ConverterAbstractClass{

    public DetallePedidoConverter() {
        this.nombreManagedBean = "detallePedidoManagedBean";
    }
    
}

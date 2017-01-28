package co.expochick.frontend.exportacion.converters;

import co.expochick.backend.persistence.entity.Producto;
import co.expochick.frontend.converters.ConverterAbstractClass;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Mariana
 */
@FacesConverter (forClass = Producto.class)
public class ProductoConverter extends ConverterAbstractClass{

    public ProductoConverter() {
        this.nombreManagedBean = "productoManagedBean";
    }
    
}

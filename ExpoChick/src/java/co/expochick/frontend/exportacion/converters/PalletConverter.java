package co.expochick.frontend.exportacion.converters;

import co.expochick.backend.persistence.entity.Pallet;
import co.expochick.frontend.converters.ConverterAbstractClass;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Mariana
 */
@FacesConverter (forClass = Pallet.class)
public class PalletConverter extends ConverterAbstractClass{

    public PalletConverter() {
        this.nombreManagedBean = "palletManagedBean";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.backend.persistence.facades;

import co.expochick.backend.persistence.entity.PrecioCantidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mariana
 */
@Local
public interface PrecioCantidadFacadeLocal {

    void create(PrecioCantidad precioCantidad);

    void edit(PrecioCantidad precioCantidad);

    void remove(PrecioCantidad precioCantidad);

    PrecioCantidad find(Object id);

    List<PrecioCantidad> findAll();

    List<PrecioCantidad> findRange(int[] range);

    int count();
    
}

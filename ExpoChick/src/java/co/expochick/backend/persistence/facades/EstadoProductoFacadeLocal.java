/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.backend.persistence.facades;

import co.expochick.backend.persistence.entity.EstadoProducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mariana
 */
@Local
public interface EstadoProductoFacadeLocal {

    void create(EstadoProducto estadoProducto);

    void edit(EstadoProducto estadoProducto);

    void remove(EstadoProducto estadoProducto);

    EstadoProducto find(Object id);

    List<EstadoProducto> findAll();

    List<EstadoProducto> findRange(int[] range);

    int count();
    
}

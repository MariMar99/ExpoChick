/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.backend.persistence.facades;

import co.expochick.backend.persistence.entity.Presentacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mariana
 */
@Local
public interface PresentacionFacadeLocal {

    void create(Presentacion presentacion);

    void edit(Presentacion presentacion);

    void remove(Presentacion presentacion);

    Presentacion find(Object id);

    List<Presentacion> findAll();

    List<Presentacion> findRange(int[] range);

    int count();
    
}

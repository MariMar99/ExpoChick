/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.backend.persistence.facades;

import co.expochick.backend.persistence.entity.Trazabilidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mariana
 */
@Local
public interface TrazabilidadFacadeLocal {

    void create(Trazabilidad trazabilidad);

    void edit(Trazabilidad trazabilidad);

    void remove(Trazabilidad trazabilidad);

    Trazabilidad find(Object id);

    List<Trazabilidad> findAll();

    List<Trazabilidad> findRange(int[] range);

    int count();
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.backend.persistence.facades;

import co.expochick.backend.persistence.entity.TipoEmpaque;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mariana
 */
@Local
public interface TipoEmpaqueFacadeLocal {

    void create(TipoEmpaque tipoEmpaque);

    void edit(TipoEmpaque tipoEmpaque);

    void remove(TipoEmpaque tipoEmpaque);

    TipoEmpaque find(Object id);

    List<TipoEmpaque> findAll();

    List<TipoEmpaque> findRange(int[] range);

    int count();
    
}

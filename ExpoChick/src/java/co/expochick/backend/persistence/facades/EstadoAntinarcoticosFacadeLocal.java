/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.backend.persistence.facades;

import co.expochick.backend.persistence.entity.EstadoAntinarcoticos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mariana
 */
@Local
public interface EstadoAntinarcoticosFacadeLocal {

    void create(EstadoAntinarcoticos estadoAntinarcoticos);

    void edit(EstadoAntinarcoticos estadoAntinarcoticos);

    void remove(EstadoAntinarcoticos estadoAntinarcoticos);

    EstadoAntinarcoticos find(Object id);

    List<EstadoAntinarcoticos> findAll();

    List<EstadoAntinarcoticos> findRange(int[] range);

    int count();
    
}

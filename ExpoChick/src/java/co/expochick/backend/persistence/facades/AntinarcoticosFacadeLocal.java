/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.backend.persistence.facades;

import co.expochick.backend.persistence.entity.Antinarcoticos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mariana
 */
@Local
public interface AntinarcoticosFacadeLocal {

    void create(Antinarcoticos antinarcoticos);

    void edit(Antinarcoticos antinarcoticos);

    void remove(Antinarcoticos antinarcoticos);

    Antinarcoticos find(Object id);

    List<Antinarcoticos> findAll();

    List<Antinarcoticos> findRange(int[] range);

    int count();
    
}

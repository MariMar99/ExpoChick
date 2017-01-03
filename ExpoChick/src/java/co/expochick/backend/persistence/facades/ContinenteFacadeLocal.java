/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.backend.persistence.facades;

import co.expochick.backend.persistence.entity.Continente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mariana
 */
@Local
public interface ContinenteFacadeLocal {

    void create(Continente continente);

    void edit(Continente continente);

    void remove(Continente continente);

    Continente find(Object id);

    List<Continente> findAll();

    List<Continente> findRange(int[] range);

    int count();
    
}

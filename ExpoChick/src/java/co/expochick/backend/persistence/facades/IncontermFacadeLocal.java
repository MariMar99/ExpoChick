/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.backend.persistence.facades;

import co.expochick.backend.persistence.entity.Inconterm;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mariana
 */
@Local
public interface IncontermFacadeLocal {

    void create(Inconterm inconterm);

    void edit(Inconterm inconterm);

    void remove(Inconterm inconterm);

    Inconterm find(Object id);

    List<Inconterm> findAll();

    List<Inconterm> findRange(int[] range);

    int count();
    
}

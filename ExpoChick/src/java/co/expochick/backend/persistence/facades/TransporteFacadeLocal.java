/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.backend.persistence.facades;

import co.expochick.backend.persistence.entity.Transporte;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mariana
 */
@Local
public interface TransporteFacadeLocal {

    void create(Transporte transporte);

    void edit(Transporte transporte);

    void remove(Transporte transporte);

    Transporte find(Object id);

    List<Transporte> findAll();

    List<Transporte> findRange(int[] range);

    int count();
    
}

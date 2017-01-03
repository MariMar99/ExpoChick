/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.backend.persistence.facades;

import co.expochick.backend.persistence.entity.EstadoCliente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mariana
 */
@Local
public interface EstadoClienteFacadeLocal {

    void create(EstadoCliente estadoCliente);

    void edit(EstadoCliente estadoCliente);

    void remove(EstadoCliente estadoCliente);

    EstadoCliente find(Object id);

    List<EstadoCliente> findAll();

    List<EstadoCliente> findRange(int[] range);

    int count();
    
}

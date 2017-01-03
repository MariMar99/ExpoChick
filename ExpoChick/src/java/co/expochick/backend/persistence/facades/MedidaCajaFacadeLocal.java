/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.backend.persistence.facades;

import co.expochick.backend.persistence.entity.MedidaCaja;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mariana
 */
@Local
public interface MedidaCajaFacadeLocal {

    void create(MedidaCaja medidaCaja);

    void edit(MedidaCaja medidaCaja);

    void remove(MedidaCaja medidaCaja);

    MedidaCaja find(Object id);

    List<MedidaCaja> findAll();

    List<MedidaCaja> findRange(int[] range);

    int count();
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.backend.persistence.facades;

import co.expochick.backend.persistence.entity.Pallet;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mariana
 */
@Local
public interface PalletFacadeLocal {

    void create(Pallet pallet);

    void edit(Pallet pallet);

    void remove(Pallet pallet);

    Pallet find(Object id);

    List<Pallet> findAll();

    List<Pallet> findRange(int[] range);

    int count();
    
}

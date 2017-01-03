/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.backend.persistence.facades;

import co.expochick.backend.persistence.entity.Pallet;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mariana
 */
@Stateless
public class PalletFacade extends AbstractFacade<Pallet> implements PalletFacadeLocal {

    @PersistenceContext(unitName = "ExpoChickPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PalletFacade() {
        super(Pallet.class);
    }
    
}

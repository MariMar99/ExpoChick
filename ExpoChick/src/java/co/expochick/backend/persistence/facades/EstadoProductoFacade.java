/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.backend.persistence.facades;

import co.expochick.backend.persistence.entity.EstadoProducto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mariana
 */
@Stateless
public class EstadoProductoFacade extends AbstractFacade<EstadoProducto> implements EstadoProductoFacadeLocal {

    @PersistenceContext(unitName = "ExpoChickPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoProductoFacade() {
        super(EstadoProducto.class);
    }
    
}

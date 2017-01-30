/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.frontend.transporte.controller;

import co.expochick.backend.persistence.entity.TipoTransporte;
import co.expochick.backend.persistence.facades.TipoTransporteFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Mariana
 */
@Named(value = "tipoTransportManagedBean")
@SessionScoped
public class TipoTransportManagedBean implements Serializable {

    @EJB private TipoTransporteFacadeLocal tipoTransfc;
    private TipoTransporte tipoTrans;
    
    public TipoTransportManagedBean() {
    }
    
       
    public TipoTransporte getTipoTrans() {
        return tipoTrans;
    }

    public void setTipoTrans(TipoTransporte tipoTrans) {
        this.tipoTrans = tipoTrans;
    }
    
    @PostConstruct
    public void init(){
        tipoTrans = new TipoTransporte();
    }
    
    public void registrarTipoTrans(){
        try {
            tipoTransfc.create(tipoTrans);
        } catch (Exception e) {
        }
    }
    
    public void eliminarTipoTrans(){
        try {
            tipoTransfc.remove(tipoTrans);
        } catch (Exception e) {
        }
    }
    
    public List<TipoTransporte> listarTipoTrans(){
        try {
            return tipoTransfc.findAll();
        } catch (Exception e) {
        }return null;
    }
    
}

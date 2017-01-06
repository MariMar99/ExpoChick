package co.expochick.frontend.transporte.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import co.expochick.backend.persistence.entity.Transporte;
import co.expochick.backend.persistence.facades.TransporteFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;


/**
 *
 * @author Mariana
 */
@Named(value = "transporteManagedBean")
@SessionScoped
public class TransporteManagedBean implements Serializable {

    @EJB private TransporteFacadeLocal transfcl;
    private Transporte trans;
    
    public TransporteManagedBean() {
    }

    public Transporte getTrans() {
        return trans;
    }

    public void setTrans(Transporte trans) {
        this.trans = trans;
    }
    
    @PostConstruct
    public void init(){
        trans = new Transporte();
    }
    
    public void registrarTransporte(){
        try {
            transfcl.create(trans);
        } catch (Exception e) {
        }
    }
    
    public void eliminarTransporte(Transporte trans){
        try {
            transfcl.remove(trans);
        } catch (Exception e) {
        }
    }
    
    public void modificarTransporte(Transporte trans){
        try {
            transfcl.edit(trans);
        } catch (Exception e) {
        }
    }
    
    public List<Transporte> listarTransporte(){
        try {
            return transfcl.findAll();
        } catch (Exception e) {
        }return null;
    }
    
}

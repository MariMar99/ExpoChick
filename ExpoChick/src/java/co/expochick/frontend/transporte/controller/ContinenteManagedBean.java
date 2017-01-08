package co.expochick.frontend.transporte.controller;

import co.expochick.backend.persistence.entity.Continente;
import co.expochick.backend.persistence.facades.ContinenteFacadeLocal;
import co.expochick.frontend.converters.IConverterManagedBean;
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
@Named(value = "continenteManagedBean")
@SessionScoped
public class ContinenteManagedBean implements Serializable, IConverterManagedBean<Continente> {

    @EJB private ContinenteFacadeLocal contfcl;
    private Continente continente;
    
    public ContinenteManagedBean() {
    }

    public ContinenteFacadeLocal getCantfcl() {
        return contfcl;
    }

    public void setCantfcl(ContinenteFacadeLocal contfcl) {
        this.contfcl = contfcl;
    }
    
    @PostConstruct
    public void init(){
        continente = new Continente();
    }
    
    public List<Continente> listarContinente(){
        try {
            return contfcl.findAll();
        } catch (Exception e) {
        }return null;
    }

    @Override
    public Continente getObjectByKey(Integer key) {
        return contfcl.find(key);
    }
    
}

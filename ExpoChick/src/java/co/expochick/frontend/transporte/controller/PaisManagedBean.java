package co.expochick.frontend.transporte.controller;

import co.expochick.backend.persistence.entity.Pais;
import co.expochick.backend.persistence.facades.PaisFacadeLocal;
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
@Named(value = "paisManagedBean")
@SessionScoped
public class PaisManagedBean implements Serializable {

    @EJB private PaisFacadeLocal paisfcl;
    private Pais pais;
    
    public PaisManagedBean() {
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
    
    @PostConstruct
    public void init(){
        pais = new Pais();
    }
    
    public void registrarPais(){
        try {
            paisfcl.create(pais);
        } catch (Exception e) {
        }
    }
    
    public List<Pais> listarPais(){
        try {
            return paisfcl.findAll();
        } catch (Exception e) {
        }return null;
    }
    
}

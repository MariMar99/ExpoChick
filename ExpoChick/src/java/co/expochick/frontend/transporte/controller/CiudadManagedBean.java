package co.expochick.frontend.transporte.controller;

import co.expochick.backend.persistence.entity.Ciudad;
import co.expochick.backend.persistence.facades.CiudadFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Mariana
 */
@Named(value = "ciudadManagedBean")
@RequestScoped
public class CiudadManagedBean implements Serializable {

    @EJB private CiudadFacadeLocal ciudadfcl;
    private Ciudad ciudad;
    
    public CiudadManagedBean() {
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
   
    @PostConstruct
    public void init(){
        ciudad = new Ciudad();
    }
    
    public void registrarCiudad(){
        try {
            ciudadfcl.create(ciudad);
        } catch (Exception e) {
        }
    }
    
    public void modificarCiudad(){
        try {
            ciudadfcl.edit(ciudad);
        } catch (Exception e) {
        }
    }
    
    public List<Ciudad> listarCiudad(){
        try {
            return ciudadfcl.findAll();
        } catch (Exception e) {
        }return null;
    }
    
}

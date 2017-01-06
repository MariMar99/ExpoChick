package co.expochick.frontend.transporte.controller;

import co.expochick.backend.persistence.entity.EstadoAntinarcoticos;
import co.expochick.backend.persistence.facades.EstadoAntinarcoticosFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Mariana
 */
@Named(value = "estadoAntinarcoticosManagedBean")
@RequestScoped
public class EstadoAntinarcoticosManagedBean {

    @EJB private EstadoAntinarcoticosFacadeLocal estAntifcl;
    private EstadoAntinarcoticos estAnti;
    
    public EstadoAntinarcoticosManagedBean() {
    }

    public EstadoAntinarcoticos getEstAnti() {
        return estAnti;
    }

    public void setEstAnti(EstadoAntinarcoticos estAnti) {
        this.estAnti = estAnti;
    }
    
    @PostConstruct
    public void init(){
        estAnti = new EstadoAntinarcoticos();
    }
    
    public void registrarEstadoAnti(){
        try {
            estAntifcl.create(estAnti);
        } catch (Exception e) {
        }
    }
    
    public void eliminarEstadoAnti(EstadoAntinarcoticos estAnti){
        try {
            estAntifcl.remove(estAnti);
        } catch (Exception e) {
        }
    }
    
    public void modificarEstadoAnti(EstadoAntinarcoticos estAnti){
        try {
            estAntifcl.edit(estAnti);
        } catch (Exception e) {
        }
    }
    
    public List<EstadoAntinarcoticos> listarEstadoAnti(){
        try {
            return estAntifcl.findAll();
        } catch (Exception e) {
        }return null;
    }
}

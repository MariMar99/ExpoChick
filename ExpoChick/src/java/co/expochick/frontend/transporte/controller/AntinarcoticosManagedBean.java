package co.expochick.frontend.transporte.controller;

import co.expochick.backend.persistence.entity.Antinarcoticos;
import co.expochick.backend.persistence.facades.AntinarcoticosFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Mariana
 */
@Named(value = "antinarcoticosManagedBean")
@RequestScoped
public class AntinarcoticosManagedBean {

    @EJB private AntinarcoticosFacadeLocal antifcl;
    private Antinarcoticos anti;
    
    public AntinarcoticosManagedBean() {
    }

    public Antinarcoticos getAnti() {
        return anti;
    }

    public void setAnti(Antinarcoticos anti) {
        this.anti = anti;
    }
    
    @PostConstruct
    public void init(){
        anti = new Antinarcoticos();
    }
    
    public void registrarAntinarcoticos(){
        try {
            antifcl.create(anti);
        } catch (Exception e) {
        }
    }
    
    public void eliminarAntinarcoticos(Antinarcoticos anti){
        try {
            antifcl.remove(anti);
        } catch (Exception e) {
        }
    }
    
    public String actualizarAntinarcoticos(Antinarcoticos anti){
        this.anti = anti;
        return "antinarcoticosModificar";
    }
    
    public void modificarAntinarcoticos(){
        try {
            antifcl.edit(anti);
        } catch (Exception e) {
        }
    }
    
    public List<Antinarcoticos> listarAntinarcoticos(){
        try {
            return antifcl.findAll();
        } catch (Exception e) {
        }return null;
    }
    
}

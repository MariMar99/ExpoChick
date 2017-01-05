package co.expochick.frontend.exportacion.controller;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import co.expochick.backend.persistence.entity.EstadoProducto;
import co.expochick.backend.persistence.facades.EstadoProductoFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Mariana
 */
@Named(value = "estadoProductoManagedBean")
@RequestScoped
public class EstadoProductoManagedBean {

    @EJB private EstadoProductoFacadeLocal estaProfcl;
    private EstadoProducto estProducto;
    
    public EstadoProductoManagedBean() {
    }

    public EstadoProducto getEstProducto() {
        return estProducto;
    }

    public void setEstProducto(EstadoProducto estProducto) {
        this.estProducto = estProducto;
    }
    
    @PostConstruct
    public void init (){
        estProducto = new EstadoProducto();
    }
    
    public void registrarEstadoProducto(){
        try {
            estaProfcl.create(estProducto);
        } catch (Exception e) {
        }
    }
    
    public void eliminarEstadoProducto(EstadoProducto estProducto){
        try {
            estaProfcl.remove(estProducto);
        } catch (Exception e) {
        }
    }
    
    public void modificarEstadoProducto(EstadoProducto estProducto){        
        try {
            estaProfcl.edit(estProducto);
        } catch (Exception e) {
        }
    }
    
    public List<EstadoProducto> listarEstadoPro(){
        try {
            return estaProfcl.findAll();
        } catch (Exception e) {
        }return null;
    }
}

package co.expochick.frontend.exportacion.controller;

import co.expochick.backend.persistence.entity.PrecioCantidad;
import co.expochick.backend.persistence.facades.PrecioCantidadFacadeLocal;
//import com.expochick.frontend.converters.IConverterManagedBean;
import javax.inject.Named;
//import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Mariana
 */
@Named(value = "precioXCantidadManagedBean")
//@SessionScoped
@RequestScoped
public class PrecioCantidadManagedBean implements Serializable{

    @EJB private PrecioCantidadFacadeLocal prefcl;
    private PrecioCantidad precioxCant;
    
    public PrecioCantidadManagedBean() {
    }
    
    public PrecioCantidad getPrecioxCant() {
        return precioxCant;
    }

    public void setPrecioxCant(PrecioCantidad precioxCant) {
        this.precioxCant = precioxCant;
    }
    
    
    @PostConstruct
    public void init (){
        precioxCant = new PrecioCantidad();
    }
    
    public void registrarPrecioCant(){
        try {
            prefcl.create(precioxCant);
            mensajeExito("Registrado");
        } catch (Exception e) {
            mensajeError(e);
        }
    }
    
    public void eliminarPrecioCant(PrecioCantidad precioxCant){
        try {
            prefcl.remove(precioxCant);
            mensajeExito("Eliminado");
        } catch (Exception e) {
            mensajeError(e);
        }
    }
    
    public String actualizarPrecioCant(PrecioCantidad precioxCant){
        this.precioxCant = precioxCant;
        return "precioPorCantidadModificar";
    }
    
    public void modificarPrecioCant(){
        try {
            prefcl.edit(precioxCant);
        } catch (Exception e) {
            mensajeError(e);
        }
    }
    
    public List<PrecioCantidad> listarPrecioCant(){
        try{
            return this.prefcl.findAll();
        }catch (Exception e){
            mensajeError (e);
        } return null;
    }

    private void mensajeError(Exception e) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Se ha Producido el siguiente Error: ", e.getMessage()));
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al Insertar:", e.getMessage());
        RequestContext.getCurrentInstance().showMessageInDialog(msg);
    }

    private void mensajeExito(String operacion) {
        String msg = "Se ha realizado exitosamente la operacion de " + operacion;
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
        FacesMessage sal = new FacesMessage(FacesMessage.SEVERITY_INFO,"Opereción con Exito : ", msg);
        RequestContext.getCurrentInstance().showMessageInDialog(sal);
    }

//    @Override
//    public PrecioPorCantidad getObjectByKey(Integer key) {
//        return prefcl.find(key);
//    }

    
}

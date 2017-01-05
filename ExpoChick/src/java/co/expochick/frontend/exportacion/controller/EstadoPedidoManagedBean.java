package co.expochick.frontend.exportacion.controller;

import co.expochick.backend.persistence.entity.EstadoPedido;
import co.expochick.backend.persistence.facades.EstadoPedidoFacadeLocal;
//import com.expochick.frontend.converters.IConverterManagedBean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Mariana
 */
@Named(value = "estadoPedidoManagedBean")
@SessionScoped
public class EstadoPedidoManagedBean implements Serializable{

    @EJB private EstadoPedidoFacadeLocal espfcl;
    private EstadoPedido estadoPedido;
    
    public EstadoPedidoManagedBean() {
    }

   
    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }
    
    
    
    
    @PostConstruct
    public void init(){
        estadoPedido = new EstadoPedido();
    }
    
    public void registrarEstadoPedido(){
        try {
            espfcl.create(estadoPedido);
            mensajeExito("Registrado");
        } catch (Exception e) {
            mensajeError(e);
        }
    }
    
    public void eliminarEstadoPedido(){
        try {
            espfcl.remove(estadoPedido);
            mensajeExito("Eliminado");
        } catch (Exception e) {
            mensajeError(e);
        }
    }
    
    public String actualizarEstadoPedido(EstadoPedido estadoPedido){
        this.estadoPedido = estadoPedido;
        return "estadoPedidoModificar";
    }
    
    public void modificarEstadoPedido(){
        try {
            espfcl.edit(estadoPedido);
        } catch (Exception e) {
            mensajeError(e);
        }
    }
    
    public List<EstadoPedido> listarEstadoPedidos(){
        return espfcl.findAll();
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
//    public EstadoPedido getObjectByKey(Integer key) {
//        return espfcl.find(key);
//    }
    
}

package co.expochick.frontend.exportacion.controller;

import co.expochick.backend.persistence.entity.DetallePedido;
import co.expochick.backend.persistence.facades.DetallePedidoFacadeLocal;
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
@Named(value = "detallePedidoManagedBean")
@SessionScoped
public class DetallePedidoManagedBean implements Serializable {

    @EJB private DetallePedidoFacadeLocal dtpfcl;
    private DetallePedido detPedido;
    
    public DetallePedidoManagedBean() {
    }

    public DetallePedido getDetPedido() {
        return detPedido;
    }

    public void setDetPedido(DetallePedido detPedido) {
        this.detPedido = detPedido;
    }
    
    @PostConstruct
    public void init(){
        detPedido = new DetallePedido();
    }
    
    public void registrarDetallePedido(){
        try {
            dtpfcl.create(detPedido);
            mensajeExito("Registrado");
        } catch (Exception e) {
            mensajeError(e);
        }
    }
    
    public void eliminarDetallePedido(DetallePedido detPedido){
        try {
            dtpfcl.remove(detPedido);
            mensajeExito("Eliminado");
        } catch (Exception e) {
            mensajeError(e);
        }
    }
    
    public String actualiarDetallePedido(DetallePedido detPedido){
        this.detPedido = detPedido;
        return "detallePedidoModificar";
    }
    
    public void modificarDetallePedido(){
        try {
            dtpfcl.edit(detPedido);
        } catch (Exception e) {
            mensajeError(e);
        }
    }
    
    public List<DetallePedido> listarDetallePedidos(){
        return dtpfcl.findAll();
    }
    
    private void mensajeError(Exception e) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Se ha Producido el siguiente Error: ", e.getMessage()));
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en:", e.getMessage());
        RequestContext.getCurrentInstance().showMessageInDialog(msg);
    }

    private void mensajeExito(String operacion) {
        String msg = "Se ha realizado exitosamente la operacion de " + operacion;
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
        FacesMessage sal = new FacesMessage(FacesMessage.SEVERITY_INFO,"Opereción con Exito : ", msg);
        RequestContext.getCurrentInstance().showMessageInDialog(sal);
    }

    //@Override
    //public DetallePedido getObjectByKey(Integer key) {
//        return dtpfcl.find(key);
//    }
    
}

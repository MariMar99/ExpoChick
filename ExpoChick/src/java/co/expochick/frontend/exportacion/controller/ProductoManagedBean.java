package co.expochick.frontend.exportacion.controller;

import co.expochick.backend.persistence.entity.Producto;
import co.expochick.backend.persistence.facades.ProductoFacadeLocal;
//import co.expochick.frontend.converters.IConverterManagedBean;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Mariana
 */
@Named(value = "productoManagedBean")
@RequestScoped
public class ProductoManagedBean implements Serializable{

    @EJB private ProductoFacadeLocal profcl;
    private Producto producto;
    
    public ProductoManagedBean() {
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    @PostConstruct
    public void init(){
        producto = new Producto();
    }
    
    public void registrarProducto(){
        try {
            profcl.create(producto);
            mensajeExito("Registrado");
        } catch (Exception e) {
            mensajeError(e);
        }
    }
    
    public void eliminarProducto(Producto producto){
        try {
            profcl.remove(producto);
            mensajeExito("Eliminado");
        } catch (Exception e) {
            mensajeError(e);
        }
    }
    
    
    
    public String actualizarProducto(Producto producto){
        this.producto = producto;
        return "productosModificar";
    }
    
    public void modificarProducto(){
        try {
            profcl.edit(producto);
        } catch (Exception e) {
            mensajeError(e);
        }
    }
    
    public List<Producto> listarProducto(){
        try{
            return this.profcl.findAll();
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
//    public Producto getObjectByKey(Integer key) {
//        return profcl.find(key);
//    }
    
}

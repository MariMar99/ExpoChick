/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.frontend.login.controller;

import co.expochick.backend.persistence.entity.Cliente;
import co.expochick.backend.persistence.facades.ClienteFacadeLocal;
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
@Named(value = "clienteManagedBean")
@RequestScoped
public class ClienteManagedBean {

    @EJB private ClienteFacadeLocal clfcl;
    private Cliente cliente;
    
    public ClienteManagedBean() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    @PostConstruct
    public void init(){
        cliente = new Cliente();
    }
    
    public void registrarCliente(){
        try {
            clfcl.create(cliente);
            mensajeExito("Registrado");
        } catch (Exception e) {
            mensajeError(e);
        }
    }
    
    public void eliminarCliente(Cliente cliente){
        try {
            clfcl.remove(cliente);
            mensajeExito("Eliminado");
        } catch (Exception e) {
            mensajeError(e);
        }
    }
    
     public String actualizarCliente(Cliente cliente){
        this.cliente = cliente;
        return "clientesModificar";
    }
    
    public void modificarCliente(){
        try {
            clfcl.edit(cliente);
            mensajeExito("Modificado");
        } catch (Exception e) {
            mensajeError(e);
        }
    }
    
    public List<Cliente> listarCliente(){
        return clfcl.findAll();
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
    
}

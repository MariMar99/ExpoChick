/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.frontend.login.controller;

import co.expochick.backend.persistence.facades.UsuarioFacadeLocal;
import co.expochick.backend.persistence.entity.Usuario;
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
@Named(value = "usuarioManagedBean")
//@SessionScoped
@RequestScoped
public class UsuarioManagedBean implements Serializable {

    @EJB private UsuarioFacadeLocal usufcl;
    private Usuario usuario;
            
    public UsuarioManagedBean() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }
    
    public void registrarUsuario(){
        try {
            usufcl.create(usuario);
            mensajeExito("Registrado");
        } catch (Exception e) {
            mensajeError(e);
        }
    }
    
    public void eliminarUsuario(Usuario usuario){
        try {
            usufcl.remove(usuario);
            mensajeExito("Eliminado");
        } catch (Exception e) {
            mensajeError(e);
        }
    }
    
    public void modificarUsuario(Usuario usuario){
        try {
            usufcl.edit(usuario);
        } catch (Exception e) {
            mensajeError(e);
        }
    }
    
    public List<Usuario> listarUsuario(){
        return usufcl.findAll();
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


package co.expochick.frontend.exportacion.controller;

import co.expochick.backend.persistence.entity.TipoEmpaque;
import co.expochick.backend.persistence.facades.TipoEmpaqueFacadeLocal;
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
@Named(value = "tipoEmpaqueManagedBean")
@SessionScoped
public class TipoEmpaqueManagedBean implements Serializable{

    @EJB private TipoEmpaqueFacadeLocal mcfcl;
    private TipoEmpaque tipoempaque;
    
    public TipoEmpaqueManagedBean() {
    }
    
    public TipoEmpaque getTipoempaque() {
        return tipoempaque;
    }

    public void setTipoempaque(TipoEmpaque tipoempaque) {
        this.tipoempaque = tipoempaque;
    }
    
    @PostConstruct
    public void init(){
        tipoempaque = new TipoEmpaque();
    }
    
    public void registrarTipoEmpaque(){
        try {
            mcfcl.create(tipoempaque);
            mensajeExito("Registrado");
        } catch (Exception e) {
            mensajeError(e);
        }
    }
    
    public void eliminarTipoEmpaque(TipoEmpaque tipoempaque){
        try {
            mcfcl.remove(tipoempaque);
            mensajeExito("Eliminado");
        } catch (Exception e) {
            mensajeError(e);
        }
    }
    
    public String actualizarTipoEmpaque(TipoEmpaque tipoempaque){
        this.tipoempaque = tipoempaque;
        return "tipoEmpaqueModificar";
    }
    
    public void modificarTipoEmpaque(){
        try {
            mcfcl.edit(tipoempaque);
        } catch (Exception e) {
            mensajeError(e);
        }
    }
    
    public List<TipoEmpaque> listarTipoEmpaques(){
        return mcfcl.findAll();
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
//    public TipoEmpaque getObjectByKey(Integer key) {
//        return mcfcl.find(key);
//    }

    
}

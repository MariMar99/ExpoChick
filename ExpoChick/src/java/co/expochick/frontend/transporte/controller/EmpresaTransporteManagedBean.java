package co.expochick.frontend.transporte.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import co.expochick.backend.persistence.entity.EmpresaTransporte;
import co.expochick.backend.persistence.facades.EmpresaTransporteFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Mariana
 */
@Named(value = "empresaTransporteManagedBean")
@SessionScoped
public class EmpresaTransporteManagedBean implements Serializable {

   @EJB private EmpresaTransporteFacadeLocal empTransfcl;
   private EmpresaTransporte empTrans;
    
    public EmpresaTransporteManagedBean() {
    }

    public EmpresaTransporte getEmpTrans() {
        return empTrans;
    }

    public void setEmpTrans(EmpresaTransporte empTrans) {
        this.empTrans = empTrans;
    }
    
    @PostConstruct 
    public void init(){
        empTrans = new EmpresaTransporte();
    }
    
    public void registrarEmpresaTrans(){
        try {
            empTransfcl.create(empTrans);
        } catch (Exception e) {
        }
    }
    
    public void eliminarEmpresaTrans(EmpresaTransporte empTrans){
        try {
            empTransfcl.remove(empTrans);
        } catch (Exception e) {
        }
    }
    
    public void modificarEmpresaTrans(){
        try {
            empTransfcl.edit(empTrans);
        } catch (Exception e) {
        }
    }
    
    public List<EmpresaTransporte> listaEmpresaTrans(){
        try {
            return empTransfcl.findAll();
        } catch (Exception e) {
        }return null;
    }
    
}

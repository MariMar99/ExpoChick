package co.expochick.frontend.login.controller;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import co.expochick.backend.persistence.entity.Telefono;
import co.expochick.backend.persistence.facades.TelefonoFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Mariana
 */
@Named(value = "telefonoManagedBean")
@RequestScoped
public class TelefonoManagedBean {

    @EJB private TelefonoFacadeLocal telfcl;
    private Telefono tel;
    
    public TelefonoManagedBean() {
    }

    public Telefono getTel() {
        return tel;
    }

    public void setTel(Telefono tel) {
        this.tel = tel;
    }
    
    @PostConstruct
    public void init(){
        tel = new Telefono();
    }
    
    public void registrarTel(){
        try {
            telfcl.create(tel);
        } catch (Exception e) {
        }
    }
    
    public void eliminarTel (Telefono tel){
        try {
            telfcl.remove(tel);
        } catch (Exception e) {
        }
    }
    
    public void modificarTel(Telefono tel){
        try {
            telfcl.edit(tel);
        } catch (Exception e) {
        }
    }
    
    public List<Telefono> listarTel(){
        try {
            return telfcl.findAll();
        } catch (Exception e) {
        }
        return null;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.expochick.backend.persistence.facades;

import co.expochick.backend.persistence.entity.EmpresaTransporte;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mariana
 */
@Local
public interface EmpresaTransporteFacadeLocal {

    void create(EmpresaTransporte empresaTransporte);

    void edit(EmpresaTransporte empresaTransporte);

    void remove(EmpresaTransporte empresaTransporte);

    EmpresaTransporte find(Object id);

    List<EmpresaTransporte> findAll();

    List<EmpresaTransporte> findRange(int[] range);

    int count();
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.celec.controlador.candidato;

import ec.gob.celec.persistencia.BeFormAcademica;
import java.util.Set;

/**
 *
 * @author Personal
 */
public class DetalleFormacionAcademica {
      private Set<BeFormAcademica> listaFormacionAcademica;
      private Set listaTextos;
      

    /**
     * @return the listaFormacionAcademica
     */
    public Set<BeFormAcademica> getListaFormacionAcademica() {
        return listaFormacionAcademica;
    }

    /**
     * @param listaFormacionAcademica the listaFormacionAcademica to set
     */
    public void setListaFormacionAcademica(Set<BeFormAcademica> listaFormacionAcademica) {
        this.listaFormacionAcademica = listaFormacionAcademica;
    }
    
}

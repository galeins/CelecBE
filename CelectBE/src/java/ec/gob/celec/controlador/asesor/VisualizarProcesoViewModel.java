/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.celec.controlador.asesor;

import ec.gob.celec.persistencia.BeOfertaEmpleo;
import ec.gob.celec.servicio.oferta.OfertaServicio;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.ExecutionArgParam;

/**
 *
 * @author Personal
 */
public class VisualizarProcesoViewModel {
    
    private BeOfertaEmpleo beOfertaEmpleo;
    OfertaServicio ofertaServ= new OfertaServicio(); 
     
    @AfterCompose
    public void initSetup(@ExecutionArgParam("accion") Integer codigoOferta)
    {
       getOfertaEmpleo(codigoOferta);
        
    }
    public void getOfertaEmpleo(Integer codigoOferta)
    {
        setBeOfertaEmpleo(ofertaServ.getBeOfertaByCodigo(codigoOferta));
    }
    /**
     * @return the beOfertaEmpleo
     */
    public BeOfertaEmpleo getBeOfertaEmpleo() {
        return beOfertaEmpleo;
    }

    /**
     * @param beOfertaEmpleo the beOfertaEmpleo to set
     */
    public void setBeOfertaEmpleo(BeOfertaEmpleo beOfertaEmpleo) {
        this.beOfertaEmpleo = beOfertaEmpleo;
    }
     
    
}

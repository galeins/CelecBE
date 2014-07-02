/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.celec.controlador.asesor;

import ec.gob.celec.persistencia.BeCalificacionEducacion;
import ec.gob.celec.servicio.oferta.OfertaServicio;
import ec.gob.celec.util.TipoCatalogoEnum;
import java.util.List;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;

/**
 *
 * @author Personal
 */
public class CalificacionNivelViewModel {
 
    OfertaServicio ofertaServicio = new OfertaServicio();
    public Integer codigoOferta;
    private List<BeCalificacionEducacion> listaCalificacion; 
    
    @AfterCompose
    public void afterCompose(@ExecutionArgParam("codigoProceso") Integer codigoOferta,@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);   
        this.codigoOferta=codigoOferta;       
        setListaCalificacion(ofertaServicio.getBeCalificacionNivel(codigoOferta, TipoCatalogoEnum.NIVEL_ESTUDIO.getCategoria()));
      }

    /**
     * @return the listaCalificacion
     */
    public List<BeCalificacionEducacion> getListaCalificacion() {
        return listaCalificacion;
    }

    /**
     * @param listaCalificacion the listaCalificacion to set
     */
    public void setListaCalificacion(List<BeCalificacionEducacion> listaCalificacion) {
        this.listaCalificacion = listaCalificacion;
    }

}

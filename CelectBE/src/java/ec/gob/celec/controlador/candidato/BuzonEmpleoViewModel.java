/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.celec.controlador.candidato;

import ec.gob.celec.persistencia.BeSelecionCvOfer;
import ec.gob.celec.seguridad.UserCredential;
import ec.gob.celec.servicio.oferta.OfertaServicio;
import ec.gob.celec.util.EnumSesion;
import java.util.HashMap;
import java.util.List;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zul.Window;

/**
 *
 * @author Personal
 */
public class BuzonEmpleoViewModel {
    
    private List<BeSelecionCvOfer> listadoBeSeleccionCvOfer;
    OfertaServicio ofertaServicio = new OfertaServicio();
    
    public BuzonEmpleoViewModel()
    {
        Session sess = Sessions.getCurrent();
	UserCredential cre = (UserCredential)sess.getAttribute(EnumSesion.userCredential.getNombre());
        listadoBeSeleccionCvOfer=ofertaServicio.getBeOfertasUsuario(cre.getCodigo());
    }

    /**
     * @return the listadoBeSeleccionCvOfer
     */
    public List<BeSelecionCvOfer> getListadoBeSeleccionCvOfer() {
        return listadoBeSeleccionCvOfer;
    }

    /**
     * @param listadoBeSeleccionCvOfer the listadoBeSeleccionCvOfer to set
     */
    public void setListadoBeSeleccionCvOfer(List<BeSelecionCvOfer> listadoBeSeleccionCvOfer) {
        this.listadoBeSeleccionCvOfer = listadoBeSeleccionCvOfer;
    }
       @Command        
        public void verOferta(@BindingParam("codigoOferta")Integer codigoProceso)
        {
           final HashMap<String, Integer> map = new HashMap<String, Integer>();
           map.put("accion", codigoProceso);
           Window window = (Window)Executions.createComponents(
                   "/celec/asesor/visualizarCargo.zul", null, map);
           window.doModal();
        }
}

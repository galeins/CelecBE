/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.celec.controlador.candidato;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;

/**
 *
 * @author Personal
 */
public class FrameCandidatoController extends SelectorComposer<Component>{
    @Listen("onClick = #btnHojaDeVida")
        public void doHojaDeVida()
        {
          Executions.sendRedirect("/celec/candidato/hojaDeVida.zul");
        } 
    @Listen("onClick = #btnBuzonEmpleo")
        public void doBuzonEmpleo()
        {
          Executions.sendRedirect("/celec/candidato/buzonEmpleo.zul");
        } 
     @Listen("onClick = #btnOfertaEmpleo")
        public void doOfertaEmpleo()
        {
          Executions.sendRedirect("/celec/candidato/ofertaEmpleoCandidato.zul");
        } 
     
     @Listen("onClick = #btnProcesoSeleccion")
        public void doProcesoseleccion()
        {
          Executions.sendRedirect("/celec/asesor/listadoProcesosSeleccion.zul");
        } 
}

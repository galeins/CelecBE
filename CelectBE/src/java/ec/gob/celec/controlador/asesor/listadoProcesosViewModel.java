/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.celec.controlador.asesor;

import ec.gob.celec.persistencia.BeOfertaEmpleo;
import ec.gob.celec.servicio.oferta.OfertaServicio;
import ec.gob.celec.servicio.proceeso.ProcesosSeleccionServicio;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

/**
 *
 * @author Personal 
 */
public final class listadoProcesosViewModel {
    OfertaServicio ofertaServ= new OfertaServicio();
    private List<BeOfertaEmpleo> listadoProcesosSeleccion;


    ProcesosSeleccionServicio procesosSeleccionServicio = new ProcesosSeleccionServicio();
    
   
    public listadoProcesosViewModel()
    {
      
       listadoProcesosSeleccion=procesosSeleccionServicio.getProcesosSeleccion(Integer.MIN_VALUE);
    }
    /**
     * @return the listadoProcesosSeleccion
     */ 
    public List<BeOfertaEmpleo> getListadoProcesosSeleccion() {
        return listadoProcesosSeleccion;
    }

    /**
     * @param listadoProcesosSeleccion the listadoProcesosSeleccion to set
     */
    public void setListadoProcesosSeleccion(List<BeOfertaEmpleo> listadoProcesosSeleccion) {
        this.listadoProcesosSeleccion = listadoProcesosSeleccion;
    }
    
    @Command
    public void desplegarProceso(@BindingParam("codigoOferta")Integer codigoProceso)
    {
       final HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("accion", codigoProceso);
        Window window = (Window)Executions.createComponents(
                "/celec/asesor/identificacionCargo.zul", null, map);
        window.doModal();
    }
   
    @Command
     public void parametrizarProceso(@BindingParam("codigoOferta")Integer codigoProceso)
     {
        final HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("codigoProceso", codigoProceso);
        Window window = (Window)Executions.createComponents(
                "/celec/asesor/parametroCalificacion.zul", null, map);
        window.doModal();
     }
   @Command
   @NotifyChange("listadoProcesosSeleccion") 
    public void copiarProceso(@BindingParam("codigoOferta")Integer codigoProceso)
    {
        if (codigoProceso == null) return;
        BeOfertaEmpleo beOfertaEmpleo;
        beOfertaEmpleo = ofertaServ.getBeOfertaByCodigo(codigoProceso);
        if ( Messagebox.show("¿Seguro que desea copiar el proceso " + beOfertaEmpleo.getCoCodigoOfertaOfe() + ", " + beOfertaEmpleo.getNbOfertaEmpleo() + "?", "Atención",Messagebox.YES | Messagebox.NO,Messagebox.INFORMATION) == Messagebox.YES)
        {
            beOfertaEmpleo.setCoOfertaEmpleo(null);
            Integer anio = new Date().getYear();
            anio=1900+anio;
            beOfertaEmpleo.setCoCodigoOfertaOfe(anio.toString().concat("-").concat(ofertaServ.getTotalFilasOfertaEmpleo().toString()));
            beOfertaEmpleo.setBeCategOfertas(null);
            beOfertaEmpleo.setBeColocacions(null);
            beOfertaEmpleo.setBeComentarioOfertas(null);
            beOfertaEmpleo.setBeEmpresa(null);
            beOfertaEmpleo.setBeModoEmpleoOfertas(null);
            beOfertaEmpleo.setBePesoOfertas(null);
            beOfertaEmpleo.setBeSelecionCvOfers(null);
            ofertaServ.grabarOferta(beOfertaEmpleo);
            Messagebox.show("El proceso ha sido copiado satisfactoriamente.","Atención",Messagebox.OK,Messagebox.INFORMATION);
            listadoProcesosSeleccion=procesosSeleccionServicio.getProcesosSeleccion(Integer.MIN_VALUE);
        }
    }
    
    @Command
    public void insertarRegistro()
    {
        final HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("accion", -1);
        Window window = (Window)Executions.createComponents(
                "/celec/asesor/identificacionCargo.zul", null, map);
        window.doModal();
    }


    public void setCodigodeOferta()
    {
        
    }


    


}

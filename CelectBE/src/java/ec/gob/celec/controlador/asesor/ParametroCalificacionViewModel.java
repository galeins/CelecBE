/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.celec.controlador.asesor;

import ec.gob.celec.persistencia.BeCalificacionEducacion;
import ec.gob.celec.persistencia.BePesoOferta;
import ec.gob.celec.servicio.oferta.OfertaServicio;
import ec.gob.celec.util.TipoCatalogoEnum;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Footer;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Window;

/**
 *
 * @author Personal
 */
public class ParametroCalificacionViewModel {
    
    @Wire
    Tabbox tabboxCalificacion;
    @Wire
    Footer footer_total;
    
    
    private Integer codigoOferta;
    OfertaServicio ofertaServicio = new OfertaServicio();
    private List<BePesoOferta> listadoAreasPonderacion;
    private List<BeCalificacionEducacion> listaCalificacion; 
    private List<BeCalificacionEducacion> listaMeritos;
    private List<BeCalificacionEducacion> listaPruebas;
    private List<BeCalificacionEducacion> listaEntrevista;
    BigDecimal totalAreaPonderacion=BigDecimal.ZERO;
    BigDecimal totalMerito=BigDecimal.ZERO;
    
    @Command
    public void desplegarParametro(@BindingParam("codigoNivel")Integer codigoNivel)
    {
         Window window = (Window)Executions.createComponents(
                "/celec/asesor/calificacionNivelEducacion.zul", null, null);
        window.doModal();
    }
    
    @AfterCompose
    public void afterCompose(@ExecutionArgParam("codigoProceso") Integer codigoOferta,@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);   
        this.codigoOferta=codigoOferta;
        getAreasPonderacion();
        //generarDatosParametrizacion();
        setListaMeritos(ofertaServicio.getBeCalificacionNivel(codigoOferta, TipoCatalogoEnum.TIPO_MERITO.getCategoria()));
        setListaPruebas(ofertaServicio.getBeCalificacionNivel(codigoOferta, TipoCatalogoEnum.TIPO_PRUEBA.getCategoria()));
        setListaEntrevista(ofertaServicio.getBeCalificacionNivel(codigoOferta, TipoCatalogoEnum.TIPO_ENTREVISTA.getCategoria()));
      }

    public void generarDatosParametrizacion()
    {
        Iterator iterator = listadoAreasPonderacion.iterator();
        BePesoOferta bePesoOferta;
        while (iterator.hasNext())
        {
            bePesoOferta = (BePesoOferta) iterator.next();            
            Tab tab = new Tab();
            Tabpanel tabpanel = new Tabpanel();  
            tabpanel.appendChild(crearGridDatos(bePesoOferta.getBeCategPeso().getVaTipoCalificacion()));
            tab.setLabel(bePesoOferta.getBeCategPeso().getNbCategPeso());
            tab.setSclass("menutabs");
            tabboxCalificacion.getTabs().appendChild(tab);
            tabboxCalificacion.getTabpanels().appendChild(tabpanel);
            //tabboxCalificacion.appendChild(tab);            
            
        }
    }
    public Grid crearGridDatos(String tipoCategoria)
    {
            Grid  gridDato = new Grid();            
            Column columnas = new Column();          
            Columns colsGrid = new Columns();
            columnas.setLabel("Detalle de la evaluación");  
            colsGrid.appendChild(columnas);            
            colsGrid.appendChild(new Column("Ponderación"));
            gridDato.appendChild(colsGrid);  
            /*poner filas*/
            Rows filas=new Rows();
            Row fila;
            Label labelDescripcion = null; 
            List<BeCalificacionEducacion> datos = ofertaServicio.getBeCalificacionNivel(this.codigoOferta,tipoCategoria);
            Iterator<BeCalificacionEducacion> iterator = datos.iterator();
            BeCalificacionEducacion registro;
            while (iterator.hasNext())
            {
                fila = new Row();
                registro= iterator.next();
                labelDescripcion = new Label();
                labelDescripcion.setValue(registro.getBeCatalogo().getNbCatalogo());
                
                fila.appendChild(labelDescripcion);                
                filas.appendChild(fila); 
            }
            gridDato.appendChild(filas);
            return gridDato;
    }
    public void getAreasPonderacion()
    {
        listadoAreasPonderacion=ofertaServicio.getBePesoOferta(this.codigoOferta);
         setListaCalificacion(ofertaServicio.getBeCalificacionNivel(codigoOferta,TipoCatalogoEnum.NIVEL_ESTUDIO.getCategoria()));
        getTotal();
    }
    /**
     * @return the listadoAreasPonderacion
     */
    public List<BePesoOferta> getListadoAreasPonderacion() {
        return listadoAreasPonderacion;
    }

    /**
     * @param listadoAreasPonderacion the listadoAreasPonderacion to set
     */
    public void setListadoAreasPonderacion(List<BePesoOferta> listadoAreasPonderacion) {
        this.listadoAreasPonderacion = listadoAreasPonderacion;
    }
    
    @Command
    @NotifyChange("footer_total")
    public BigDecimal getTotal()
    {
       
        Iterator iteratorDato = listadoAreasPonderacion.iterator();
        BePesoOferta bePesoOferta;
        totalAreaPonderacion = BigDecimal.ZERO;
        while (iteratorDato.hasNext())
        {
            bePesoOferta= (BePesoOferta) iteratorDato.next();
            totalAreaPonderacion = totalAreaPonderacion.add(bePesoOferta.getVaPesoOferta());
        }
        footer_total.setLabel(totalAreaPonderacion.toString());
        return totalAreaPonderacion;
    }

    @Command
    @NotifyChange("footer_total")
    public BigDecimal getTotalMerito()
    {
        
        Iterator iteratorDato = listaMeritos.iterator();
        BePesoOferta bePesoOferta;
        totalMerito = BigDecimal.ZERO;
        while (iteratorDato.hasNext())
        {
            bePesoOferta= (BePesoOferta) iteratorDato.next();
            totalMerito = totalAreaPonderacion.add(bePesoOferta.getVaPesoOferta());
        }
        footer_total.setLabel(totalAreaPonderacion.toString());
        return totalAreaPonderacion;
    }
    @Command
    @NotifyChange("listadoAreasPonderacion")
    public void grabarAreaPonderacion()
    {
        if (getTotal().compareTo(BigDecimal.valueOf(100))==0)
        {
            ofertaServicio.grabarAreaPonderacion(listadoAreasPonderacion);
            Messagebox.show("La información se ha guardado exitosamente","Atención",Messagebox.OK,Messagebox.INFORMATION);
        }
        else
        {
            Messagebox.show("Los valores de ponderación no son correctos.\nCorrija los valores para que sean igual a cien (100)","Atención",Messagebox.OK,Messagebox.ERROR);
        }
        
    }
    
    @Command
    @NotifyChange("listaMeritos")
    public void grabarMerito()
    {
        
            
            ofertaServicio.grabarMeritos(listaMeritos);
            Messagebox.show("La información se ha guardado exitosamente","Atención",Messagebox.OK,Messagebox.INFORMATION);
       
        
    }
    
    
    @Command
    @NotifyChange("listaPruebas")
    public void grabarPruebas()
    {
        
            ofertaServicio.grabarMeritos(listaPruebas);
            Messagebox.show("La información se ha guardado exitosamente","Atención",Messagebox.OK,Messagebox.INFORMATION);
       
        
    }
    
    @Command
    @NotifyChange("listaEntrevista")
    public void grabarEntrevista()
    {
        
            ofertaServicio.grabarMeritos(listaEntrevista);
            Messagebox.show("La información se ha guardado exitosamente","Atención",Messagebox.OK,Messagebox.INFORMATION);
       
        
    }
    @Command
    @NotifyChange("listaCalificacion")
    public void grabarNivelEducacion()
    {
        
            ofertaServicio.grabarMeritos(listaCalificacion);
            Messagebox.show("La información se ha guardado exitosamente","Atención",Messagebox.OK,Messagebox.INFORMATION);
       
        
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

    /**
     * @return the listaMeritos
     */
    public List<BeCalificacionEducacion> getListaMeritos() {
        return listaMeritos;
    }

    /**
     * @param listaMeritos the listaMeritos to set
     */
    public void setListaMeritos(List<BeCalificacionEducacion> listaMeritos) {
        this.listaMeritos = listaMeritos;
    }

    /**
     * @return the listaEntrevista
     */
    public List<BeCalificacionEducacion> getListaEntrevista() {
        return listaEntrevista;
    }

    /**
     * @param listaEntrevista the listaEntrevista to set
     */
    public void setListaEntrevista(List<BeCalificacionEducacion> listaEntrevista) {
        this.listaEntrevista = listaEntrevista;
    }

    /**
     * @return the listaPruebas
     */
    public List<BeCalificacionEducacion> getListaPruebas() {
        return listaPruebas;
    }

    /**
     * @param listaPruebas the listaPruebas to set
     */
    public void setListaPruebas(List<BeCalificacionEducacion> listaPruebas) {
        this.listaPruebas = listaPruebas;
    }
    
}

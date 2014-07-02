/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.celec.controlador.candidato;

import ec.gob.celec.persistencia.BeCapacitacion;
import ec.gob.celec.persistencia.BeCatalogo;
import ec.gob.celec.persistencia.BeCurriculo;
import ec.gob.celec.persistencia.BeIdioma;
import ec.gob.celec.persistencia.BePersona;
import ec.gob.celec.seguridad.UserCredential;
import ec.gob.celec.servicio.oferta.OfertaServicio;
import ec.gob.celec.util.EnumSesion;
import ec.gob.celec.util.TipoCatalogoEnum;
import java.util.Iterator;
import java.util.Set;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;

/**
 *
 * @author Personal
 */
public class IdiomaViewModel {
    
    OfertaServicio ofertaServicio = new OfertaServicio();
    private BePersona bePersona;
    private BeCurriculo beCurriculo;
    private BeCapacitacion beCapacitacion;   
    private Set<BeCatalogo> listaCatalogoIdioma;
    private Set<BeCatalogo> listaNivelIdioma;
        
    private ListModel<BeIdioma> listaIdioma;
    private Set<BeIdioma> registrosSeleccionados;

    public IdiomaViewModel()
    {
        getDatoCurriculo();
        generarCatalogos();
        getIdioma();
    }
    
       private void getDatoCurriculo()
    {
        Session sess = Sessions.getCurrent();
	UserCredential cre = (UserCredential)sess.getAttribute(EnumSesion.userCredential.getNombre());
        setBePersona(ofertaServicio.getBePersona(cre.getCodigoPersona()));
        setBeCurriculo(ofertaServicio.getBeCurriculo(getBePersona()));        
    }
    private void generarCatalogos()
    {
     setListaCatalogoIdioma(ofertaServicio.getCatalogo(TipoCatalogoEnum.IDIOMA.getCategoria()));
     setListaNivelIdioma(ofertaServicio.getCatalogo(TipoCatalogoEnum.NIVEL_IDIOMA.getCategoria()));
    }
    private void getIdioma()
    {
        setListaIdioma(new ListModelList<BeIdioma>(ofertaServicio.getIdioma(bePersona)));
          ((ListModelList<BeIdioma>)listaIdioma).setMultiple(true);   
    }
    /**
     * @return the beCurriculo
     */
    public BeCurriculo getBeCurriculo() {
        return beCurriculo;
    }

    /**
     * @param beCurriculo the beCurriculo to set
     */
    public void setBeCurriculo(BeCurriculo beCurriculo) {
        this.beCurriculo = beCurriculo;
    }

    /**
     * @return the beCapacitacion
     */
    public BeCapacitacion getBeCapacitacion() {
        return beCapacitacion;
    }

    /**
     * @param beCapacitacion the beCapacitacion to set
     */
    public void setBeCapacitacion(BeCapacitacion beCapacitacion) {
        this.beCapacitacion = beCapacitacion;
    }

    /**
     * @return the listaCatalogoIdioma
     */
    public Set<BeCatalogo> getListaCatalogoIdioma() {
        return listaCatalogoIdioma;
    }

    /**
     * @param listaCatalogoIdioma the listaCatalogoIdioma to set
     */
    public void setListaCatalogoIdioma(Set<BeCatalogo> listaCatalogoIdioma) {
        this.listaCatalogoIdioma = listaCatalogoIdioma;
    }

    /**
     * @return the listaNivelIdioma
     */
    public Set<BeCatalogo> getListaNivelIdioma() {
        return listaNivelIdioma;
    }

    /**
     * @param listaNivelIdioma the listaNivelIdioma to set
     */
    public void setListaNivelIdioma(Set<BeCatalogo> listaNivelIdioma) {
        this.listaNivelIdioma = listaNivelIdioma;
    }

    /**
     * @return the bePersona
     */
    public BePersona getBePersona() {
        return bePersona;
    }

    /**
     * @param bePersona the bePersona to set
     */
    public void setBePersona(BePersona bePersona) {
        this.bePersona = bePersona;
    }
    
    @Command
    @NotifyChange("listaIdioma")
    public void insertarRegistro()
    {
        ((ListModelList<BeIdioma>)listaIdioma).add(new BeIdioma());
        
    }
     public void eliminarRegistro()
    {
        Iterator iterator = registrosSeleccionados.iterator();
        BeIdioma beIdioma;
        while (iterator.hasNext())
        {
            beIdioma=(BeIdioma) iterator.next();         
            if (beIdioma.getBeCurriculo()!=null)
                ofertaServicio.eliminarIdioma(beIdioma);
            ((ListModelList<BeIdioma>)listaIdioma).remove(beIdioma);
        }         
       
    }
    
    @Command
    @NotifyChange("listaIdioma")
    public void grabar()
    {
         int respuesta = 0;
       if (registrosSeleccionados !=null)
       {
           if (registrosSeleccionados.size()>0)
               respuesta = Messagebox.show("Ha seleccionado ("+ registrosSeleccionados.size()+") registros para borrado. ¿Desea Continuar?","Atención", Messagebox.YES | Messagebox.NO,Messagebox.INFORMATION);
           if (respuesta == Messagebox.NO) return;
           eliminarRegistro();
       }
      ofertaServicio.grabarIdioma(((ListModelList<BeIdioma>)listaIdioma),this.getBeCurriculo());
      Messagebox.show("Su información de idiomas se ha guardado con exito.", "Atención", Messagebox.OK, Messagebox.INFORMATION);
    }

    @Command
    public void seleccionarBorrado() {
         registrosSeleccionados = ((ListModelList<BeIdioma>)getListaIdioma()).getSelection();  
    }
    /**
     * @return the listaIdioma
     */
    public ListModel<BeIdioma> getListaIdioma() {
        return listaIdioma;
    }

    /**
     * @param listaIdioma the listaIdioma to set
     */
    public void setListaIdioma(ListModel<BeIdioma> listaIdioma) {
        this.listaIdioma = listaIdioma;
    }

}

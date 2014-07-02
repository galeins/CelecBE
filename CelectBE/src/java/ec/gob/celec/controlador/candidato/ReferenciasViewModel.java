/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.celec.controlador.candidato;

import ec.gob.celec.persistencia.BeCatalogo;
import ec.gob.celec.persistencia.BeCurriculo;
import ec.gob.celec.persistencia.BePersona;
import ec.gob.celec.persistencia.BeRefePersonal;
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
public class ReferenciasViewModel {
    
    OfertaServicio ofertaServicio = new OfertaServicio();
    private BePersona bePersona;
    private BeCurriculo beCurriculo;
    private BeRefePersonal beRefePersonal;   
    private Set<BeCatalogo> listaTipoReferencias;
           
    private ListModel<BeRefePersonal> listaReferencias;
     
    private Set<BeRefePersonal> registrosSeleccionados;

    public ReferenciasViewModel()
    {
        getDatoCurriculo();
        generarCatalogos();
        getReferencias();
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
     setListaTipoReferencias(ofertaServicio.getCatalogo(TipoCatalogoEnum.TIPO_REFERENCIA.getCategoria()));
    }
    private void getReferencias()
    {
      
        setListaReferencias(new ListModelList<BeRefePersonal>(ofertaServicio.getReferencia(bePersona)));
        ((ListModelList<BeRefePersonal>)getListaReferencias()).setMultiple(true);   
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
    @NotifyChange("listaReferencias")
    public void insertarRegistro()
    {
         ((ListModelList<BeRefePersonal>)listaReferencias).add(new BeRefePersonal());
    }
     public void eliminarRegistro()
    {
        Iterator iterator = registrosSeleccionados.iterator();
        BeRefePersonal beRefePersonal;
        while (iterator.hasNext())
        {
            beRefePersonal=(BeRefePersonal) iterator.next();         
            if (beRefePersonal.getBeCurriculo()!=null)
                ofertaServicio.eliminarReferencia(beRefePersonal);
            ((ListModelList<BeRefePersonal>)listaReferencias).remove(beRefePersonal);
        }         
       
    }
    @Command
    @NotifyChange("listaReferencias")
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
      ofertaServicio.grabarReferencias(((ListModelList<BeRefePersonal>)listaReferencias),this.getBeCurriculo());
       Messagebox.show("Su información de referencias se ha guardado con exito.", "Atención", Messagebox.OK, Messagebox.INFORMATION);
    }
  @Command
    public void seleccionarBorrado() {  
         registrosSeleccionados = ((ListModelList<BeRefePersonal>)getListaReferencias()).getSelection();       
    }
    /**
     * @return the listaTipoReferencias
     */
    public Set<BeCatalogo> getListaTipoReferencias() {
        return listaTipoReferencias;
    }

    /**
     * @param listaTipoReferencias the listaTipoReferencias to set
     */
    public void setListaTipoReferencias(Set<BeCatalogo> listaTipoReferencias) {
        this.listaTipoReferencias = listaTipoReferencias;
    }

    

    /**
     * @return the beRefePersonal
     */
    public BeRefePersonal getBeRefePersonal() {
        return beRefePersonal;
    }

    /**
     * @param beRefePersonal the beRefePersonal to set
     */
    public void setBeRefePersonal(BeRefePersonal beRefePersonal) {
        this.beRefePersonal = beRefePersonal;
    }

    /**
     * @return the listaReferencias
     */
    public ListModel<BeRefePersonal> getListaReferencias() {
        return listaReferencias;
    }

    /**
     * @param listaReferencias the listaReferencias to set
     */
    public void setListaReferencias(ListModel<BeRefePersonal> listaReferencias) {
        this.listaReferencias = listaReferencias;
    }

}

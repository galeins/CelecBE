/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.celec.controlador.candidato;

import ec.gob.celec.persistencia.BeCatalogo;
import ec.gob.celec.persistencia.BeCurriculo;
import ec.gob.celec.persistencia.BeFormAcademica;
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
public class FormacionAcademicaViewModel {
    OfertaServicio ofertaServicio = new OfertaServicio();
    private BePersona bePersona;
    private BeCurriculo beCurriculo;
    private BeFormAcademica beFormacionAcademica;
    private Set<BeCatalogo> listaNivelEducacion;
    private Set<BeCatalogo> listaAreaEstudio;
    private ListModel<BeFormAcademica> listaFormacionAcademica;
    private BeCatalogo nivelEducacion,areaEstudio;
    private Set<BeFormAcademica> registrosSeleccionados;
    
    public FormacionAcademicaViewModel()
    {
        getDatoCurriculo();
        generarCatalogos();
        getFormacionAcademica();
    }
     private void getDatoCurriculo()
    {
        Session sess = Sessions.getCurrent();
	UserCredential cre = (UserCredential)sess.getAttribute(EnumSesion.userCredential.getNombre());
        setBePersona(ofertaServicio.getBePersona(cre.getCodigoPersona()));
        setBeCurriculo(ofertaServicio.getBeCurriculo(getBePersona()));        
    }
    private void getFormacionAcademica()
    {
           setListaFormacionAcademica(new ListModelList<BeFormAcademica>(ofertaServicio.getFormacionAcademica(bePersona)));
         ((ListModelList<BeFormAcademica>)listaFormacionAcademica).setMultiple(true);     
        
    }
    private void generarCatalogos()
       {
           setListaNivelEducacion(ofertaServicio.getCatalogo(TipoCatalogoEnum.NIVEL_ESTUDIO.getCategoria()));
           setListaAreaEstudio(ofertaServicio.getCatalogo(TipoCatalogoEnum.CATEGORIA_OFERTA.getCategoria()));
     
    }
    @Command
    @NotifyChange("listaFormacionAcademica")
    public void insertarRegistro()
    {
        BeFormAcademica beFormacionAcademica=new BeFormAcademica();
        beFormacionAcademica.setEsEstado("Activo");
        ((ListModelList<BeFormAcademica>)listaFormacionAcademica).add(beFormacionAcademica);
    }
    
    @Command
    public void seleccionarBorrado() {
        //Set<Car> selectedCars = ((ListModelList<Car>)carsModel).getSelection();
         registrosSeleccionados = ((ListModelList<BeFormAcademica>)getListaFormacionAcademica()).getSelection();
        //int size = selectedCars.size();
         
        //showNotify(size > 0 ? size + " cars selected: " + selectedCars : "no car selected", win);
    }
    
    public void eliminarRegistro()
    {
        Iterator iterator = registrosSeleccionados.iterator();
        BeFormAcademica beFormacionAcademica;
        while (iterator.hasNext())
        {
            beFormacionAcademica=(BeFormAcademica) iterator.next();         
            if (beFormacionAcademica.getBeCurriculo()!=null)
                ofertaServicio.eliminarFormacionAcademica(beFormacionAcademica);
            ((ListModelList<BeFormAcademica>)listaFormacionAcademica).remove(beFormacionAcademica);
        }         
       
    }
    
    @Command
    @NotifyChange("listaFormacionAcademica")
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
      ofertaServicio.grabarFormacionAcademica(((ListModelList<BeFormAcademica>)listaFormacionAcademica),this.beCurriculo);
      Messagebox.show("Su información académica se ha guardado con exito.", "Atención", Messagebox.OK, Messagebox.INFORMATION);
    }
    /**
     * @return the listaNivelEducacion
     */
    public Set<BeCatalogo> getListaNivelEducacion() {
        return listaNivelEducacion;
    }

    /**
     * @param listaNivelEducacion the listaNivelEducacion to set
     */
    public void setListaNivelEducacion(Set<BeCatalogo> listaNivelEducacion) {
        this.listaNivelEducacion = listaNivelEducacion;
    }

    /**
     * @return the nivelEducacion
     */
    public BeCatalogo getNivelEducacion() {
        return nivelEducacion;
    }

    /**
     * @param nivelEducacion the nivelEducacion to set
     */
    public void setNivelEducacion(BeCatalogo nivelEducacion) {
        this.nivelEducacion = nivelEducacion;
    }

    /**
     * @return the listaAreaEstudio
     */
    public Set<BeCatalogo> getListaAreaEstudio() {
        return listaAreaEstudio;
    }

    /**
     * @param listaAreaEstudio the listaAreaEstudio to set
     */
    public void setListaAreaEstudio(Set<BeCatalogo> listaAreaEstudio) {
        this.listaAreaEstudio = listaAreaEstudio;
    }

    /**
     * @return the areaEstudio
     */
    public BeCatalogo getAreaEstudio() {
        return areaEstudio;
    }

    /**
     * @param areaEstudio the areaEstudio to set
     */
    public void setAreaEstudio(BeCatalogo areaEstudio) {
        this.areaEstudio = areaEstudio;
    }

    /**
     * @return the listaFormacionAcademica
     */
    public ListModel<BeFormAcademica> getListaFormacionAcademica() {
        return listaFormacionAcademica;
    }

    /**
     * @param listaFormacionAcademica the listaFormacionAcademica to set
     */
    public void setListaFormacionAcademica(ListModel<BeFormAcademica> listaFormacionAcademica) {
        this.listaFormacionAcademica = listaFormacionAcademica;
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
     * @return the beFormacionAcademica
     */
    public BeFormAcademica getBeFormacionAcademica() {
        return beFormacionAcademica;
    }

    /**
     * @param beFormacionAcademica the beFormacionAcademica to set
     */
    public void setBeFormacionAcademica(BeFormAcademica beFormacionAcademica) {
        this.beFormacionAcademica = beFormacionAcademica;
    }
}

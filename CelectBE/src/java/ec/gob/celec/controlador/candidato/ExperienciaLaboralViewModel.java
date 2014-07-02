/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.celec.controlador.candidato;

import ec.gob.celec.persistencia.BeCatalogo;
import ec.gob.celec.persistencia.BeCurriculo;
import ec.gob.celec.persistencia.BeExpLaboral;
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
public class ExperienciaLaboralViewModel {
    OfertaServicio ofertaServicio = new OfertaServicio();
    private BePersona bePersona;
    private BeCurriculo beCurriculo;
    private BeExpLaboral beExpLaboral;   
    private Set<BeCatalogo> listaAreaEstudio;
    private ListModel<BeExpLaboral> listaExperiencia;
    private BeCatalogo areaEstudio;
    private Set<BeExpLaboral> registrosSeleccionados;
    
    public ExperienciaLaboralViewModel()
    {
        getDatoCurriculo();
        generarCatalogos();
        getExperiencia();       
    }
     private void getDatoCurriculo()
    {
        Session sess = Sessions.getCurrent();
	UserCredential cre = (UserCredential)sess.getAttribute(EnumSesion.userCredential.getNombre());
        setBePersona(ofertaServicio.getBePersona(cre.getCodigoPersona()));
        setBeCurriculo(ofertaServicio.getBeCurriculo(getBePersona()));        
    }
    private void getExperiencia()
    {
        setListaExperiencia(new ListModelList<BeExpLaboral>(ofertaServicio.getExperiencia(bePersona)));
          ((ListModelList<BeExpLaboral>)listaExperiencia).setMultiple(true);   
        
    }
    private void generarCatalogos()
       {
         setListaAreaEstudio(ofertaServicio.getCatalogo(TipoCatalogoEnum.CATEGORIA_OFERTA.getCategoria()));
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
     * @return the beExpLaboral
     */
    public BeExpLaboral getBeExpLaboral() {
        return beExpLaboral;
    }

    /**
     * @param beExpLaboral the beExpLaboral to set
     */
    public void setBeExpLaboral(BeExpLaboral beExpLaboral) {
        this.beExpLaboral = beExpLaboral;
    }

    
    
    @Command
    @NotifyChange("listaExperiencia")
    public void insertarRegistro()
    {
        BeExpLaboral beExpLaboral=new BeExpLaboral();
        beExpLaboral.setEsEstado("Activo");           
        ((ListModelList<BeExpLaboral>)listaExperiencia).add(beExpLaboral);
    }
    
    public void eliminarRegistro()
    {
        Iterator iterator = registrosSeleccionados.iterator();
        BeExpLaboral beExpLaboral;
        while (iterator.hasNext())
        {
            beExpLaboral=(BeExpLaboral) iterator.next();
            if (beExpLaboral.getBeCurriculo()!=null) 
                ofertaServicio.eliminarExperienciaLaboral(beExpLaboral);
             ((ListModelList<BeExpLaboral>)listaExperiencia).remove(beExpLaboral);        
        }        
    }
    
    @Command
    @NotifyChange("listaExperiencia")
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
        ofertaServicio.grabarExperienciaLaboral(((ListModelList<BeExpLaboral>)listaExperiencia),this.beCurriculo);
        Messagebox.show("Su experiencia laboral se ha guardado con exito.", "Atención", Messagebox.OK, Messagebox.INFORMATION);
    }
  @Command
    public void seleccionarBorrado() {
        //Set<Car> selectedCars = ((ListModelList<Car>)carsModel).getSelection();
         registrosSeleccionados = ((ListModelList<BeExpLaboral>)getListaExperiencia()).getSelection();
        //int size = selectedCars.size();
         
        //showNotify(size > 0 ? size + " cars selected: " + selectedCars : "no car selected", win);
    }
    /**
     * @return the listaExperiencia
     */
    public ListModel<BeExpLaboral> getListaExperiencia() {
        return listaExperiencia;
    }

    /**
     * @param listaExperiencia the listaExperiencia to set
     */
    public void setListaExperiencia(ListModel<BeExpLaboral> listaExperiencia) {
        this.listaExperiencia = listaExperiencia;
    }
}

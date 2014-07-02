/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.celec.controlador.candidato;

import ec.gob.celec.persistencia.BeCapacitacion;
import ec.gob.celec.persistencia.BeCatalogo;
import ec.gob.celec.persistencia.BeCurriculo;
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
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;

/**
 *
 * @author Personal
 */
public class CapacitacionViewModel {
    OfertaServicio ofertaServicio = new OfertaServicio();
    private BePersona bePersona;
    private BeCurriculo beCurriculo;
    private BeCapacitacion beCapacitacion;   
    private Set<BeCatalogo> listaAreaEstudio;
    private ListModel<BeCapacitacion> listaCapacitacion;
    private BeCatalogo areaEstudio;
    private Set<BeCapacitacion> registrosSeleccionados;
    
    public CapacitacionViewModel()
    {
        getDatoCurriculo();
        generarCatalogos();
        getCapacitacion();
    }
     private void getDatoCurriculo()
    {
        Session sess = Sessions.getCurrent();
	UserCredential cre = (UserCredential)sess.getAttribute(EnumSesion.userCredential.getNombre());
        setBePersona(ofertaServicio.getBePersona(cre.getCodigoPersona()));
        setBeCurriculo(ofertaServicio.getBeCurriculo(getBePersona()));        
    }
    private void getCapacitacion()
    {
        setListaCapacitacion(new ListModelList<BeCapacitacion>(ofertaServicio.getCapacitacion(bePersona)));
         ((ListModelList<BeCapacitacion>)listaCapacitacion).setMultiple(true);

               
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
     * @return the listaCapacitacion
     */
//    public Set<BeCapacitacion> getListaCapacitacion() {
//        return listaCapacitacion;
//    }

    /**
     * @param listaCapacitacion the listaCapacitacion to set
     */
//    public void setListaCapacitacion(Set<BeCapacitacion> listaCapacitacion) {
//        this.listaCapacitacion = listaCapacitacion;
//    }
    
    @Command
    @NotifyChange("listaCapacitacion")
    public void insertarRegistro()
    {
        BeCapacitacion beCapacitacion=new BeCapacitacion();
        beCapacitacion.setEsEstado("Activo");
        ((ListModelList<BeCapacitacion>)listaCapacitacion).add(beCapacitacion);       
    }
    
    
    public void eliminarRegistro()
    {
        Iterator iterator = registrosSeleccionados.iterator();
        BeCapacitacion beCapacitacion;
        while (iterator.hasNext())
        {
            beCapacitacion=(BeCapacitacion) iterator.next();         
            if (beCapacitacion.getBeCurriculo()!=null)
                ofertaServicio.eliminarCapacitacion(beCapacitacion);
            ((ListModelList<BeCapacitacion>)listaCapacitacion).remove(beCapacitacion);
        }         
       
    }
    @Command
   @NotifyChange("listaCapacitacion")
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
        ofertaServicio.grabarCapacitacion(((ListModelList<BeCapacitacion>)listaCapacitacion),this.getBeCurriculo());
      Messagebox.show("Su información de capacitación se ha guardado con éxito.","Atención",Messagebox.OK,Messagebox.INFORMATION);
    }
    
    @Command
    public void updateMessage() {
        //Set<Car> selectedCars = ((ListModelList<Car>)carsModel).getSelection();
         registrosSeleccionados = ((ListModelList<BeCapacitacion>)getListaCapacitacion()).getSelection();
        //int size = selectedCars.size();
         
        //showNotify(size > 0 ? size + " cars selected: " + selectedCars : "no car selected", win);
    }

    /**
     * @return the listaCapacitacion
     */
    public ListModel<BeCapacitacion> getListaCapacitacion() {
        return listaCapacitacion;
    }

    /**
     * @param listaCapacitacion the listaCapacitacion to set
     */
    public void setListaCapacitacion(ListModel<BeCapacitacion> listaCapacitacion) {
        this.listaCapacitacion = listaCapacitacion;
    }
}

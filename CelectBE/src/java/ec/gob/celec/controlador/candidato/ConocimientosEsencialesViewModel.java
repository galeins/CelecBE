/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.celec.controlador.candidato;

import ec.gob.celec.persistencia.BeCapacitacion;
import ec.gob.celec.persistencia.BeCatalogo;
import ec.gob.celec.persistencia.BeConocimiento;
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
import org.zkoss.zul.Messagebox;

/**
 *
 * @author Personal
 */
public class ConocimientosEsencialesViewModel {
    OfertaServicio ofertaServicio = new OfertaServicio();
    private BePersona bePersona;
    private BeCurriculo beCurriculo;
    private BeConocimiento beConocimiento;   
    private Set<BeCatalogo> listaAreaEstudio;
    private Set<BeConocimiento> listaConocimientosEsenciales;
    private BeCatalogo areaEstudio;
    
    public ConocimientosEsencialesViewModel()
    {
        getDatoCurriculo();
        generarCatalogos();
        getCapacitacion();
       // listaConocimientosEsenciales.add(new BeConocimiento());
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
        setListaConocimientosEsenciales(ofertaServicio.getConocimientosEscenciales(bePersona));
        
    }
    private void generarCatalogos()
       {
         setListaAreaEstudio(ofertaServicio.getCatalogo(TipoCatalogoEnum.AREA_CONOCIMIENTO.getCategoria()));
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

      
    @Command
    @NotifyChange("listaConocimientosEsenciales")
    public void insertarRegistro()
    {
        BeConocimiento beConocimiento=new BeConocimiento();
        beConocimiento.setEsEstado("Activo");
        getListaConocimientosEsenciales().add(beConocimiento);
    } 
    
    @Command
    @NotifyChange("listaConocimientosEsenciales")
    public void grabar()
    {
      eliminarRegistro();
      ofertaServicio.grabarConocimientosEscenciales(this.getListaConocimientosEsenciales(),this.getBeCurriculo());
       Messagebox.show("Su inforamación de conocimientos se ha guardado con éxito.","Atención",Messagebox.OK,Messagebox.INFORMATION);
    }
public void eliminarRegistro()
    {
        Iterator iterator = listaConocimientosEsenciales.iterator();
        BeConocimiento beConocimiento;
        while (iterator.hasNext())
        {
            beConocimiento=(BeConocimiento) iterator.next();
            if (beConocimiento.getEsEstado().equals("Inactivo"))
            {
                
                ofertaServicio.eliminarConocimiento(beConocimiento);
                listaConocimientosEsenciales.remove(beConocimiento); 
            }           
        }
        
    }
    /**
     * @return the beConocimiento
     */
    public BeConocimiento getBeConocimiento() {
        return beConocimiento;
    }

    /**
     * @param beConocimiento the beConocimiento to set
     */
    public void setBeConocimiento(BeConocimiento beConocimiento) {
        this.beConocimiento = beConocimiento;
    }

    /**
     * @return the listaConocimientosEsenciales
     */
    public Set<BeConocimiento> getListaConocimientosEsenciales() {
        return listaConocimientosEsenciales;
    }

    /**
     * @param listaConocimientosEsenciales the listaConocimientosEsenciales to set
     */
    public void setListaConocimientosEsenciales(Set<BeConocimiento> listaConocimientosEsenciales) {
        this.listaConocimientosEsenciales = listaConocimientosEsenciales;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.celec.controlador.general.ViewModel;

import ec.gob.celec.persistencia.BeCatalogo;
import ec.gob.celec.persistencia.BeCurriculo;
import ec.gob.celec.persistencia.BeOfertaEmpleo;
import ec.gob.celec.persistencia.BePersona;
import ec.gob.celec.persistencia.BeSelecionCvOfer;
import ec.gob.celec.seguridad.AutentificacionCelec;
import ec.gob.celec.seguridad.UserCredential;
import ec.gob.celec.servicio.oferta.OfertaServicio;
import ec.gob.celec.util.EnumSesion;
import ec.gob.celec.util.TipoCatalogoEnum;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;


/**
 *
 * @author Personal
 */
public final class OfertasViewModel {
    OfertaServicio ofertaServ= new OfertaServicio();
    private Set<BeCatalogo> catalogoCategoria;
    private List<BeOfertaEmpleo> datosOfertaEmpleo;
    private BeCatalogo beCatalogo;

    
    
    private int codigoCategoria;
    
    public OfertasViewModel()
    {
        //Cients.showNotification("No olvide seleccionar el establecimiento para la factura","info",null,"end_center",5000);
     catalogoCategoria=getCatalogos();
     datosOfertaEmpleo=getOfertas(); 
    }
    
    
    
    public Set<BeCatalogo> getCatalogos()
    {
        return ofertaServ.getCatalogo(TipoCatalogoEnum.CATEGORIA_OFERTA.getCategoria());                        
    }

    public List<BeOfertaEmpleo> getOfertas()
    {
        return ofertaServ.getOfertas(-1);
    }
    
    
    @Command
    @NotifyChange("datosOfertaEmpleo")
    public void buscarOfertas()
    {
      if (beCatalogo ==null) return;
      datosOfertaEmpleo=getOfertas(beCatalogo.getCoCatalogo());
    }
    
    @Command    
    public void aplicarOferta(@BindingParam("codigoOferta")Integer codigoOferta)
    {
      Session sess = Sessions.getCurrent();
      UserCredential cre = (UserCredential)sess.getAttribute(EnumSesion.userCredential.getNombre());
      if (cre == null)
      {
          Messagebox.show("Para aplicar debe ser un usuario registrado. \nIngrese su nombre y clave, si ya es un usuario registrado.\nSi aún no lo es seleccione la opción Registrarme.","Atención",Messagebox.OK,Messagebox.EXCLAMATION);
          return;
      }
      if (cre.isAnonymous())
      {
          Messagebox.show("Para aplicar debe ser un usuario registrado. \nIngrese su nombre y clave, si ya es un usuario registrado.\nSi aún no lo es seleccione la opción Registrarme.","Atención",Messagebox.OK,Messagebox.EXCLAMATION);
          return;
      }
      BeSelecionCvOfer beSeleccionCvOfer=ofertaServ.getBeOfertaUsuario(codigoOferta, cre.getCodigo());
      if (beSeleccionCvOfer == null)
      {   
          beSeleccionCvOfer = new BeSelecionCvOfer();
          BePersona bePersona = (BePersona) cre.getAdUsuario().getBePersonas().iterator().next();
          BeCurriculo beCurriculo = (BeCurriculo) bePersona.getBeCurriculos().iterator().next();
          BeOfertaEmpleo beOfertaEmpleo = ofertaServ.getBeOfertaByCodigo(codigoOferta);
          beSeleccionCvOfer.setBeCurriculo(beCurriculo);
          beSeleccionCvOfer.setBeOfertaEmpleo(beOfertaEmpleo);
          ofertaServ.insertarSeleccionOferta(beSeleccionCvOfer);
          Messagebox.show("Proceso realizado satisfactoriamente.\nUsted ahora está aplicando al proceso de selección " + beOfertaEmpleo.getCoCodigoOfertaOfe()+ " para el puesto de : " + beOfertaEmpleo.getNbOfertaEmpleo(),"Información",Messagebox.OK,Messagebox.INFORMATION);
      }
      else
      { 
          Messagebox.show("Usted ya ha aplicado a esta oferta. Revise su buzón de empleo.","Información",Messagebox.OK,Messagebox.INFORMATION);
      }
      
      
      
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
    public List<BeOfertaEmpleo> getOfertas(int codigoCategoria)
    {
        return ofertaServ.getOfertas(codigoCategoria);
    }
    /**
     * @return the catalogoCategoria
     */
    public Set<BeCatalogo> getCatalogoCategoria() {        
        return catalogoCategoria;
    }

    /**
     * @param catalogoCategoria the catalogoCategoria to set
     */
    public void setCatalogoCategoria(Set<BeCatalogo> catalogoCategoria) {
        this.catalogoCategoria = catalogoCategoria;
    }

    /**
     * @return the datosOfertaEmpleo
     */
    public List<BeOfertaEmpleo> getDatosOfertaEmpleo() {
        return datosOfertaEmpleo;
    }

    /**
     * @param datosOfertaEmpleo the datosOfertaEmpleo to set
     */
    public void setDatosOfertaEmpleo(List<BeOfertaEmpleo> datosOfertaEmpleo) {
        this.datosOfertaEmpleo = datosOfertaEmpleo;
    }

    /**
     * @return the codigoCategoria
     */
    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    /**
     * @param codigoCategoria the codigoCategoria to set
     */
    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    /**
     * @return the beCatalogo
     */
    public BeCatalogo getBeCatalogo() {
        return beCatalogo;
    }

    /**
     * @param beCatalogo the beCatalogo to set
     */
    public void setBeCatalogo(BeCatalogo beCatalogo) {
        this.beCatalogo = beCatalogo;
    }

    
}

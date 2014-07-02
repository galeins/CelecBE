/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.celec.controlador.asesor;
import ec.gob.celec.persistencia.BeCatalogo;
import ec.gob.celec.persistencia.BeOfertaEmpleo;
import ec.gob.celec.servicio.oferta.OfertaServicio;
import ec.gob.celec.util.TipoCatalogoEnum;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.zul.Messagebox;

/**
 *
 * @author Personal
 */
public final class NuevoProcesoViewModel {
    OfertaServicio ofertaServ= new OfertaServicio(); 
    private Set<BeCatalogo> listaCargos =getCatalogos();
    private Set<BeCatalogo> listaDepartamentos =getDepartamentos();
    private Set<BeCatalogo> listaTipoRelacion =getTipoRelacion();
    private BeOfertaEmpleo beOfertaEmpleo;
    private Set<BeCatalogo> listaNivelEducacion =getNivelEducacion();
    private Set<BeCatalogo> listaAreaEstudios = getAreaEstudios();
            
         

    
    public void nuevoRegistro()
    {
        beOfertaEmpleo = new BeOfertaEmpleo();
        beOfertaEmpleo.setBeCatalogoByCoCategoriaOfertaOfe(new BeCatalogo());
        beOfertaEmpleo.setBeCatalogoByCoDepartamentoOfe(new BeCatalogo());
        beOfertaEmpleo.setBeCatalogoByCoRelaLabOferemp(new BeCatalogo());
        beOfertaEmpleo.setBeCatalogoByCoInstruccionOferemp(new BeCatalogo());
        beOfertaEmpleo.setBeCatalogoByCoAreaEstudio(new BeCatalogo());
        beOfertaEmpleo.setVaMensualOferemp(BigDecimal.ZERO);
        beOfertaEmpleo.setFeCreacion(new Date());
        beOfertaEmpleo.setFeFinvigenOferemp(new Date());
        beOfertaEmpleo.setFeInivigenOferemp(new Date());
    }
   public Set<BeCatalogo> getAreaEstudios()
   {
        return ofertaServ.getCatalogo(TipoCatalogoEnum.CATEGORIA_OFERTA.getCategoria());                            
   }
    public Set<BeCatalogo> getNivelEducacion()
   {
        return ofertaServ.getCatalogo(TipoCatalogoEnum.NIVEL_ESTUDIO.getCategoria());                            
   }
    
    public Set<BeCatalogo> getTipoRelacion()
   {
        return ofertaServ.getCatalogo(TipoCatalogoEnum.TIPO_RELACION_LABORAL.getCategoria());                            
   }
    public Set<BeCatalogo> getDepartamentos()
    {
        return ofertaServ.getCatalogo(TipoCatalogoEnum.DEPARTAMENTO.getCategoria());                            
    }
     public Set<BeCatalogo> getCatalogos()
    {
        return ofertaServ.getCatalogo(TipoCatalogoEnum.CARGOS.getCategoria());                        
    }

          
    @Command    
    public void grabar()
    {
       beOfertaEmpleo.setNbOfertaEmpleo(beOfertaEmpleo.getBeCatalogoByCoCategoriaOfertaOfe().getNbCatalogo());
       if (beOfertaEmpleo.getCoCodigoOfertaOfe()==null)
       {
           Integer anio = new Date().getYear();
           anio=1900+anio;
           beOfertaEmpleo.setCoCodigoOfertaOfe(anio.toString().concat("-").concat(ofertaServ.getTotalFilasOfertaEmpleo().toString()));
       }
       ofertaServ.grabarOferta(this.beOfertaEmpleo);
       ofertaServ.generarPonderacion(this.beOfertaEmpleo);
       ofertaServ.generarCalificacionNivelEducacion(beOfertaEmpleo);
       ofertaServ.generarMerito(beOfertaEmpleo);
       ofertaServ.generarPrueba(beOfertaEmpleo);
       ofertaServ.generarEntrevista(beOfertaEmpleo);
       Messagebox.show("La oferta se ha guardado con éxito.", "Atención", Messagebox.OK, Messagebox.INFORMATION);
    }
    
   
    /**
     * @return the beOfertaEmpleo
     */
    public BeOfertaEmpleo getBeOfertaEmpleo() {       
        return beOfertaEmpleo;
    }

    /**
     * @param beOfertaEmpleo the beOfertaEmpleo to set
     */
    public void setBeOfertaEmpleo(BeOfertaEmpleo beOfertaEmpleo) {
        this.beOfertaEmpleo = beOfertaEmpleo;
    }

    /**
     * @return the listaDepartamentos
     */
    public Set<BeCatalogo> getListaDepartamentos() {
        return listaDepartamentos; 
    }

    /**
     * @param listaDepartamentos the listaDepartamentos to set
     */
    public void setListaDepartamentos(Set<BeCatalogo> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }

    /**
     * @return the listaTipoRelacion
     */
    public Set<BeCatalogo> getListaTipoRelacion() {
        return listaTipoRelacion;
    }

    /**
     * @param listaTipoRelacion the listaTipoRelacion to set
     */
    public void setListaTipoRelacion(Set<BeCatalogo> listaTipoRelacion) {
        this.listaTipoRelacion = listaTipoRelacion;
    }

    /**
     * @return the listaCargos
     */
    public Set<BeCatalogo> getListaCargos() {
        return listaCargos;
    }

    /**
     * @param listaCargos the listaCargos to set
     */
    public void setListaCargos(Set<BeCatalogo> listaCargos) {
        this.listaCargos = listaCargos;
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
     * @return the listaAreaEstudios
     */
    public Set<BeCatalogo> getListaAreaEstudios() {
        return listaAreaEstudios;
    }

    /**
     * @param listaAreaEstudios the listaAreaEstudios to set
     */
    public void setListaAreaEstudios(Set<BeCatalogo> listaAreaEstudios) {
        this.listaAreaEstudios = listaAreaEstudios;
    }
   
    @AfterCompose
    public void initSetup(@ExecutionArgParam("accion") Integer codigoOferta)
    {
        if (codigoOferta <0)
             nuevoRegistro();
        else
            getOfertaEmpleo(codigoOferta);
        
    }
    public void getOfertaEmpleo(Integer codigoOferta)
    {
        setBeOfertaEmpleo(ofertaServ.getBeOfertaByCodigo(codigoOferta));
    }
}

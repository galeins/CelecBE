/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.celec.controlador.candidato;

import ec.gob.celec.persistencia.BeCatalogo;
import ec.gob.celec.persistencia.BeCurriculo;
import ec.gob.celec.persistencia.BePersona;
import ec.gob.celec.seguridad.UserCredential;
import ec.gob.celec.servicio.oferta.OfertaServicio;
import ec.gob.celec.util.EnumSesion;
import ec.gob.celec.util.TipoCatalogoEnum;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;
import java.io.IOException;
import java.util.HashMap;
import org.zkoss.image.AImage;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Fileupload;
import org.zkoss.zul.Window;

/**
 *
 * @author Personal
 */
public final class HojaDeVidaViewModel {
    OfertaServicio ofertaServicio = new OfertaServicio();
    private BeCurriculo beCurriculo;
    private BePersona bePersona;
    private Set<BeCatalogo> listaTiposIdentificacion;
    private Set<BeCatalogo> listaGenero;
    private Set<BeCatalogo> listaEstadoCivil;
    private Set<BeCatalogo> listaPaises;
    private Set<BeCatalogo> listaLugarResidencia;
    private Set<BeCatalogo> listaTipoLicencia;
    private Set<BeCatalogo> listaGrupoEtnico;
    private Set<BeCatalogo> listaTipoIncapacidad;
    private Set<BeCatalogo> listaNivelAcademico;
    private BeCatalogo genero,estadoCivil,paises,lugarResidencia,tipoLicencia,grupoEtnico,tipoIncapacidad,tipoIdentificacion;
    public Combobox combo;
    private String edad;
    private boolean deshabilitarExtranjero;
    private AImage foto;
    
    @Wire("#textNombreCompleto")
    Textbox textNombreCompleto;
    
    @Wire("#textApellidosCompletos")
    Textbox textApellidosCompletos;
    @Wire("#textNumeroDocumento")
    Textbox textNumeroDocumento;
    @Wire("#comboboxTipoDocumento")
    Combobox comboboxTipoDocumento;
    @Wire("#dateboxNacimiento")
    Datebox dateboxNacimiento;
    @Wire("#comboboxNivelAcademico")
    Combobox comboboxNivelAcademico;
    @Wire("#comboboxGenero")
    Combobox comboboxGenero;
    @Wire("#comboboxEstadoCivil")
    Combobox comboboxEstadoCivil;
    @Wire("#radioGroupExtranjero")
    Radiogroup radioGroupExtranjero;
    @Wire("#textNacionalidad")
    Textbox textNacionalidad;
    @Wire("#textCiudadOrigen")
    Textbox textCiudadOrigen;
    @Wire("#comboboxPaisResidencia")
    Combobox comboboxPaisResidencia;
    @Wire("#textDomicilio")
    Textbox textDomicilio;
    @Wire("#comboboxProvincia")
    Combobox comboboxProvincia;
    @Wire("#textCanton")
    Textbox textCanton;
    @Wire("#comboboxGrupoEtnico")
    Combobox comboboxGrupoEtnico;
    @Wire("#textCorreoElectronico")
    Textbox textCorreoElectronico;
    @Wire("#textTelefonoConvencional")
    Intbox textTelefonoConvencional;
    
    
    public boolean validarDatos()
    {
        try
        {
            textNombreCompleto.getValue();
            textApellidosCompletos.getValue();
            textNumeroDocumento.getValue();
            comboboxTipoDocumento.getValue();
            dateboxNacimiento.setFocus(true);           
            dateboxNacimiento.getValue();
            comboboxNivelAcademico.setFocus(true);
            comboboxNivelAcademico.getValue();            
            comboboxGenero.getValue();
            comboboxGenero.setFocus(true);
            comboboxEstadoCivil.setFocus(true);
            comboboxEstadoCivil.getValue();            
            radioGroupExtranjero.setFocus(true);
            if (radioGroupExtranjero.getSelectedItem() == null)
                throw new org.zkoss.zk.ui.WrongValueException();
            if (radioGroupExtranjero.getSelectedItem().getValue() ==null)
                throw new org.zkoss.zk.ui.WrongValueException();
            textNacionalidad.setFocus(true);
            textNacionalidad.getValue();
            textCiudadOrigen.setFocus(true);
            textCiudadOrigen.getValue();
            comboboxPaisResidencia.setFocus(true);
            comboboxPaisResidencia.getValue();            
            textDomicilio.getValue();
            if (bePersona.getVaExtranjeroPer().equals("NO"))
            {
                if (comboboxProvincia.getValue()==null) throw new org.zkoss.zk.ui.WrongValueException();
                if (textCanton.getValue()==null) throw new org.zkoss.zk.ui.WrongValueException();
            }
            comboboxGrupoEtnico.setFocus(true);
            comboboxGrupoEtnico.getValue();
            textCorreoElectronico.setFocus(true);
            textCorreoElectronico.getValue();
            textTelefonoConvencional.getValue();
        }
        catch(org.zkoss.zk.ui.WrongValueException e)
        {
           Clients.showNotification("Existen algunos datos faltantes en su hoja de vida. Es recomendable que los complete para que la hoja de vida se active y pueda aplicar a las ofertas de empleo.","error",null,"middle_center",3000,true);
            return false;
        }
        return true;
    }
    
    @Command
    @NotifyChange("foto")
    public void subirArchivo() throws InterruptedException, IOException{
        org.zkoss.util.media.Media media = Fileupload.get();
        if (media instanceof org.zkoss.image.Image) 
        {
            if (media.getByteData().length>30*1024)
            {
                Messagebox.show("El arhivo seleccionado sobrepasa el tamaño de 30K.\n Por favor seleccione un archivo más pequeño.");
                return;
            }
            this.getBePersona().setImFotoPer(media.getByteData());            
            foto = new AImage("foto",this.bePersona.getImFotoPer());
            //ofertaServicio.grabarPersona(this.getBePersona());
            Messagebox.show("La fotografía fue grabada exitosamente.");
        }
        else
            Messagebox.show("El arhivo seleccionado no es una imagen.\n Selecione un archivo con extensión .jpg, png o gif.");
        
        
}
    
    @AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);        
        
        //wire event listener
//      Selectors.wireEventListeners(view, this);
    }
    public HojaDeVidaViewModel()
    {
        getDatoCurriculo();
        generarCatalogos();
        calcularEdad();
        if (!this.getBePersona().getEsPersona().equals("Activo"))
            Clients.showNotification("Recuerde que para que su hoja de vida sea tomada en cuenta\n debe completar al menos:\nDatos Personales\nEducación Formal\n y dos referencias personales:","info",null,"end_center",15000);
       // generarCombosIniciales();        
        
    }
    
    
    @Command
    @NotifyChange("edad")
    public void calcularEdad()
    {
       if (this.bePersona.getFeNacimientoPer()==null) return;
       Calendar fechaNacimiento = new GregorianCalendar();
       Calendar fechaHoy = new GregorianCalendar();
       int edad=0;      
       Date fechaNac = this.bePersona.getFeNacimientoPer();
       Date fechaActual = new Date();
       fechaNacimiento.setTime(fechaNac);
       fechaHoy.setTime(fechaActual);
       edad =(fechaHoy.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR));
       this.edad = edad + " años";  
    }
    @Command
    public void radioExtranjero()
    {
        
    }
    @Command
    public void mensaje()
    {
         Clients.showNotification("Recuerde anteponer el código de provincia al número de teléfono","info",null,"end_center",3000);
       
    }
    
   
    @Command
    @NotifyChange("bePersona")
    public void grabar()
    {
        if (!validarDatos()) return;
        ofertaServicio.grabarPersona(this.bePersona);
        Messagebox.show("Sus datos personales han sigo grabados correctamente.", "Atención",Messagebox.OK,Messagebox.INFORMATION );
        //ofertaServicio.grabarCurriculo(this.beCurriculo);
    }
    
    @Command
    public void abrirPdf()
    {
         final HashMap<String, byte[]> map = new HashMap<String, byte[]>();
        map.put("imagen", this.getBePersona().getImFotoPer());
         Window window = (Window)Executions.createComponents(
                "/celec/candidato/reporteHojaDeVida.zul", null, map);
        window.doModal();
    }
    private void getDatoCurriculo()
    {
        Session sess = Sessions.getCurrent();
	UserCredential cre = (UserCredential)sess.getAttribute(EnumSesion.userCredential.getNombre());
        setBePersona(ofertaServicio.getBePersona(cre.getCodigoPersona()));
        setBeCurriculo(ofertaServicio.getBeCurriculo(bePersona));        
    }
    private void generarCatalogos()
    {
        OfertaServicio ofertaServicio = new OfertaServicio();
        listaTiposIdentificacion = ofertaServicio.getCatalogo(TipoCatalogoEnum.TIPO_IDENTIFICACION.getCategoria());          
        listaGenero=ofertaServicio.getCatalogo(TipoCatalogoEnum.GENERO.getCategoria());
        setListaEstadoCivil(ofertaServicio.getCatalogo(TipoCatalogoEnum.ESTADO_CIVIL.getCategoria()));
        setListaPaises(ofertaServicio.getCatalogo(TipoCatalogoEnum.PAISES.getCategoria()));
        setListaLugarResidencia(ofertaServicio.getCatalogo(TipoCatalogoEnum.LUGAR_RESIDENCIA.getCategoria()));
        setListaTipoLicencia(ofertaServicio.getCatalogo(TipoCatalogoEnum.TIPO_LICENCIA.getCategoria()));
        setListaGrupoEtnico(ofertaServicio.getCatalogo(TipoCatalogoEnum.GRUPO_ETNICO.getCategoria()));
        setListaTipoIncapacidad(ofertaServicio.getCatalogo(TipoCatalogoEnum.TIPO_DISCAPACIDAD.getCategoria()));
        setListaNivelAcademico(ofertaServicio.getCatalogo(TipoCatalogoEnum.NIVEL_ESTUDIO.getCategoria()));
    }
    /**
     * @return the tipoIdentificacion
     */
    public BeCatalogo getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    /**
     * @param tipoIdentificacion the tipoIdentificacion to set
     */
    public void setTipoIdentificacion(BeCatalogo tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    /**
     * @return the listaTiposIdentificacion
     */
    public Set<BeCatalogo> getListaTiposIdentificacion() {
        return listaTiposIdentificacion;
    }

    /**
     * @param listaTiposIdentificacion the listaTiposIdentificacion to set
     */
    public void setListaTiposIdentificacion(Set<BeCatalogo> listaTiposIdentificacion) {
        this.listaTiposIdentificacion = listaTiposIdentificacion;
    }

    /**
     * @return the listaGenero
     */
    public Set<BeCatalogo> getListaGenero() {
        return listaGenero;
    }

    /**
     * @param listaGenero the listaGenero to set
     */
    public void setListaGenero(Set<BeCatalogo> listaGenero) {
        this.listaGenero = listaGenero;
    }

    /**
     * @return the listaEstadoCivil
     */
    public Set<BeCatalogo> getListaEstadoCivil() {
        return listaEstadoCivil;
    }

    /**
     * @param listaEstadoCivil the listaEstadoCivil to set
     */
    public void setListaEstadoCivil(Set<BeCatalogo> listaEstadoCivil) {
        this.listaEstadoCivil = listaEstadoCivil;
    }

    /**
     * @return the genero
     */
    public BeCatalogo getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(BeCatalogo genero) {
        this.genero = genero;
    }

    /**
     * @return the estadoCivil
     */
    public BeCatalogo getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * @param estadoCivil the estadoCivil to set
     */
    public void setEstadoCivil(BeCatalogo estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    /**
     * @return the listaPaises
     */
    public Set<BeCatalogo> getListaPaises() {
        return listaPaises;
    }

    /**
     * @param listaPaises the listaPaises to set
     */
    public void setListaPaises(Set<BeCatalogo> listaPaises) {
        this.listaPaises = listaPaises;
    }

    /**
     * @return the paises
     */
    public BeCatalogo getPaises() {
        return paises;
    }

    /**
     * @param paises the paises to set
     */
    public void setPaises(BeCatalogo paises) {
        this.paises = paises;
    }

    /**
     * @return the listaLugarResidencia
     */
    public Set<BeCatalogo> getListaLugarResidencia() {
        return listaLugarResidencia;
    }

    /**
     * @param listaLugarResidencia the listaLugarResidencia to set
     */
    public void setListaLugarResidencia(Set<BeCatalogo> listaLugarResidencia) {
        this.listaLugarResidencia = listaLugarResidencia;
    }

    /**
     * @return the lugarResidencia
     */
    public BeCatalogo getLugarResidencia() {
        return lugarResidencia;
    }

    /**
     * @param lugarResidencia the lugarResidencia to set
     */
    public void setLugarResidencia(BeCatalogo lugarResidencia) {
        this.lugarResidencia = lugarResidencia;
    }

    /**
     * @return the listaTipoLicencia
     */
    public Set<BeCatalogo> getListaTipoLicencia() {
        return listaTipoLicencia;
    }

    /**
     * @param listaTipoLicencia the listaTipoLicencia to set
     */
    public void setListaTipoLicencia(Set<BeCatalogo> listaTipoLicencia) {
        this.listaTipoLicencia = listaTipoLicencia;
    }

    /**
     * @return the tipoLicencia
     */
    public BeCatalogo getTipoLicencia() {
        return tipoLicencia;
    }

    /**
     * @param tipoLicencia the tipoLicencia to set
     */
    public void setTipoLicencia(BeCatalogo tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    /**
     * @return the listaGrupoEtnico
     */
    public Set<BeCatalogo> getListaGrupoEtnico() {
        return listaGrupoEtnico;
    }

    /**
     * @param listaGrupoEtnico the listaGrupoEtnico to set
     */
    public void setListaGrupoEtnico(Set<BeCatalogo> listaGrupoEtnico) {
        this.listaGrupoEtnico = listaGrupoEtnico;
    }

    /**
     * @return the grupoEtnico
     */
    public BeCatalogo getGrupoEtnico() {
        return grupoEtnico;
    }

    /**
     * @param grupoEtnico the grupoEtnico to set
     */
    public void setGrupoEtnico(BeCatalogo grupoEtnico) {
        this.grupoEtnico = grupoEtnico;
    }

    /**
     * @return the listaTipoIncapacidad
     */
    public Set<BeCatalogo> getListaTipoIncapacidad() {
        return listaTipoIncapacidad;
    }

    /**
     * @param listaTipoIncapacidad the listaTipoIncapacidad to set
     */
    public void setListaTipoIncapacidad(Set<BeCatalogo> listaTipoIncapacidad) {
        this.listaTipoIncapacidad = listaTipoIncapacidad;
    }

    /**
     * @return the tipoIncapacidd
     */
    public BeCatalogo getTipoIncapacidad() {
        return tipoIncapacidad;
    }

    /**
     * @param tipoIncapacidd the tipoIncapacidd to set
     */
    public void setTipoIncapacidad(BeCatalogo tipoIncapacidd) {
        this.tipoIncapacidad = tipoIncapacidd;
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

    /**
     * @return the edad
     */
    public String getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(String edad) {
        this.edad = edad;
    }

    /**
     * @return the listaNivelAcademico
     */
    public Set<BeCatalogo> getListaNivelAcademico() {
        return listaNivelAcademico;
    }

    /**
     * @param listaNivelAcademico the listaNivelAcademico to set
     */
    public void setListaNivelAcademico(Set<BeCatalogo> listaNivelAcademico) {
        this.listaNivelAcademico = listaNivelAcademico;
    }

    /**
     * @return the deshabilitarExtranjero
     */
    public boolean isDeshabilitarExtranjero() {
        return deshabilitarExtranjero;
    }

    /**
     * @param deshabilitarExtranjero the deshabilitarExtranjero to set
     */
    public void setDeshabilitarExtranjero(boolean deshabilitarExtranjero) {
        this.deshabilitarExtranjero = deshabilitarExtranjero;
    }

    /**
     * @return the foto
     */
    public AImage getFoto() throws IOException {   
       if (this.bePersona.getImFotoPer()==null) return null;
       foto = new AImage("foto",this.bePersona.getImFotoPer());
       return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(AImage foto) {
        this.foto = foto;
    }
    
}

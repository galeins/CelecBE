/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.celec.controlador.general.ViewModel;

import ec.gob.celec.persistencia.AdGrupoUsuario;
import ec.gob.celec.persistencia.AdUsuario;
import ec.gob.celec.persistencia.BeCatalogo;
import ec.gob.celec.persistencia.BePersona;
import ec.gob.celec.servicio.oferta.OfertaServicio;
import ec.gob.celec.util.GrupoUsuarioEnum;
import ec.gob.celec.util.TipoCatalogoEnum;
import java.io.IOException;
import java.util.Set;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.SelectorParam;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

/**
 *
 * @author Personal
 */
public class RegistrameViewModel {
    
    private AdUsuario adUsuario;
    private BePersona bePersona;
    private BeCatalogo tipoIdentificacion;
    private Set<BeCatalogo> listaTiposIdentificacion;
    private String claveRepetir;
    private boolean tieneErrores=true;
    private boolean tieneRepetidos=false;
    private String captcha;
    OfertaServicio ofertaServicio= new OfertaServicio();
    
   
    public RegistrameViewModel()
    {
        //Clients.showNotification("Bienvenido.\n Toda la infomación de esta página \n es pdebe ser ingresada.","info",null,"end_center",5000);
        adUsuario = new AdUsuario();
        adUsuario.setCoUsuario(Integer.MIN_VALUE);
        AdGrupoUsuario grupo = new AdGrupoUsuario();
        grupo.setCoGrupoUsuario(GrupoUsuarioEnum.CANDIDATO.getCodigo());
        adUsuario.setAdGrupoUsuario(grupo);        
        bePersona = new BePersona();
        generarCatalogos(); 
       
    }
    
    private void generarCatalogos()
    {
        OfertaServicio ofertaServicio = new OfertaServicio();
        listaTiposIdentificacion = ofertaServicio.getCatalogo(TipoCatalogoEnum.TIPO_IDENTIFICACION.getCategoria());          
    }
    /**
     * @return the adUsuario
     */
    public AdUsuario getAdUsuario() {
        return adUsuario;
    }

    /**
     * @param adUsuario the adUsuario to set
     */
    public void setAdUsuario(AdUsuario adUsuario) {
        this.adUsuario = adUsuario;
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
     * @return the tipoIdentificacion
     */
    public BeCatalogo getTipoIdentificacion() {
        return this.tipoIdentificacion;
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
     * @param listaTiposIdentificacion the listaTiposIdnewentificacion to set
     */
    public void setListaTiposIdentificacion(Set<BeCatalogo> listaTiposIdentificacion) {
        this.listaTiposIdentificacion = listaTiposIdentificacion;
    }
    
    @Command
    public void grabar(@SelectorParam("#ventanaRegistrame") Window ventana) throws IOException {
       // int respuesta = Messagebox.show("Se creará el usuario: " + this.getAdUsuario().getNbCuentaUsu() + " con correo electrónico: " + this.getBePersona().getDeEmailPer() + "\n Desa continuar","Atención",Messagebox.YES | Messagebox.NO,Messagebox.INFORMATION);
       // if (respuesta == Messagebox.YES)
       // {
            validarDatos();
            if (tieneErrores || tieneRepetidos)
            {
                Messagebox.show("La información ingresada no esta completa.","Atención",Messagebox.OK,Messagebox.EXCLAMATION);
                return;
            }
             bePersona.setBeCatalogoByCoTipoIdentificacionPer(tipoIdentificacion);  
             bePersona.setVaExtranjeroPer("NO");
             bePersona.setVaDiscapacidadPer("NO");
             bePersona.setVaDisponibilidadParaViajarPer("NO");
             bePersona.setVaPoseeLincenciaPer("NO");             
             new OfertaServicio().grabarUsuario(this.getAdUsuario(),this.getBePersona());
             Messagebox.show("El usuario ha sido creado con éxito. Por favor ingrese su nombre y clave para ingresar su hoja de vida al sistema.","Atención",Messagebox.OK,Messagebox.EXCLAMATION);
             ventana.detach();
       // } 
    }

    @Command
    public void buscarUsuario()
    {
        
        if (ofertaServicio.existeUsuario(this.adUsuario.getNbCuentaUsu()))
        {  
            this.tieneErrores=true;
            this.tieneRepetidos=true;
            Messagebox.show("El nombre de usuario " + this.adUsuario.getNbCuentaUsu() +" ya existe. Ingrese un nombre diferente","Atención",Messagebox.OK,Messagebox.ERROR);
            this.adUsuario.setNbCuentaUsu("");
        }
        else
            tieneRepetidos=false;
    }
     
    @Command
    public void buscarCorreo()
    {
        
        if (ofertaServicio.existeCorreo(this.bePersona.getDeEmailPer()))
        {  
            this.tieneErrores=true;
            this.tieneRepetidos=true;        
            Messagebox.show("El correo electrónico " + this.bePersona.getDeEmailPer() +" ya se encuentra registrado.\n Si posee un usuario y olvidó la clave utilice la opción: Olvidé mi clave.","Atención",Messagebox.OK,Messagebox.ERROR);
            this.bePersona.setDeEmailPer("");
        }
        else
            this.tieneRepetidos=false;
    }
    /**
     * @return the claveRepetir
     */
    public String getClaveRepetir() {
        return claveRepetir;
    }

    /**
     * @param claveRepetir the claveRepetir to set
     */
    public void setClaveRepetir(String claveRepetir) {
        if (!claveRepetir.equals(this.getAdUsuario().getDeContrasenaUsu()))
            Messagebox.show("Las claves ingresadas no coincide.\nPor favor vuelva a ingresar la clave", "Atención", Messagebox.OK, Messagebox.EXCLAMATION);        
        this.claveRepetir = claveRepetir;
    }

    /**
     * @return the captcha
     */
    public String getCaptcha() {
        return captcha;
    }

    /**
     * @param captcha the captcha to set
     */
    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public void validarDatos()
    {
        /*validar usuario*/
        if (this.getAdUsuario().getNbCuentaUsu()!=null && this.getAdUsuario().getDeContrasenaUsu()!=null &&
                this.getBePersona().getDeEmailPer()!=null
                && this.getBePersona().getDeDomicilioPer() != null && this.getBePersona().getNbPersona()!= null
                && this.getBePersona().getNuTelefonoPer()!=null 
                && this.getBePersona().getApPersona()!=null && this.claveRepetir !=null 
                && (!"Error".equals(this.captcha) && ! "".equals(this.captcha) && this.captcha !=null)
                && tipoIdentificacion.getCoCatalogo()>0)
            tieneErrores=false;
        else 
            tieneErrores=true;
    }

    
}

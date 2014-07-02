/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.celec.controlador.candidato;

import ec.gob.celec.persistencia.BePersona;
import ec.gob.celec.servicio.oferta.OfertaServicio;
import ec.gob.celec.util.MailerClass;
import java.rmi.RemoteException;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.SelectorParam;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

/**
 *
 * @author Personal
 */
public class RecuperarClaveViewModel {
    
    @Wire
    private Textbox textboxCorreoElectronico;
    private String correoElectronico;
    OfertaServicio ofertaServicio = new OfertaServicio();
    
    @Command
    public void recuperarClave(@SelectorParam("#ventanaOlvidoClave") Window ventana) throws RemoteException
    {
        MailerClass correo = new MailerClass();
        BePersona bePersona;
        bePersona = ofertaServicio.getPersonaByCorreo(textboxCorreoElectronico.getValue());
        if (bePersona !=null)
        {
           correo.sendMail(bePersona.getDeEmailPer(), "La clave de ingreso la bolsa de empleado de CELEC para el usuario " + bePersona.getAdUsuario().getNbCuentaUsu()+" es: " + bePersona.getAdUsuario().getDeContrasenaUsu());
           Messagebox.show("Su nueva clave ha sido enviado al correo electrónico indicado. Revise su correo","Atención",Messagebox.OK,Messagebox.INFORMATION);
           ventana.detach();
        } 
        else
            Messagebox.show("El correo electrónico ingresado no se encuentra registrado en el sistema.","Atención", Messagebox.OK,Messagebox.ERROR);
    }
    /**
     * @return the correoElectronico
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    
    @AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);        
        
        //wire event listener
//      Selectors.wireEventListeners(view, this);
    }

    /**
     * @param correoElectronico the correoElectronico to set
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    
    
}

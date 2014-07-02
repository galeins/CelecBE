/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.celec.controlador.general;

import ec.gob.celec.seguridad.AutentificacionCelec;
import ec.gob.celec.seguridad.UserCredential;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;
import ec.gob.celec.util.EnumSesion;
import ec.gob.celec.util.GrupoUsuarioEnum;
import java.util.HashMap;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;



public class LoginController extends SelectorComposer<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Wire
	Textbox account;
	@Wire
	Textbox password;
	@Wire
	Label message;
       
        
        public void LoginController()
        {
           
        }
	@Listen("onClick=#buttonEntrar; onOK=#loginWin")
	public void doLogin(){
                AutentificacionCelec servicioAuth = new AutentificacionCelec();
                if (servicioAuth.login(account.getValue(), password.getValue()))
                    {              
                        Session sess = Sessions.getCurrent();
                        UserCredential cre = (UserCredential)sess.getAttribute(EnumSesion.userCredential.getNombre());
                        if (cre.getCodigoPerfil().intValue()== GrupoUsuarioEnum.ASESOR.getCodigo())
                            Executions.sendRedirect("/celec/asesor/entornoAsesor.zul");
                        else
                            if (cre.getCodigoPerfil().intValue()== GrupoUsuarioEnum.CANDIDATO.getCodigo())
                                Executions.sendRedirect("/index.zul");
                    }
                    else
                {           
                    Messagebox.show("    Clave o usuario incorrecto. \n Si no posee un usuario seleccione la opción Registrarme.", "Atención", Messagebox.OK, Messagebox.INFORMATION);
                        
                }
                
            }
        @Listen("onClick = #linkRegistrarme")
        public void doRegistrarme()
        {
            Window window = (Window)Executions.createComponents(
                "/celec/candidato/registrame.zul", null, null);
        window.doModal();
        }
      
        @Listen("onClick= #linkOlvideContrasena")
        public void linkOlvideContrasena()
        {
            Window window = (Window)Executions.createComponents(
                "/celec/candidato/olvideMiClave.zul", null, null);
        window.doModal();
        }
       
                
@Override
    public void doAfterCompose(Component comp) throws Exception{
        super.doAfterCompose(comp);             
    }	
}

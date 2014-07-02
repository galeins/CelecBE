/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.celec.controlador.general;

import ec.gob.celec.seguridad.AutentificacionCelec;
import ec.gob.celec.seguridad.AutentificadorService;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;

public class LogoutController extends SelectorComposer<Component> {
     
    //services
    AutentificadorService authService = new AutentificacionCelec();
     
    @Listen("onClick=#logout")
    public void doLogout(){
        authService.logout();      
        Executions.sendRedirect("/");
    }
}
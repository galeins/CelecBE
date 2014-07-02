/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.celec.seguridad;

 import java.util.Map;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.util.Initiator;


public class Autentificador implements Initiator  {

	AutentificadorService authService = new AutentificacionCelec();
	
        @Override
	public void doInit(Page page, Map<String, Object> args) throws Exception {
		
		UserCredential cre = authService.getUserCredential();
		if(cre==null || cre.isAnonymous()){
			Executions.sendRedirect("/celec/general/login.zul");
		}
	}
}

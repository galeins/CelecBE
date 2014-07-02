/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.celec.seguridad;

import java.io.Serializable;

import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import ec.gob.celec.util.EnumSesion;
import ec.gob.celec.persistencia.AdUsuario;
import ec.gob.celec.persistencia.BePersona;
import ec.gob.celec.sercicio.seguridad.UsuarioServicio;

public class AutentificacionCelec implements AutentificadorService,Serializable{
    private static final long serialVersionUID = 1L;
    UsuarioServicio modelo= new UsuarioServicio();
    
	public UserCredential getUserCredential(){
		Session sess = Sessions.getCurrent();
		UserCredential cre = (UserCredential)sess.getAttribute(EnumSesion.userCredential.getNombre());
		if(cre==null){
			cre = new UserCredential();
			sess.setAttribute(EnumSesion.userCredential.getNombre(),cre);
		}
		return cre;
	}
	 

        /*
         * Cambiar el método en el ModeloUsuario para traer datos de los usuarios de hibernate
         */
        
	public boolean login(String nombreUsuario, String claveUsuario) 
        {
            AdUsuario dato = modelo.getUsuario(nombreUsuario, claveUsuario);
            if (dato == null )
	        return false;
            BePersona datoPersona = modelo.getPersona(dato.getCoUsuario());
	    Session sess = Sessions.getCurrent();
	    UserCredential cre = new UserCredential(dato.getNbCuentaUsu(),datoPersona.getNbPersona().concat(" ").concat(datoPersona.getApPersona()),dato.getCoUsuario(),datoPersona.getCoPersona(),dato.getAdGrupoUsuario().getCoGrupoUsuario(),dato);
	    sess.setAttribute(EnumSesion.userCredential.getNombre(),cre);
	    return true;
	}


	public void logout() {
	   Session sess = Sessions.getCurrent();
           sess.removeAttribute(EnumSesion.userCredential.getNombre());
	}
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.celec.sercicio.seguridad;

import ec.gob.celec.persistencia.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import ec.gob.celec.persistencia.AdUsuario;
import ec.gob.celec.persistencia.BePersona;
import java.util.Iterator;
import java.util.Map;
import org.hibernate.Criteria;




/**
 *
 * @author Personal
 */
public class UsuarioServicio {
 
    public AdUsuario getUsuario(String nombreUsuario,String claveUsuario)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();       
        List<AdUsuario> usuario =   session.createCriteria(AdUsuario.class , "c")                       
               .add(Expression.eq("c.nbCuentaUsu",nombreUsuario))
               .add(Expression.eq("c.deContrasenaUsu",claveUsuario))           
               .list();
        session.close();
           if (usuario.iterator().hasNext())
                return usuario.iterator().next();
           else
               return null;
    }
    
    public BePersona getPersona(Integer codigoUsuario)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();       
        List<BePersona> persona =   session.createCriteria(BePersona.class , "c")    
                .createAlias("adUsuario", "a")
               .add(Expression.eq("a.coUsuario",codigoUsuario))
               .list();
        session.close();
        if (persona.iterator().hasNext())
            return persona.iterator().next();
        return null;
    }
    
    
}

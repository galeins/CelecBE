/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.celec.servicio.proceeso;

import ec.gob.celec.persistencia.BeOfertaEmpleo;
import ec.gob.celec.persistencia.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

/**
 *
 * @author Personal
 */
public class ProcesosSeleccionServicio {
    
     public List<BeOfertaEmpleo> getProcesosSeleccion(Integer codigoCategoria)
    {
         Session session = HibernateUtil.getSessionFactory().openSession();          
         List<BeOfertaEmpleo> datos;
        
            datos=session.createCriteria(BeOfertaEmpleo.class , "c") 
               // .add(Expression.eq("c.coCategoriaOfertaOfe",codigoCategoria)) 
                .addOrder(Order.desc("coOfertaEmpleo")) 
                .list();          
        
          session.close();
          return datos;
      
    }
    
    
}

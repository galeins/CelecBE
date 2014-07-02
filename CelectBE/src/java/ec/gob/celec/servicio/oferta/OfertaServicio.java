/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.celec.servicio.oferta;

import ec.gob.celec.persistencia.AdUsuario;
import ec.gob.celec.persistencia.BeCalificacionEducacion;
import ec.gob.celec.persistencia.BeCapacitacion;
import ec.gob.celec.persistencia.BeCatalogo;
import ec.gob.celec.persistencia.BeCategPeso;
import ec.gob.celec.persistencia.BeConocimiento;
import ec.gob.celec.persistencia.BeCurriculo;
import ec.gob.celec.persistencia.BeExpLaboral;
import ec.gob.celec.persistencia.BeFormAcademica;
import ec.gob.celec.persistencia.BeIdioma;
import ec.gob.celec.persistencia.BeOfertaEmpleo;
import ec.gob.celec.persistencia.BePersona;
import ec.gob.celec.persistencia.BePesoOferta;
import ec.gob.celec.persistencia.BeRefePersonal;
import ec.gob.celec.persistencia.BeSelecionCvOfer;
import ec.gob.celec.persistencia.HibernateUtil;
import ec.gob.celec.util.TipoCatalogoEnum;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.zkoss.zul.ListModelList;


/**
 *
 * @author Personal
 */
public class OfertaServicio {
    
    public List<BeCalificacionEducacion> getBeCalificacionNivel(Integer codigoOferta,String tipoCategoria)
    {
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        Query query=session.createQuery("from BeCalificacionEducacion a where beOfertaEmpleo.coOfertaEmpleo=:codigoOferta and a.vaTipoOferta=:tipoCategoria");
        query.setParameter("codigoOferta", codigoOferta);
        query.setParameter("tipoCategoria", tipoCategoria);
        List<BeCalificacionEducacion> datos = query.list();
        session.close(); 
        return datos;
    }
    
    public BePersona getBePersona(int codigoPersona)
    {
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        List<BePersona> datos = session.createCriteria(BePersona.class,"c")
                .add(Expression.eq("c.coPersona",codigoPersona)).list();
        session.close();
        if (datos.iterator().hasNext())
            return datos.iterator().next();        
        return null;
    }
    public BeCurriculo getBeCurriculo(BePersona bePersona)
    {
        Set<BeCurriculo> curriculo;  
        curriculo = bePersona.getBeCurriculos();
        if (curriculo.iterator().hasNext())
            return curriculo.iterator().next();       
        return null;
    }
    public boolean existeUsuario(String datoUsuario)
    {
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        List<AdUsuario> datos = session.createCriteria(AdUsuario.class,"a")
                .add(Expression.eq("a.nbCuentaUsu", datoUsuario)).list();
        session.close();
        return (datos.size()>0);
    }
    
    public BePersona getPersonaByCorreo(String correoUsuario)
    {
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        List<BePersona> datos = session.createCriteria(BePersona.class,"a")
                .add(Expression.eq("a.deEmailPer", correoUsuario)).list();
        session.close();
        if (datos.iterator().hasNext())
            return datos.iterator().next();
        return null;
        
    }
    public boolean existeCorreo(String datoCorreo)
    {
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        List<AdUsuario> datos = session.createCriteria(BePersona.class,"a")
                .add(Expression.eq("a.deEmailPer", datoCorreo)).list();
        session.close();
        return (datos.size()>0);
    }
    
    public Set<BeCatalogo> getCatalogo(String tipoCatalogo)
    {
          Session session = HibernateUtil.getSessionFactory().openSession(); 
          List<BeCatalogo> datos=session.createCriteria(BeCatalogo.class , "c") 
                .add(Expression.eq("c.nbCatalogo",tipoCatalogo))
                  .add(Expression.eq("c.esCatalogo","Activo"))
                 .addOrder(Order.asc("nbCatalogo"))
                 .list();
          session.close();
          return datos.iterator().next().getBeCatalogos();       
        
    }
    public BeCatalogo getCatalogo(Integer codigoCatalogo)
    {
        Session session = HibernateUtil.getSessionFactory().openSession(); 
          List<BeCatalogo> datos=session.createCriteria(BeCatalogo.class , "c") 
                .add(Expression.eq("c.coCatalogo",codigoCatalogo))                 
                 .list();
          session.close();
          if (datos.iterator().hasNext())
              return datos.iterator().next();
          return null;
          
    }
     public BeOfertaEmpleo getBeOfertaByCodigo(Integer codigoOferta)
    {
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        List<BeOfertaEmpleo> datos=session.createCriteria(BeOfertaEmpleo.class , "c") 
                .add(Expression.eq("c.coOfertaEmpleo",codigoOferta))                 
                 .list();
          session.close();
          if (datos.iterator().hasNext())
              return datos.iterator().next();
          return null;
          
    }
     
    /*
     * Método para extraer la oferta por usuario. 
     * Verifica si el candidato ya aplicó a la oferta
     */
    public BeSelecionCvOfer getBeOfertaUsuario(Integer codigoOferta,Integer codigoUsuario)
    {
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        Query query=session.createQuery("from BeSelecionCvOfer a where a.beCurriculo.bePersona.adUsuario.coUsuario=:codigoUsuario and a.beOfertaEmpleo.coOfertaEmpleo =:codigoOferta");
        query.setParameter("codigoUsuario", codigoUsuario);
        query.setParameter("codigoOferta", codigoOferta);
        List<BeSelecionCvOfer> datos = query.list();
        session.close(); 
        if (datos.iterator().hasNext())
              return datos.iterator().next();
          return null;          
    }
    
    /*
     * Método para extraer las ofertas que tiene aplicado el usuario
     */
    public List<BeSelecionCvOfer> getBeOfertasUsuario(Integer codigoUsuario)
    {
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        Query query=session.createQuery("from BeSelecionCvOfer a where a.beCurriculo.bePersona.adUsuario.coUsuario=:codigoUsuario");
        query.setParameter("codigoUsuario", codigoUsuario);      
        List<BeSelecionCvOfer> datos = query.list();
        session.close(); 
        return datos;          
    }

    public void insertarSeleccionOferta(BeSelecionCvOfer beSeleccionCvOfer)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();        
        session.getTransaction().begin();
        session.saveOrUpdate(beSeleccionCvOfer);
        session.getTransaction().commit();
        session.close();  
    }
    
    public List<BeOfertaEmpleo> getOfertas(Integer codigoCategoria)
    {
         Session session = HibernateUtil.getSessionFactory().openSession();          
         List<BeOfertaEmpleo> datos;
         if (codigoCategoria!=-1)
         {
             Query query=session.createQuery("from BeOfertaEmpleo c where c.beCatalogoByCoAreaEstudio.coCatalogo=:codigoCategoria" +
                     " and c.esOfertaEmpleo = 'Publicado' and  :fechaHoy between c.feInivigenOferemp and c.feFinvigenOferemp" );
             query.setParameter("codigoCategoria", codigoCategoria);
             query.setParameter("fechaHoy",new Date());
             datos = query.list();     
         }         
         else
         {
              Query query=session.createQuery("from BeOfertaEmpleo c where " +
                     "  c.esOfertaEmpleo = 'Publicado' and  :fechaHoy between c.feInivigenOferemp and c.feFinvigenOferemp" );
              query.setParameter("fechaHoy",new Date());
               datos = query.list();   
         }         
          session.close();
          return datos;
      
    }
    
    /*
     * Método de regla de negocio para cambiar estado de hoja de vida
     */
    public void cambiarEstadoHojaDeVida(BePersona datoPersona,BeCurriculo datoCurriculo)
    {
        boolean datoFormacion=false;
        boolean datoReferencias=false;
        boolean datoReferenciaPersonal = true;
        /*revisar datos personales*/
        if (datoPersona.getBeCatalogoByCoNivelEstudios().getCoCatalogo()!=null &&
            datoPersona.getBeCatalogoByCoEstadoCivilPer().getCoCatalogo()!=null &&
            datoPersona.getBeCatalogoByCoGeneroPer().getCoCatalogo()!=null &&
                datoPersona.getBeCatalogoByCoGrupoEtnicoPer().getCoCatalogo()!=null &&
                datoPersona.getBeCatalogoByCoProvinciaPer().getCoCatalogo()!=null &&
                datoPersona.getBeCatalogoByCoTipoIdentificacionPer()!=null &&
                datoPersona.getDeDomicilioPer()!=null &&
                datoPersona.getDeEmailPer()!=null &&
                datoPersona.getNuIdentificaciobPer()!=null &&
                datoPersona.getNuTelefonoPer()!=null )
        {
            
            /*Revisar formación academica*/
            Iterator<BeFormAcademica> iterator = datoCurriculo.getBeFormAcademicas().iterator();
            BeFormAcademica beFormAcademica;
            while (iterator.hasNext())            
            {
                beFormAcademica=iterator.next();
                datoFormacion = (beFormAcademica.getBeCatalogoByCoAreEstudio().getCoCatalogo()!=null &&
                        beFormAcademica.getNbInstitucion()!=null &&
                        beFormAcademica.getNbEstudioRealizado()!=null &&                        
                        beFormAcademica.getNuAnioGrado()!=null);
                if (!datoFormacion ) break;
                
            }
            /*revisión de referencias personales*/
            Iterator<BeRefePersonal> iteratorRefePersonal = datoCurriculo.getBeRefePersonals().iterator();
            BeRefePersonal beRefePersonal;
            int contadorReferencias=0;
            while (iteratorRefePersonal.hasNext())
            {
                beRefePersonal = iteratorRefePersonal.next();
                datoReferencias=(beRefePersonal.getNbCargoRefePersonal()!=null &&
                        beRefePersonal.getNbRefePersonal()!=null &&
                        beRefePersonal.getNuTelefonoRefePersonal()!=null &&
                        beRefePersonal.getVaTipoRelacion()!=null);
                contadorReferencias++;
            }
            if (contadorReferencias<2)
                datoReferencias=false;
            else
                datoReferencias=true;
        }
        else
            datoReferenciaPersonal=false;
        datoPersona.setEsPersona((datoReferenciaPersonal && datoReferencias && datoFormacion)?"Activo":"Inactivo");
        actualizarEstado(datoPersona);
        
    }
    public void actualizarEstado(BePersona bePersona)
    {
         Session session = HibernateUtil.getSessionFactory().openSession(); 
         session.getTransaction().begin();
         session.update(bePersona);
         session.getTransaction().commit();
         session.close();
        
    }
    public void grabarUsuario(AdUsuario datoUsuario,BePersona datoPersona)
    {
        try
        {
         BeCurriculo beCurriculo = new BeCurriculo();         
         Session session = HibernateUtil.getSessionFactory().openSession(); 
         datoUsuario.setFeRegistroUsu(new Date());
         datoUsuario.setEsUsuario("Activo");
         datoUsuario.setEsAsesorParaDcp("NO");
         session.getTransaction().begin();
         session.save(datoUsuario);
         datoPersona.setCoPersona(Integer.MIN_VALUE); 
         datoPersona.setEsPersona("Inactivo");
         datoPersona.setAdUsuario(datoUsuario);
         datoPersona.setFeModifica(new Date());
         session.save(datoPersona);
         beCurriculo.setCoCurriculo(Integer.MIN_VALUE);
         beCurriculo.setBePersona(datoPersona);
         beCurriculo.setVaNombreCv(datoPersona.getNbPersona());
         beCurriculo.setVaApellidoCv(datoPersona.getApPersona());
         beCurriculo.setEsCurriculo("Inactivo");
         session.save(beCurriculo);
         session.getTransaction().commit();
         session.close();
        }
        catch(Exception ex)
        {
        System.out.println(ex.toString());
        }
        
    }
   
  
    
    public Set<BeFormAcademica> getFormacionAcademica(BePersona bePersona)
    {
        Set<BeCurriculo> curriculo;  
        curriculo = bePersona.getBeCurriculos();
        if (curriculo.iterator().hasNext())
            return curriculo.iterator().next().getBeFormAcademicas();            
        return null;
    }
    public Set<BeCapacitacion> getCapacitacion(BePersona bePersona)
    {
        Set<BeCurriculo> curriculo;  
        curriculo = bePersona.getBeCurriculos();
        if (curriculo.iterator().hasNext())
            return curriculo.iterator().next().getBeCapacitacions();            
        return null;
    }
      public Set<BeExpLaboral> getExperiencia(BePersona bePersona)
    {
        Set<BeCurriculo> curriculo;  
        curriculo = bePersona.getBeCurriculos();
        if (curriculo.iterator().hasNext())
            return curriculo.iterator().next().getBeExpLaborals();            
        return null;
    }
    public Set<BeIdioma> getIdioma(BePersona bePersona)
    {
        Set<BeCurriculo> curriculo;  
        curriculo = bePersona.getBeCurriculos();
        if (curriculo.iterator().hasNext())
            return curriculo.iterator().next().getBeIdiomas();            
        return null;
    }
      public Set<BeRefePersonal> getReferencia(BePersona bePersona)
    {
        Set<BeCurriculo> curriculo;  
        curriculo = bePersona.getBeCurriculos();
        if (curriculo.iterator().hasNext())
            return curriculo.iterator().next().getBeRefePersonals();            
        return null;
    }
    public void eliminarCapacitacion(BeCapacitacion beCapacitacion)
    {
            Session session = HibernateUtil.getSessionFactory().openSession(); 
            session.getTransaction().begin();
            session.delete(beCapacitacion);
            session.getTransaction().commit();
            session.close();
            
    }
     public void eliminarFormacionAcademica(BeFormAcademica beFormacionAcademica)
    {
            Session session = HibernateUtil.getSessionFactory().openSession(); 
            session.getTransaction().begin();
            session.delete(beFormacionAcademica);
            session.getTransaction().commit();
            session.close();
            
    }
      public void eliminarIdioma(BeIdioma beIdioma)
    {
            Session session = HibernateUtil.getSessionFactory().openSession(); 
            session.getTransaction().begin();
            session.delete(beIdioma);
            session.getTransaction().commit();
            session.close();
            
    }
          public void eliminarReferencia(BeRefePersonal beRefePersonal)
    {
            Session session = HibernateUtil.getSessionFactory().openSession(); 
            session.getTransaction().begin();
            session.delete(beRefePersonal);
            session.getTransaction().commit();
            session.close();
            
    }
    
      public void eliminarConocimiento(BeConocimiento beConocimiento)
    {
            Session session = HibernateUtil.getSessionFactory().openSession(); 
            session.getTransaction().begin();
            session.delete(beConocimiento);
            session.getTransaction().commit();
            session.close();
            
    }
        public void eliminarExperienciaLaboral(BeExpLaboral beExpLaboral)
    {
            Session session = HibernateUtil.getSessionFactory().openSession(); 
            session.getTransaction().begin();
            session.delete(beExpLaboral);
            session.getTransaction().commit();
            session.close();
            
    }
  
    
     public Set<BeConocimiento> getConocimientosEscenciales(BePersona bePersona)
    {
        Set<BeCurriculo> curriculo;  
        curriculo = bePersona.getBeCurriculos();
        if (curriculo.iterator().hasNext())
            return curriculo.iterator().next().getBeConocimientos();
        return null;
    }
    public void grabarPersona(BePersona datoPersona)
    {
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        try
        {
        
         session.getTransaction().begin();
         session.update(datoPersona);
         session.getTransaction().commit();
         session.close();  
        }
        catch(Exception e)        {
            session.close();
            System.out.println(e.toString());
        }
        this.cambiarEstadoHojaDeVida(datoPersona,this.getBeCurriculo(datoPersona));
    }
    
    public void grabarAreaPonderacion(List<BePesoOferta> datosPesoOferta)
    {
         Iterator<BePesoOferta> iterator= datosPesoOferta.iterator();
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        session.getTransaction().begin();
       BePesoOferta bePesoOferta;
        while (iterator.hasNext())
        {
            bePesoOferta =iterator.next();
            bePesoOferta.setBeEvaluacionCvs(null);
            session.update(bePesoOferta);            
        }
        session.getTransaction().commit();
        session.close();
    }
    public void grabarMeritos(List<BeCalificacionEducacion> datosCalificacion)
    {
        
      Iterator<BeCalificacionEducacion> iterator= datosCalificacion.iterator();
      Session session = HibernateUtil.getSessionFactory().openSession(); 
      session.getTransaction().begin();
      BeCalificacionEducacion beCalificacionEducacion;
      while (iterator.hasNext())
      {
          beCalificacionEducacion = iterator.next();
          session.update(beCalificacionEducacion);          
      }
      session.getTransaction().commit();
      session.close();
        
    }
    
    public void grabarFormacionAcademica(ListModelList<BeFormAcademica> datosFormacion,BeCurriculo beCurriculo)
    {
         Session session = HibernateUtil.getSessionFactory().openSession(); 
         session.getTransaction().begin();
         Iterator iteratorFormacion= datosFormacion.iterator();
         BeFormAcademica beFormAcademica;
         while (iteratorFormacion.hasNext())
         {
             beFormAcademica= (BeFormAcademica) iteratorFormacion.next();
             if (beFormAcademica.getBeCurriculo()==null)
                 beFormAcademica.setBeCurriculo(beCurriculo);
            session.saveOrUpdate(beFormAcademica);
         }
         session.getTransaction().commit();
         session.close();
         this.cambiarEstadoHojaDeVida(beCurriculo.getBePersona(),beCurriculo);
    }
    
    public void grabarCapacitacion(ListModelList<BeCapacitacion> datosCapacitacion,BeCurriculo beCurriculo)
    {
         Session session = HibernateUtil.getSessionFactory().openSession(); 
         session.getTransaction().begin();
         Iterator iterator= datosCapacitacion.iterator();
         BeCapacitacion beCapacitacion;
         while (iterator.hasNext())
         {
            beCapacitacion = (BeCapacitacion) iterator.next();
            beCapacitacion.setBeCurriculo(beCurriculo);
            session.saveOrUpdate(beCapacitacion);            
         }
         session.getTransaction().commit();
         session.close();
    }
    
    public void grabarExperienciaLaboral(ListModelList<BeExpLaboral> datos,BeCurriculo beCurriculo)
    {
         Session session = HibernateUtil.getSessionFactory().openSession(); 
         session.getTransaction().begin();
         BeExpLaboral beExpLaboral;
         Iterator iterator= datos.iterator();
         while (iterator.hasNext())
         {
             beExpLaboral=(BeExpLaboral) iterator.next();
             beExpLaboral.setBeCurriculo(beCurriculo);
             session.saveOrUpdate(beExpLaboral);
         }
         session.getTransaction().commit();
         session.close();
    }
    
    public void grabarIdioma(ListModelList<BeIdioma> datos,BeCurriculo beCurriculo)
    {
         Session session = HibernateUtil.getSessionFactory().openSession(); 
         session.getTransaction().begin();
         Iterator iterator= datos.iterator();
         BeIdioma beIdioma;
         while (iterator.hasNext())
         {
             beIdioma=(BeIdioma) iterator.next();
             if (beIdioma.getBeCurriculo()==null)             
                 beIdioma.setBeCurriculo(beCurriculo);
//             if (beIdioma.getCoIdioma()==null)
//                 beIdioma.setCoIdioma(Integer.MAX_VALUE);
            session.saveOrUpdate(beIdioma);
         }
         session.getTransaction().commit();
         session.close();
    }
    
     public void grabarReferencias(ListModelList<BeRefePersonal> datos,BeCurriculo beCurriculo)
    {
         Session session = HibernateUtil.getSessionFactory().openSession(); 
         session.getTransaction().begin();
         Iterator iterator= datos.iterator();
         BeRefePersonal beRefePersonal;
         while (iterator.hasNext())
         {
             beRefePersonal=(BeRefePersonal) iterator.next();
             if (beRefePersonal.getBeCurriculo()==null)             
                 beRefePersonal.setBeCurriculo(beCurriculo);
//             if (beIdioma.getCoIdioma()==null)
//                 beIdioma.setCoIdioma(Integer.MAX_VALUE);
            session.saveOrUpdate(beRefePersonal);
         }
         session.getTransaction().commit();
         session.close();
         this.cambiarEstadoHojaDeVida(beCurriculo.getBePersona(),beCurriculo);
    }
    
    public void grabarConocimientosEscenciales(Set<BeConocimiento> datosConocimiento,BeCurriculo beCurriculo)
    {
         Session session = HibernateUtil.getSessionFactory().openSession(); 
         session.getTransaction().begin();
         Iterator iterator= datosConocimiento.iterator();
         BeConocimiento beConocimiento;
         while (iterator.hasNext())
         {
            beConocimiento= (BeConocimiento) iterator.next();
            beConocimiento.setBeCurriculo(beCurriculo);            
            session.saveOrUpdate(beConocimiento);
         }
         session.getTransaction().commit();
         session.close();
    }
    public void grabarCurriculo(BeCurriculo datoCurriculo)
    {
         Session session = HibernateUtil.getSessionFactory().openSession(); 
         session.getTransaction().begin();
         session.update(datoCurriculo);
         session.getTransaction().commit();
         session.close();  
    }
    
    public List<BeCategPeso> getBeCatePeso()
    {
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        session.getTransaction().begin();
        List<BeCategPeso>   datos=session.createCriteria(BeCategPeso.class , "c")                                
                .addOrder(Order.asc("nbCategPeso"))
                .list();          
        return datos;
        
    }
    
    public List<BePesoOferta> getBePesoOferta(int codigoOferta)
    {
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        session.getTransaction().begin();
         List<BePesoOferta> datos=session.createCriteria(BePesoOferta.class , "c") 
                 .add(Expression.eq("c.beOfertaEmpleo.coOfertaEmpleo", codigoOferta))
                 .list();
         return datos;        
    }
    
    /*
     * Método que genera las calificaciones para calificación de la oferta
     */
    public void generarCalificacionNivelEducacion(BeOfertaEmpleo datoOferta)
    {
        Set<BeCatalogo> ListbeCatalogo = this.getCatalogo(TipoCatalogoEnum.NIVEL_ESTUDIO.getCategoria());
        Iterator iterator = ListbeCatalogo.iterator();
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        BeCalificacionEducacion beCalificacion;
        session.getTransaction().begin();
        while (iterator.hasNext())
        {
            beCalificacion= new BeCalificacionEducacion();
            beCalificacion.setBeCatalogo((BeCatalogo) iterator.next());
            beCalificacion.setBeOfertaEmpleo(datoOferta);
            beCalificacion.setVaCalificacion(0);
            beCalificacion.setVaTipoOferta(TipoCatalogoEnum.NIVEL_ESTUDIO.getCategoria());
            session.save(beCalificacion);            
        }
        session.getTransaction().commit();
        session.close();  
    }
    
     public void generarMerito(BeOfertaEmpleo datoOferta)
    {
        Set<BeCatalogo> ListbeCatalogo = this.getCatalogo(TipoCatalogoEnum.TIPO_MERITO.getCategoria());
        Iterator iterator = ListbeCatalogo.iterator();
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        BeCalificacionEducacion beCalificacion;
        session.getTransaction().begin();
        while (iterator.hasNext())
        {
            beCalificacion= new BeCalificacionEducacion();
            beCalificacion.setBeCatalogo((BeCatalogo) iterator.next());
            beCalificacion.setBeOfertaEmpleo(datoOferta);
            beCalificacion.setVaCalificacion(0);
            beCalificacion.setVaTipoOferta(TipoCatalogoEnum.TIPO_MERITO.getCategoria());
            session.save(beCalificacion);            
        }
        session.getTransaction().commit();
        session.close();  
    }
     
    public void generarPrueba(BeOfertaEmpleo datoOferta)
    {
        Set<BeCatalogo> ListbeCatalogo = this.getCatalogo(TipoCatalogoEnum.TIPO_PRUEBA.getCategoria());
        Iterator iterator = ListbeCatalogo.iterator();
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        BeCalificacionEducacion beCalificacion;
        session.getTransaction().begin();
        while (iterator.hasNext())
        {
            beCalificacion= new BeCalificacionEducacion();
            beCalificacion.setBeCatalogo((BeCatalogo) iterator.next());
            beCalificacion.setBeOfertaEmpleo(datoOferta);
            beCalificacion.setVaCalificacion(0);
            beCalificacion.setVaTipoOferta(TipoCatalogoEnum.TIPO_PRUEBA.getCategoria());
            session.save(beCalificacion);            
        }
        session.getTransaction().commit();
        session.close();  
    }
    
    public void generarEntrevista(BeOfertaEmpleo datoOferta)
    {
        Set<BeCatalogo> ListbeCatalogo = this.getCatalogo(TipoCatalogoEnum.TIPO_ENTREVISTA.getCategoria());
        Iterator iterator = ListbeCatalogo.iterator();
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        BeCalificacionEducacion beCalificacion;
        session.getTransaction().begin();
        while (iterator.hasNext())
        {
            beCalificacion= new BeCalificacionEducacion();
            beCalificacion.setBeCatalogo((BeCatalogo) iterator.next());
            beCalificacion.setBeOfertaEmpleo(datoOferta);
            beCalificacion.setVaCalificacion(0);
            beCalificacion.setVaTipoOferta(TipoCatalogoEnum.TIPO_ENTREVISTA.getCategoria());
            session.save(beCalificacion);            
        }
        session.getTransaction().commit();
        session.close();  
    }
    /*
     * Método que se genera cuando se crea una oferta de empleo.
     * Este método genera las areas de ponderación existentes en la tabla becategPeso
     */
    public void generarPonderacion(BeOfertaEmpleo datoOferta)
    {
        BePesoOferta bePesoOferta;
        BeCategPeso beCategoriaPeso;
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        session.getTransaction().begin();
        List<BeCategPeso> datosAreasPonderacion = this.getBeCatePeso();
        Iterator iteratorAreasPonderacion = datosAreasPonderacion.iterator();
        while (iteratorAreasPonderacion.hasNext())
        {
            beCategoriaPeso = (BeCategPeso) iteratorAreasPonderacion.next();
            bePesoOferta = new BePesoOferta();
            bePesoOferta.setBeOfertaEmpleo(datoOferta);
            bePesoOferta.setVaPesoOferta(BigDecimal.ZERO);
            bePesoOferta.setBeCategPeso(beCategoriaPeso);
            session.save(bePesoOferta);
        }       
        session.getTransaction().commit();
        session.close();  
    }
     public void grabarOferta(BeOfertaEmpleo datoOferta)
    {
         Session session = HibernateUtil.getSessionFactory().openSession(); 
         session.getTransaction().begin();
         session.saveOrUpdate(datoOferta);
         session.getTransaction().commit();
         session.close();  
    }
     
     public Integer getTotalFilasOfertaEmpleo()
     {
          Integer totalFilas;
          Session session = HibernateUtil.getSessionFactory().openSession(); 
          Criteria criteria = session.createCriteria(BeOfertaEmpleo.class); 
          criteria.setProjection(Projections.rowCount());
          totalFilas=((Integer)criteria.list().get(0)).intValue();
          session.close();
          return totalFilas+1;
          
     }
}

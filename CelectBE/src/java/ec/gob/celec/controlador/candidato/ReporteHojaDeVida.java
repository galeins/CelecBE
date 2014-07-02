/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.celec.controlador.candidato;

import ec.gob.celec.persistencia.BeCatalogo;
import ec.gob.celec.persistencia.HibernateUtil;
import ec.gob.celec.seguridad.UserCredential;
import ec.gob.celec.servicio.oferta.OfertaServicio;
import ec.gob.celec.util.EnumSesion;
import ec.gob.celec.util.TipoCatalogoEnum;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.query.JRHibernateQueryExecuterFactory;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Iframe;

/**
 *
 * @author Personal
 */
public class ReporteHojaDeVida{
    @Wire("#ifrreport")
    Iframe ifrreport;
    InputStream imgInputStream; //= this.getClass().getResourceAsStream("header.png");
    public String directorioReportes =getDirectorioReportes();
    
    
    public String getDirectorioReportes()
    {
        OfertaServicio ofertaServicio = new OfertaServicio();
        Set<BeCatalogo> catalogo = (Set<BeCatalogo>) ofertaServicio.getCatalogo(TipoCatalogoEnum.PATH_REPORTES.getCategoria());
        if (catalogo.iterator().hasNext())
            return catalogo.iterator().next().getNbCatalogo();
        return null;
    }
    public void generarReporte() throws FileNotFoundException, JRException, NamingException, SQLException
    {
        FileInputStream is = null;
        Execution exec = Executions.getCurrent();
        
        is = new FileInputStream(directorioReportes.concat("DatosPersonales.jasper"));
        Session sess = Sessions.getCurrent();
	UserCredential cre = (UserCredential)sess.getAttribute(EnumSesion.userCredential.getNombre());
        org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession(); 
        Map params = new HashMap();
        
        params.put("P_CODIGO_USUARIO", cre.getCodigo());
        params.put("SUBREPORT_DIR",directorioReportes);
        params.put("P_FOTO",imgInputStream);
        params.put(JRHibernateQueryExecuterFactory.PARAMETER_HIBERNATE_SESSION, session);
        InitialContext initialContext = new InitialContext();
        DataSource dataSource = (DataSource)initialContext.lookup("java:comp/env/MySQLDS");
        byte[] buf = JasperRunManager.runReportToPdf(is, params,dataSource.getConnection());
        InputStream mediais = new ByteArrayInputStream(buf);
        AMedia amedia = new AMedia(cre.getAccount().concat(".pdf"),"pdf", "application/pdf", mediais);
        amedia.getStreamData(); 
        ifrreport.setContent(amedia);
    }
    
    @AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view,@ExecutionArgParam("imagen") byte[] imagenPersona) throws FileNotFoundException, IOException
    {
        Selectors.wireComponents(view, this, false);
        try {
            imgInputStream = new ByteArrayInputStream(imagenPersona);            
            generarReporte();
        } catch (JRException ex) {
            Logger.getLogger(ReporteHojaDeVida.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(ReporteHojaDeVida.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReporteHojaDeVida.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
   
}

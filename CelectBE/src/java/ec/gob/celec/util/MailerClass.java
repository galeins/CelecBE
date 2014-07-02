/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.celec.util;


import ec.gob.celec.persistencia.BeCatalogo;
import ec.gob.celec.servicio.oferta.OfertaServicio;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;
import java.util.Set;


import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.annotation.Resource;
import javax.mail.Session;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMultipart;
import javax.mail.BodyPart;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;

//import ec.labalergia.apps.modulos.recursos.MensajesNegocio;

/**
 * Clase que permite el envio de e-mails utilizando mail-service de Jboss 7.1
 * 
 * 
 */
public class MailerClass {

	
	//private static Session mailSession;
        OfertaServicio ofertaServicio = new OfertaServicio();

        public String getConfiguracionCorreo(String categoria)
        {
           Set<BeCatalogo> dato= ofertaServicio.getCatalogo(categoria);
           if (dato.iterator().hasNext())
               return dato.iterator().next().getNbCatalogo();
            return null;
        }
                
                
	public boolean sendMail(String address, String mensaje)
			throws java.rmi.RemoteException {

		try {

			/*
			 * String asunto = "Grupo K... Solicitud Credenciales"; String host
			 * = "200.105.225.2"; String port = "25"; String from =
			 * "ltumipamba@ksgroup.com.ec"; String protocol="smtp";
			 */
			String asunto = getConfiguracionCorreo(TipoCatalogoEnum.ASUNTO_CORREO.getCategoria());
			String host = getConfiguracionCorreo(TipoCatalogoEnum.HOST_CORREO.getCategoria());
			String port = getConfiguracionCorreo(TipoCatalogoEnum.PUERTO_CORREO.getCategoria());
			String from = getConfiguracionCorreo(TipoCatalogoEnum.FROM_CORREO.getCategoria());
			String protocol = getConfiguracionCorreo(TipoCatalogoEnum.PROTOCOL_CORREO.getCategoria());
			String usuarioSmpt = getConfiguracionCorreo(TipoCatalogoEnum.USUARIO_CORREO.getCategoria());
			String password = getConfiguracionCorreo(TipoCatalogoEnum.CLAVE_CORREO.getCategoria());

			// Propiedades de la conexión
			// Get system properties
			Properties properties = new Properties();

			// Setup mail server
			properties.setProperty("mail.smtp.host", host);
                        properties.setProperty("mail.smtp.user", usuarioSmpt);
                        properties.setProperty("mail.smtp.password",password);
                        properties.setProperty("mail.smtp.port", port);
			properties.setProperty("mail.smtp.starttls.enable", "true");
                        properties.setProperty("mail.smtp.auth", "true");
                        properties.setProperty("mail.debug", "false");
			// Setup Port
		

                        properties.put("mail.smtp.ssl.trust", host);

                        SmtpAuthenticator auth = new SmtpAuthenticator();
			


			// Get the default Session object.
			Session session = Session.getDefaultInstance(properties,auth);

			MimeMessage m = new MimeMessage(session);

			Address addressfrom = new InternetAddress(from);

			Address[] addresTto = new InternetAddress[] { new InternetAddress(
					address) };

			m.setFrom(addressfrom);

			BodyPart texto = new MimeBodyPart();
			texto.setText("Credenciales de acceso al sistema");
			texto.setContent(
					"<h1>Datos de Acceso</h1><table><tr><td>contraseña:</td><td>"
							+ mensaje + "</td></tr></table>", "text/html");
			// BodyPart adjunto = new MimeBodyPart();
			// adjunto.setDataHandler(new DataHandler(new FileDataSource(
			// "C:/PartePolicials.pdf")));
			// adjunto.setFileName("partepolicial.gif");

			MimeMultipart multiParte = new MimeMultipart();

			multiParte.addBodyPart(texto);
			// multiParte.addBodyPart(adjunto);

			m.setRecipients(Message.RecipientType.TO, addresTto);

			m.setSubject(asunto);

			m.setSentDate(new java.util.Date());

			// m.setContent(dirDatos, "text/plain");
			m.setContent(multiParte);

			Transport t = session.getTransport(protocol);
			// t.connect();
			t.connect(host, usuarioSmpt, password);
			m.saveChanges();
			//t.send(m, usuarioSmpt, password);

			t.send(m);
			t.close();
			return true;

		}

		catch (javax.mail.MessagingException e)

		{

			e.printStackTrace();
			return false;
		}

	} 

	// Envio pdf
	public static boolean sendMail(String address, String mensaje,
			String nombreDocumento, String nombreDocumento1, String codOferta,
			String mensajeEmail) throws java.rmi.RemoteException {

		try {

			String asunto = "Grupo K... Url Oferta";
			String host = "200.105.225.2";
			String port = "25";
			String from = "ltumipamba@ksgroup.com.ec";
			String protocol = "smtp";

			// Propiedades de la conexión
			// Get system properties
			Properties properties = System.getProperties();

			// Setup mail server
			properties.setProperty("mail.smtp.host", host);
			// Setup Port
			properties.setProperty("mail.smtp.port", port);

			// props.setProperty("mail.smtp.host", "smtp.gmail.com");
			// props.setProperty("mail.smtp.starttls.enable", "true");
			// props.setProperty("mail.smtp.port", "587");
			// props.setProperty("mail.smtp.auth", "true");

			// Get the default Session object.
			SmtpAuthenticator auth = new SmtpAuthenticator(); 
			
			Session session = Session.getDefaultInstance(properties,auth);

			MimeMessage m = new MimeMessage(session);

			Address addressfrom = new InternetAddress(from);

			// Address[] addresTto = new InternetAddress[] { new
			// InternetAddress(address) };

			m.setFrom(addressfrom);

			BodyPart texto = new MimeBodyPart();
			texto.setText("Credenciales de acceso al sistema");
			texto.setContent("<h1>Consultar Oferta</h1>" + mensajeEmail
					+ "<table><tr><td>Url:</td><td><a href=" + mensaje + ">"
					+ mensaje + "</a></td></tr><tr><td>Nº Oferta:</td><td>"
					+ codOferta + "</td><tr></table>", "text/html");
			// inicio adjunto
			BodyPart adjunto = new MimeBodyPart();
			adjunto.setDataHandler(new DataHandler(new FileDataSource(
					nombreDocumento)));
			// adjunto.setFileName("partepolicial.pdf");
			adjunto.setFileName(nombreDocumento1);
			// fin adjunto

			MimeMultipart multiParte = new MimeMultipart();

			multiParte.addBodyPart(texto);
			// inicio adjunto
			multiParte.addBodyPart(adjunto);
			// fin adjunto
			// m.setRecipients(Message.RecipientType.TO, addresTto);
			m.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(address));

			m.setSubject(asunto);

			m.setSentDate(new java.util.Date());

			// m.setContent(dirDatos, "text/plain");
			m.setContent(multiParte);

			Transport t = session.getTransport(protocol);
			t.connect();

			t.send(m);
			t.close();
			return true;

		}

		catch (javax.mail.MessagingException e)

		{

			e.printStackTrace();
			return false;
		}

	}

}

class SmtpAuthenticator extends Authenticator {
    public SmtpAuthenticator() {

        super();
    }

    @Override
    public PasswordAuthentication getPasswordAuthentication() {
     String username = "robayo.galo@gmail.com";
     String password = "tiyana2012";
        if ((username != null) && (username.length() > 0) && (password != null) 
          && (password.length   () > 0)) {

            return new PasswordAuthentication(username, password);
        }

        return null;
    }
}

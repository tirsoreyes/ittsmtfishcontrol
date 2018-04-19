package edu.itssmt.tools;





import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Component;


@Component
public class Utilerias {
	private static final String KEY = ":)";

	public String encript(String texto) {
		String textoEncriptado = DigestUtils.sha512Hex(texto + KEY);
		return textoEncriptado;
	}
	
public String sendEmail (String email, String cuerpo){
		
		Email correo = new SimpleEmail();
		correo.setHostName("smtp.gmail.com");
		correo.setSmtpPort(587);
		

		correo.setAuthenticator(new DefaultAuthenticator("soporte@citat.com.mx"
				+ "", "Morphy0159"));

		
		//correo.setSSLOnConnect(true);
		correo.setDebug(true);
		
		
		//correo.setStartTLSEnabled(true);
		correo.setTLS(true);
		try {
			correo.setFrom("soporte@citat.com.mx");
		
		correo.setSubject("soporte@citat.com.mx");
		correo.setMsg(cuerpo);
		correo.addTo(email);
		correo.send();
		} catch (EmailException e) {
			
			e.printStackTrace();
			System.out.println("Error al enviar email: "+e);
			return "false";
		}
		
		
		return "true";
	}


	
}

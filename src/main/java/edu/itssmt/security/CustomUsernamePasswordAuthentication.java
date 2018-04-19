package edu.itssmt.security;


import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import edu.itssmt.model.credenciales.Credenciales;
import edu.itssmt.service.IUsuarioService;



@Component
public class CustomUsernamePasswordAuthentication implements  AuthenticationProvider {
	private static final Logger _log = LoggerFactory.getLogger(CustomUsernamePasswordAuthentication.class);

	@Autowired 
	IUsuarioService usuarioService; 
	
	
	@Value("${img.default}")
	String imagenDefault;
	
	public CustomUsernamePasswordAuthentication(){
		System.out.println("this is working");
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		String username = authentication.getName().trim();
		String password = authentication.getCredentials().toString().trim();
		_log.debug("Autenticando usuario: " + username);
	
	System.out.println(" validando crdenciales.. ");
		boolean isValidUsername = StringUtils.isNotBlank(username) && username.length() > 3;
		boolean isValidPassword = StringUtils.isNotBlank(password);

		if (!isValidUsername || !isValidPassword) {
			throw new BadCredentialsException("Credenciales invalidas");
		}

			boolean valid= false;
			
			Credenciales credenciales = null;
			try {
				
				credenciales = usuarioService.validaCredenciales(username,password);
			   if(credenciales!=null)
				   valid=true;
				
			} catch (Exception e) {
				
				throw new BadCredentialsException("Credenciales invalidas");
			}
			
			if(!valid) {
				throw new BadCredentialsException("Credenciales invalidas");
			}
			
			if(credenciales.getAvatar()==null || credenciales.getAvatar().equals(""))
				credenciales.setAvatar(imagenDefault);
			
			
			
	        return new UsernamePasswordAuthenticationToken(credenciales,username, new ArrayList<GrantedAuthority>());

	}

	@Override
	public boolean supports(Class<?> authentication) {
	    return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
	
	
}
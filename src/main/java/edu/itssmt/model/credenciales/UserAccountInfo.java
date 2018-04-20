package edu.itssmt.model.credenciales;

import java.util.ArrayList;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component("userContext")
public class UserAccountInfo {
	


	private Authentication getAuth() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	/**
	 * Obtiene las credenciales de sesión
	 * 
	 * @return
	 */
	public Credenciales getUserCredentials() {
		if (getAuth() != null) {
			if (getAuth().getPrincipal() instanceof Credenciales) {
				return (Credenciales) getAuth().getPrincipal();
			}
		}
		return null;
	}

	public void setUserCredentials(Credenciales credentials) {
		if (getAuth() != null) {
			Authentication userAuth = new UsernamePasswordAuthenticationToken(credentials.getCorreo(),
					credentials, new ArrayList<GrantedAuthority>());
			SecurityContextHolder.getContext().setAuthentication(userAuth);
		}
	}
	public boolean isAuthenticated() {
		return getAuth() != null && getUserCredentials() != null && getAuth().isAuthenticated();
	}
	
	
	
	
}

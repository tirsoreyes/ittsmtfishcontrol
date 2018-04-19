package edu.itssmt.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class AuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	  @Override
	    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
	                                        AuthenticationException exception) throws IOException, ServletException {

		  if(exception instanceof BadCredentialsException ) {
			  response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		        response.getWriter().print("{\"success\": false, \"type\":1}");
		        response.getWriter().flush();
		        return;
		        
		  }
		  response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	        response.getWriter().print("{\"success\": false, \"type\":2}");
	        response.getWriter().flush();
	        return;
	    }
	
}

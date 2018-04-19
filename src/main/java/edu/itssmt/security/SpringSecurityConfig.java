package edu.itssmt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    private AccessDeniedHandler accessDeniedHandler;
	
	@Autowired
	private CustomUsernamePasswordAuthentication cuapsa;

	@Autowired
    AuthFailureHandler authFailureHandler;

    @Autowired
    AuthSuccessHandler authSuccessHandler;
    
	@Override
    protected void configure(HttpSecurity http) throws Exception {
 System.out.println("login try on back");
        http.csrf().disable()
                .authorizeRequests()
					.antMatchers("/", "/home","/menu", "/about","/recupera/**","/img/**","/css/**","/fonts/**",
							"/js/**", "/404.html","/error/**").permitAll()
					.anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .failureHandler(authFailureHandler)
                .successHandler(authSuccessHandler)
					.loginPage("/home?error=true")
					.permitAll()
					.and()
                .logout()
					.permitAll()
					.and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler).and()
                .rememberMe();
    }

    // create two users, admin and user
   @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(cuapsa);
    } 
}

package edu.itssmt.service;

import org.springframework.stereotype.Component;

import edu.itssmt.model.credenciales.Credenciales;

@Component
public interface IUsuarioService {

	public Credenciales validaCredenciales(String username, String password);

}

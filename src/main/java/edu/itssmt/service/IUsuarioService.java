package edu.itssmt.service;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.itssmt.model.MiUsuario;
import edu.itssmt.model.NuevoUsuario;
import edu.itssmt.model.Respuesta;
import edu.itssmt.model.credenciales.Credenciales;

@Component
public interface IUsuarioService {

	public Credenciales validaCredenciales(String username, String password) throws Exception;
	
	public Respuesta newUser(NuevoUsuario nuevoUsuario);

	public List<MiUsuario> obtenUsuariosPorSesion();


}

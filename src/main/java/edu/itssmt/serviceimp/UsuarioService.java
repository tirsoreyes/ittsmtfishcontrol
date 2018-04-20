package edu.itssmt.serviceimp;

import org.springframework.stereotype.Service;

import edu.itssmt.model.credenciales.Credenciales;
import edu.itssmt.service.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService {

	@Override
	public Credenciales validaCredenciales(String username, String password) {
		Credenciales cred = new Credenciales();
		
		cred.setApellidos("apellidos");
		cred.setAvatar("");
		cred.setCorreo(username);
		cred.setFechaRegistro("2018-04-04");
		cred.setFechaUltimoAcceso("2018-04-04");
		cred.setGrupo("grupo nombre");
		cred.setIdGrupo(1);
		cred.setIdUsuario(2);
		cred.setNombre(username);
		cred.setTelefono("777 888 9999");
		
		
		
		return cred;
	}

}

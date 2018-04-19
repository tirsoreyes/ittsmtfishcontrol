package edu.itssmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.itssmt.model.NuevoUsuario;
import edu.itssmt.model.Respuesta;
import edu.itssmt.model.credenciales.UserAccountInfo;
import edu.itssmt.service.IUsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UserAccountInfo userContext;
	
	@Autowired
	IUsuarioService usuarioService;
	
	@PostMapping(value="/newUser")
	@ResponseBody
	public Respuesta nuevoUsuario(NuevoUsuario nuevoUsuario){
		return usuarioService.newUser(nuevoUsuario);
		
	}

}

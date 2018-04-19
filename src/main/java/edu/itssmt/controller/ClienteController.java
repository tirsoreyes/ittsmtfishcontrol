package edu.itssmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.itssmt.model.NuevoCliente;
import edu.itssmt.model.Respuesta;
import edu.itssmt.model.credenciales.UserAccountInfo;
import edu.itssmt.service.IClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	UserAccountInfo userContext;
	
	@Autowired
	IClienteService clienteService;
	
	@PostMapping(value="/newClient")
	@ResponseBody
	public Respuesta nuevoCliente(NuevoCliente nuevoCliente){
		return clienteService.newClient(nuevoCliente);
	}
	
	
}

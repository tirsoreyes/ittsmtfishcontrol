package edu.itssmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.itssmt.model.NuevaEmpresa;
import edu.itssmt.model.Respuesta;
import edu.itssmt.model.credenciales.UserAccountInfo;
import edu.itssmt.service.IEmpresaService;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {
	@Autowired
	UserAccountInfo userContext;
	
	@Autowired
	IEmpresaService empresaService;
	
	@PostMapping(value="/newEnterprise")
	@ResponseBody
	public Respuesta nuevaEmpresa(NuevaEmpresa nuevaEmpresa){
		return empresaService.newEnterprise(nuevaEmpresa);
		
	}
	
	
}

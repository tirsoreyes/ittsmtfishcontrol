package edu.itssmt.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import edu.itssmt.model.MiUsuario;
import edu.itssmt.model.Objeto;
import edu.itssmt.model.credenciales.UserAccountInfo;
import edu.itssmt.service.ICitaService;
import edu.itssmt.service.IClienteService;
import edu.itssmt.service.IHorarioService;
import edu.itssmt.service.IMainService;
import edu.itssmt.service.IUsuarioService;

@Service
public class MainService implements IMainService {
	
	@Autowired
	UserAccountInfo userContext;
	
	@Autowired 
	IUsuarioService usuarioService;
	
	@Autowired 
	IClienteService clienteService;
	
	@Autowired
	IHorarioService horarioService;
	
	@Autowired
	ICitaService citaService;

	@Override
	public Model execute(Model model, String content) {
		model.addAttribute("content",content);
		model.addAttribute("menu", true);
		
		//aquí va la magia!!!
		 
		if(content.equals("empresaMisEmpresas"))
		   model.addAttribute("empresas",userContext.getUserCredentials().getListaEmpresas());
		
		
		if(content.equals("usuarioMisUsuarios"))
			   model.addAttribute("usuarios",usuarioService.obtenUsuariosPorSesion());
		
		
		if(content.equals("clienteMisClientes"))
			model.addAttribute("clientes", clienteService.obtenClientesPorSesion());
			
		if(content.equals("horarioAgregar"))
			model.addAttribute("horarios", horarioService.obtenHorarioPorSesion());
		
		if(content.equals("citaAgregar"))
			model.addAttribute("citas", citaService.obtenCitasDeHoy());
		
		
		return model;
	}


	

	
}

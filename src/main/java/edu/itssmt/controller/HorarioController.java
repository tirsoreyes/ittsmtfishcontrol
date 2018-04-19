package edu.itssmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.itssmt.model.NuevoHorario;
import edu.itssmt.model.Respuesta;
import edu.itssmt.service.IHorarioService;

@Controller
@RequestMapping("/horario")
public class HorarioController {

	@Autowired
	IHorarioService horarioService;
	
	@PostMapping(value="/newHorario")
	@ResponseBody
	public Respuesta nuevoHorario(NuevoHorario nuevoHorario){
		
		return horarioService.saveNuevoHorario(nuevoHorario); 
		
	} 
	
}

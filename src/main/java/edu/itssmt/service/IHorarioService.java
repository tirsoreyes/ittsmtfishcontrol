package edu.itssmt.service;

import org.springframework.stereotype.Component;

import edu.itssmt.model.MisHorarios;
import edu.itssmt.model.NuevoHorario;
import edu.itssmt.model.Respuesta;

@Component
public interface IHorarioService {

	public MisHorarios obtenHorarioPorSesion();

	public Respuesta saveNuevoHorario(NuevoHorario nuevoHorario);

}

package edu.itssmt.service;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.itssmt.model.MiCliente;
import edu.itssmt.model.NuevoCliente;
import edu.itssmt.model.Respuesta;

@Component
public interface IClienteService {

	public Respuesta newClient(NuevoCliente nuevoCliente);

	public List<MiCliente> obtenClientesPorSesion();

}

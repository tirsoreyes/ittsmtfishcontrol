package edu.itssmt.service;

import org.springframework.stereotype.Component;

import edu.itssmt.model.NuevaEmpresa;
import edu.itssmt.model.Respuesta;

@Component
public interface IEmpresaService {

	public Respuesta newEnterprise(NuevaEmpresa nuevaEmpresa);

}

package edu.itssmt.service;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.itssmt.model.MiCita;

@Component
public interface ICitaService {

	public List<MiCita> obtenCitasDeHoy();

}

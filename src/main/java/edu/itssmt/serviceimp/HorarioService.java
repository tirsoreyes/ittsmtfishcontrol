package edu.itssmt.serviceimp;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.itssmt.dao.ITEmpresaDao;
import edu.itssmt.dao.ITHorarioDao;
import edu.itssmt.entity.TEmpresa;
import edu.itssmt.entity.THorario;
import edu.itssmt.model.Horario;
import edu.itssmt.model.MisHorarios;
import edu.itssmt.model.NuevoHorario;
import edu.itssmt.model.Respuesta;
import edu.itssmt.model.credenciales.UserAccountInfo;
import edu.itssmt.service.IHorarioService;

@Service
public class HorarioService implements IHorarioService {

	@Autowired
	ITEmpresaDao empresaDao;
	
	@Autowired
	ITHorarioDao horarioDao;

	@Autowired
	UserAccountInfo userContext;

	@SuppressWarnings("unchecked")
	@Override
	public MisHorarios obtenHorarioPorSesion() {
		MisHorarios misHorarios = new MisHorarios();
		List<Horario> lunes = new ArrayList<>();
		List<Horario> martes = new ArrayList<>();
		List<Horario> miercoles = new ArrayList<>();
		List<Horario> jueves = new ArrayList<>();
		List<Horario> viernes = new ArrayList<>();
		List<Horario> sabados = new ArrayList<>();
		List<Horario> domingos = new ArrayList<>();

		try {

			TEmpresa tEmpresa = empresaDao.findOne(userContext.getUserCredentials().getIdEmpresaActual());

			if (tEmpresa.getTHorarios() != null) {
				
				List<THorario> listaHorarios = tEmpresa.getTHorarios();
				
				
				for (THorario i : listaHorarios) {
					if (i.getDia().equals("Lunes"))
						lunes.add(addHorario(i));
					if (i.getDia().equals("Martes"))
						martes.add(addHorario(i));
					if (i.getDia().equals("Miercoles"))
						miercoles.add(addHorario(i));
					if (i.getDia().equals("Jueves"))
						jueves.add(addHorario(i));
					if (i.getDia().equals("Viernes"))
						viernes.add(addHorario(i));
					if (i.getDia().equals("Sabado"))
						sabados.add(addHorario(i));
					if (i.getDia().equals("Domingo"))
						domingos.add(addHorario(i));
					

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		misHorarios.setLunes(lunes);
		misHorarios.setMartes(martes);
		misHorarios.setMiercoles(miercoles);
		misHorarios.setJueves(jueves);
		misHorarios.setViernes(viernes);
		misHorarios.setDomingos(domingos);
		misHorarios.setSabados(sabados);
		
		
		return misHorarios;
	}

	private Horario addHorario(THorario i) {
		Horario horario = new Horario();
		try {

			horario.setActivo(i.getActivo());
			horario.setDia(i.getDia());
			horario.setHora(extraeHora(i.getHora()));
			horario.setId(i.getId());
		} catch (Exception e) {
			e.printStackTrace();
			
		}

		return horario;
	}

	
	private String extraeHora(Time hora) {
		try {
		return hora.toLocalTime().toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "00:00:error";
		}
		
		
	}

	@Override
	public Respuesta saveNuevoHorario(NuevoHorario nuevoHorario) {
		Respuesta response = new Respuesta();
		try {
			
			TEmpresa tEmpresa = empresaDao.findOne(userContext.getUserCredentials().getIdEmpresaActual());
			if(tEmpresa==null){
				response.setCode(500);
				System.out.println("Error al obtener información de la empresa ");
				response.setMessage("Servicio no disponible temporalmente");
				return response;
			}
			
			
			if(existeElHorario(tEmpresa.getTHorarios(), nuevoHorario)){
				response.setCode(403);
				response.setMessage("El horario ya esta dado de alta");
				return response;
			}
			
			THorario tHorario = new THorario();
			tHorario.setActivo("Activo");
			tHorario.setDia(nuevoHorario.getSelectDia());
			tHorario.setHora(convierteAHora(nuevoHorario.getHora()));
			tHorario.setTEmpresa(tEmpresa);
			
			horarioDao.save(tHorario);
			response.setCode(200);
			response.setMessage("Horario dado de alta correctamente");
			
		} catch (Exception e) {
			e.printStackTrace();
			response.setCode(503);
			response.setMessage("Servicio no disponible temporalmente intente mas tarde");
		}
		
		return response;
	}

	@SuppressWarnings("deprecation")
	private Time convierteAHora(String hora) {
		return new Time(Integer.parseInt(hora.split(":")[0]), Integer.parseInt(hora.split(":")[1]), 0);
		
	}

	private boolean existeElHorario(List<THorario> tHorarios, NuevoHorario nuevoHorario) {
		if(tHorarios==null)
			return false;
		for(THorario t:tHorarios){
			String hora = extraeHora(t.getHora());
			if(t.getDia().equals(nuevoHorario.getSelectDia()) && hora.equals(nuevoHorario.getHora()))
				return true;
			
		}
		
		return false;
	}

}

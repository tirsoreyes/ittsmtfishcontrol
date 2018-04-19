package edu.itssmt.serviceimp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.itssmt.dao.ITCitaDao;
import edu.itssmt.entity.TCita;
import edu.itssmt.model.MiCita;
import edu.itssmt.model.credenciales.UserAccountInfo;
import edu.itssmt.service.ICitaService;
import edu.itssmt.tools.DateTimeAdapter;

@Service
public class CitaService implements ICitaService {

	@Autowired
	ITCitaDao citaDao;
	
	@Autowired
	DateTimeAdapter dateTime;

	@Autowired
	UserAccountInfo userContext;

	@Override
	public List<MiCita> obtenCitasDeHoy() {
		List<MiCita> citas = new ArrayList<>();
		try {
			
			String fech = (dateTime.marshal(new Date())).split(" ")[0];
			String start =fech+" 00:00:01";
			String end = fech+" 23:59:59";
			
			Date fechaCitaInicio = dateTime.unmarshal(start);
			Date fechaCitaFin = dateTime.unmarshal(end);
			
			List<TCita> listaCita= citaDao.findCitaByEmpresaAndFechaCita(userContext.getUserCredentials().getIdEmpresaActual(), fechaCitaInicio, fechaCitaFin);
			
		
			for(TCita tCita:listaCita){
				MiCita cita = new MiCita();
				

				
				
				
				
				
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return citas;
	}

}

package edu.itssmt.serviceimp;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.itssmt.dao.ITNuevaEmpresaDao;
import edu.itssmt.entity.TNuevaEmpresa;
import edu.itssmt.model.NuevaEmpresa;
import edu.itssmt.model.Respuesta;
import edu.itssmt.model.credenciales.UserAccountInfo;
import edu.itssmt.service.IEmpresaService;

@Service
public class EmpresaService implements IEmpresaService {
	
	
	@Autowired
	UserAccountInfo userContext;
	
	@Autowired
	ITNuevaEmpresaDao nuevaEmpresaDao;

	@Override
	public Respuesta newEnterprise(NuevaEmpresa nuevaEmpresa) {
		
		
		Respuesta respuesta = new Respuesta();
		try {
			
		
		if(nuevaEmpresa==null ||
		   nuevaEmpresa.getCiudad() == null || 
			nuevaEmpresa.getCodigoPostal() ==null ||
			nuevaEmpresa.getColonia() ==null ||
			nuevaEmpresa.getDireccion() ==null ||
			nuevaEmpresa.getEstado() == null ||
			nuevaEmpresa.getMunicipio() == null ||
			nuevaEmpresa.getNombreComercial() == null ||
			nuevaEmpresa.getNombreFiscal() == null ||
			nuevaEmpresa.getCiudad().isEmpty() || 
			nuevaEmpresa.getCodigoPostal().isEmpty() ||
			nuevaEmpresa.getColonia().isEmpty() ||
			nuevaEmpresa.getDireccion().isEmpty() ||
			nuevaEmpresa.getEstado().isEmpty() ||
			nuevaEmpresa.getMunicipio().isEmpty() ||
			nuevaEmpresa.getNombreComercial().isEmpty() ||
			nuevaEmpresa.getNombreFiscal().isEmpty()
			
		   ){
			
			respuesta.setCode(403);
			respuesta.setMessage("Información incompleta...");
			return respuesta;
			
			
		}
		
		
		TNuevaEmpresa tNuevaEmpresa= nuevaEmpresaDao.findByNombreComercial(nuevaEmpresa.getNombreComercial());
		
		if(tNuevaEmpresa!=null){
			 respuesta.setCode(403);
			 respuesta.setMessage("Esta empresa ya la tiene usted registrada");
			 return respuesta;
		}
		
		tNuevaEmpresa = new TNuevaEmpresa();
		tNuevaEmpresa.setCiudad(nuevaEmpresa.getCiudad());
		tNuevaEmpresa.setCodigoPostal(nuevaEmpresa.getCodigoPostal());
		tNuevaEmpresa.setColonia(nuevaEmpresa.getColonia());
		tNuevaEmpresa.setDireccion(nuevaEmpresa.getDireccion());
		tNuevaEmpresa.setEmail(userContext.getUserCredentials().getEmail());
		tNuevaEmpresa.setEstado(nuevaEmpresa.getEstado());
		tNuevaEmpresa.setEstatus("pendiente");
		tNuevaEmpresa.setFechaActivacion(new Date());
		tNuevaEmpresa.setFechaSolicitud(new Date());
		tNuevaEmpresa.setIdCliente(userContext.getUserCredentials().getId());
		tNuevaEmpresa.setMunicipio(nuevaEmpresa.getMunicipio());
		tNuevaEmpresa.setNombreComercial(nuevaEmpresa.getNombreComercial());
		tNuevaEmpresa.setNombreFiscal(nuevaEmpresa.getNombreFiscal());
		tNuevaEmpresa.setNombreCliente(userContext.getUserCredentials().getNombre()+" "+userContext.getUserCredentials().getApellido_Paterno()+ " "+userContext.getUserCredentials().getApellido_Materno());
		
		nuevaEmpresaDao.save(tNuevaEmpresa);
		
		
		respuesta.setCode(200);
		respuesta.setMessage("Su solicitud fue enviada con exito, proto será contactado");
		} catch (Exception e) {
		e.printStackTrace();
		respuesta.setCode(500);
		respuesta.setMessage("No se pudo registrar su solicitud");
		}
		
		return respuesta;
	}

}

package edu.itssmt.serviceimp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.itssmt.dao.ITEmpresaDao;
import edu.itssmt.dao.ITUsuarioDao;
import edu.itssmt.dao.ITUsuarioGrupoEmpresaDao;
import edu.itssmt.entity.TEmpresa;
import edu.itssmt.entity.TUsuario;
import edu.itssmt.entity.TUsuarioGrupoEmpresa;
import edu.itssmt.model.MiCliente;
import edu.itssmt.model.NuevoCliente;
import edu.itssmt.model.Respuesta;
import edu.itssmt.model.credenciales.UserAccountInfo;
import edu.itssmt.service.IClienteService;
import edu.itssmt.tools.DateTimeAdapter;
import edu.itssmt.tools.Utilerias;

@Service
public class ClienteService implements IClienteService {
	
	@Autowired
	ITUsuarioDao usuarioDao;
	
	@Autowired
	ITUsuarioGrupoEmpresaDao ugeDao;

	@Autowired
	UserAccountInfo userContext;
	
	@Autowired
	ITEmpresaDao empresaDao;
	
	@Autowired
	Utilerias utilerias;
	
	@Autowired
	DateTimeAdapter dateTime;
	
	@Override
	public Respuesta newClient(NuevoCliente nuevoCliente) {
		Respuesta response = new Respuesta();
		TUsuario tUsuario =null;
		
		try {
			tUsuario= usuarioDao.findByEmail(nuevoCliente.getEmail());
		
		} catch (Exception e) {
		e.printStackTrace();
		response.setCode(500);
		response.setMessage("Servicio no disponible temporalmente, intente mas tarde.");
		return response;
		}	
		
		
		if(tUsuario==null){
			return saveNuevoUsuario(nuevoCliente);
		}
		
		return saveExistentClient(tUsuario);
		
	}

	private Respuesta saveExistentClient(TUsuario tUsuario) {
		Respuesta response = new Respuesta();
		try {
			
			for(TUsuarioGrupoEmpresa i: tUsuario.getTUsuarioGrupoEmpresas()){
				if(userContext.getUserCredentials().getIdEmpresaActual()==i.getId().getT_EMPRESA_Id() && i.getTGrupo().getId()==119){
					response.setCode(403);
					response.setMessage("El usuario "+tUsuario.getEmail()+" ya era parte de sus clientes, no se realizó ninguna acción");
					return response;
				}
			}
			
			int r= ugeDao.saveNewRelation(userContext.getUserCredentials().getIdEmpresaActual(), 119, tUsuario.getId());
			
			if(r==1){
			response.setCode(200);
			response.setMessage("El usuario "+tUsuario.getEmail()+" ya existia, y se agrego a su empresa como cliente.");
			}else{
				response.setCode(503);
				response.setMessage("Servicio no disponible temporalmente, intente mas tarde");

			}
			
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			response.setCode(503);
			response.setMessage("Servicio no disponible temporalmente");
			return response;
		}
		
		
		
	}

	private Respuesta saveNuevoUsuario(NuevoCliente nuevoCliente) {
		Respuesta response = new Respuesta();
		try {
		TUsuario tUsuario = new TUsuario();	
		tUsuario.setAcceso_From("mobile");
		tUsuario.setApellido_Materno(nuevoCliente.getApellidoMaterno());
		tUsuario.setApellido_Paterno(nuevoCliente.getApellidoPaterno());
		tUsuario.setAvatar("".getBytes());
		tUsuario.setCelular(nuevoCliente.getCelular());
		tUsuario.setEmail(nuevoCliente.getEmail());
		tUsuario.setEstatus("Activo");
		tUsuario.setNombre(nuevoCliente.getNombre());
		tUsuario.setPass(utilerias.encript(nuevoCliente.getNombre()+System.currentTimeMillis()));
		tUsuario.setToken("");
		tUsuario.setUltima_Ubicacion("");
		tUsuario.setUltimo_Acceso(new Date());
		
		usuarioDao.save(tUsuario);
		
		
		int r= ugeDao.saveNewRelation(userContext.getUserCredentials().getIdEmpresaActual(), 119, tUsuario.getId());
		
		if(r==1){
			response.setCode(200);
			response.setMessage("Cliente agregado correctamente");
		}else{
			response.setCode(503);
			response.setMessage("Servicio no disponible temporalmente, intente mas tarde");
		}
		
		} catch (Exception e) {
		e.printStackTrace();
		response.setCode(500);
		response.setMessage("Servicio temporalmente no disponible");
		
		}
		
		return response;
	}

	@Override
	public List<MiCliente> obtenClientesPorSesion() {
		
		List<MiCliente> listaClientes = new ArrayList<>();
		try {
			
			TEmpresa tEmpresa= empresaDao.findOne(userContext.getUserCredentials().getIdEmpresaActual());
			
			for(TUsuarioGrupoEmpresa i:tEmpresa.getTUsuarioGrupoEmpresas()){
				MiCliente cliente = new MiCliente();
				
				cliente.setCelular(i.getTUsuario().getCelular());
				cliente.setEmail(i.getTUsuario().getEmail());
				cliente.setEstatus(i.getTUsuario().getEstatus());
				cliente.setId(i.getTUsuario().getId());
				cliente.setNombre(i.getTUsuario().getNombre());
				cliente.setUltimoAcceso(dateTime.marshal(i.getTUsuario().getUltimo_Acceso()));
				cliente.setNivel(i.getTGrupo().getNombre());
				
				
				if(!listaClientes.contains(cliente) && cliente.getNivel().equals("Cliente"))
					listaClientes.add(cliente);
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaClientes;
	}

}

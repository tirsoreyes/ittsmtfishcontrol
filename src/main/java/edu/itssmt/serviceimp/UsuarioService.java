package edu.itssmt.serviceimp;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.itssmt.dao.ITEmpresaDao;
import edu.itssmt.dao.ITGrupoDao;
import edu.itssmt.dao.ITUsuarioDao;
import edu.itssmt.dao.ITUsuarioGrupoEmpresaDao;
import edu.itssmt.entity.TEmpresa;
import edu.itssmt.entity.TGrupo;
import edu.itssmt.entity.TUsuario;
import edu.itssmt.entity.TUsuarioGrupoEmpresa;
import edu.itssmt.entity.TUsuarioGrupoEmpresaPK;
import edu.itssmt.model.MiUsuario;
import edu.itssmt.model.NuevoUsuario;
import edu.itssmt.model.Respuesta;
import edu.itssmt.model.credenciales.Credenciales;
import edu.itssmt.model.credenciales.EmpresaBean;
import edu.itssmt.model.credenciales.UserAccountInfo;
import edu.itssmt.service.IUsuarioService;
import edu.itssmt.tools.DateTimeAdapter;
import edu.itssmt.tools.Utilerias;

@Service
public class UsuarioService implements IUsuarioService {
	@Autowired
	UserAccountInfo userContext;
	
	@Autowired
	ITUsuarioDao usuarioDao;
	
	@Autowired 
	DateTimeAdapter dateTime;
	
	@Autowired
	Utilerias utilerias;
	
	@Autowired
	ITUsuarioGrupoEmpresaDao ugeDao;
	
	
	
	@Autowired
	ITGrupoDao grupoDao;
	
	@Autowired
	ITEmpresaDao empresaDao;

	@Override
	public Credenciales validaCredenciales(String username, String password) throws Exception {
		Credenciales credencial= new Credenciales();
		try {
			
		
		
		TUsuario usuario= usuarioDao.findByEmail(username);
		
		if(usuario==null){
			System.out.println("no se encontro el usuario "+username+" en la base de datos");
			return null;
		}
		
		
		if(!usuario.getPass().equals(utilerias.encript(password))){
			System.out.println("Las credenciales no coinciden con el password "+"password para el usuario " +username);
			return null;
		}
		
		
		credencial.setApellido_Materno(usuario.getApellido_Materno());
		credencial.setApellido_Paterno(usuario.getApellido_Paterno());
		credencial.setAvatar("");
		credencial.setCelular(usuario.getCelular());
		credencial.setEmail(usuario.getEmail());
		credencial.setEstatus(usuario.getEstatus());
		credencial.setId(usuario.getId());
		credencial.setIdEmpresaActual(usuario.getTUsuarioGrupoEmpresas().get(0).getTEmpresa().getId());
		credencial.setListaEmpresas(obtenListaEmpresas(usuario.getTUsuarioGrupoEmpresas()));
		credencial.setNivel(usuario.getTUsuarioGrupoEmpresas().get(0).getTGrupo().getNombre());
		credencial.setNombre(usuario.getNombre());
		credencial.setNombreEmpresaActual(usuario.getTUsuarioGrupoEmpresas().get(0).getTEmpresa().getNombre_Comercial());
		credencial.setPass("*************");
		credencial.setUltimo_Acceso(usuario.getUltimo_Acceso()==null?"":dateTime.marshal(usuario.getUltimo_Acceso()));
		
		
		if(credencial.getListaEmpresas()==null || credencial.getListaEmpresas().size()==0) 
			return null;
		
		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
		
		return credencial;
	}

	private List<EmpresaBean> obtenListaEmpresas(List<TUsuarioGrupoEmpresa> tUsuarioGrupoEmpresas) {
		
		List<EmpresaBean> lista = new ArrayList<>();
		
		for(TUsuarioGrupoEmpresa it: tUsuarioGrupoEmpresas){
			
			
			EmpresaBean empresa = new EmpresaBean();
			try {
				empresa.setFecha_Registro(it.getTEmpresa().getFecha_Registro()==null?"":dateTime.marshal(it.getTEmpresa().getFecha_Registro()));
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			empresa.setId(it.getTEmpresa().getId());
			empresa.setNombre_Comercial(it.getTEmpresa().getNombre_Comercial()==null?"":it.getTEmpresa().getNombre_Comercial());
			empresa.setNombre_Fiscal(it.getTEmpresa().getNombre_Fiscal()==null?"":it.getTEmpresa().getNombre_Fiscal());
			empresa.setUbicacion(it.getTEmpresa().getUbicacion()==null?"":it.getTEmpresa().getUbicacion());
			empresa.setIdGrupo(it.getTGrupo().getId());
			empresa.setNivel(it.getTGrupo().getNombre());
			
			if(!lista.contains(empresa) && !empresa.getNivel().equals("ROOT"))
				lista.add(empresa);
			
			
		}
		
		
		
		
		
		return lista;
	}

	@Override
	public Respuesta newUser(NuevoUsuario nuevoUsuario) {
		Respuesta response = new Respuesta();
		try {
		
			TUsuario tUsuario =usuarioDao.findByEmail(nuevoUsuario.getEmail());
			
			response = saveusuario(tUsuario, nuevoUsuario); 
			
			
		} catch (Exception e) {
			e.printStackTrace();
			response.setCode(500);
			response.setMessage("Servicio no disponible, intente mas tarde --codigo 500--");
		}
		
		
		return response;
		
	
	}

	private Respuesta saveusuario(TUsuario tUsuario, NuevoUsuario nuevoUsuario) throws Exception{
		
		Respuesta response = new Respuesta();
		
		if(tUsuario==null)
			return agregaUsuarioNuevo(nuevoUsuario);
		
	
		return procesaUsuario(tUsuario,nuevoUsuario);
	 
		
		
	}

	

	private Respuesta procesaUsuario(TUsuario tUsuario, NuevoUsuario nuevoUsuario) throws Exception{
		Respuesta response = new Respuesta();
		if(yaesdelaempresa(tUsuario,nuevoUsuario.getEmail())){
			response.setCode(403);
			response.setMessage("El usuario "+nuevoUsuario.getEmail()+" ya es parte de esta empresa");
			return response;
			
		}
		
		return agregaUsuarioAEmpresa(tUsuario,Integer.parseInt(nuevoUsuario.getSelectGrupo()));
		
	}

	private boolean yaesdelaempresa(TUsuario tUsuario, String email) {
		
		for(TUsuarioGrupoEmpresa uge: tUsuario.getTUsuarioGrupoEmpresas())
			  if(userContext.getUserCredentials().getIdEmpresaActual()== uge.getTEmpresa().getId())
				  return true;
		return false;
	}

	
	private Respuesta agregaUsuarioAEmpresa(TUsuario tUsuario,int idGrupo) throws Exception{
		
		Respuesta response = new Respuesta();
		
		TGrupo tGrupo= grupoDao.findOne(idGrupo);
		if(tGrupo==null){
			response.setCode(403);
			response.setMessage("No se pudo asignar el grupo seleccionado, contacte a soporte");
			return response;
		}		
		
		int r=	ugeDao.saveNewRelation(userContext.getUserCredentials().getIdEmpresaActual(), tGrupo.getId(),tUsuario.getId());
		
		if(r==1){
		response.setCode(200);
		response.setMessage("El usuario "+tUsuario.getEmail() +" ya existia, solo fue agregado a su empresa, el password no se modificó");
		}else{
			response.setCode(500);
			response.setMessage("Servicio no disponible intente mas tarde");
		}
		
		return response;
	}
	
	private Respuesta agregaUsuarioNuevo(NuevoUsuario nuevoUsuario) throws Exception{
		Respuesta response = new Respuesta();
		
		
		
		TUsuarioGrupoEmpresa usuarioGrupoEmpresa = new TUsuarioGrupoEmpresa();
		
		
		usuarioGrupoEmpresa.setTEmpresa(empresaDao.findOne(userContext.getUserCredentials().getIdEmpresaActual()));
		usuarioGrupoEmpresa.setTGrupo(grupoDao.findOne(Integer.parseInt(nuevoUsuario.getSelectGrupo())));
		usuarioGrupoEmpresa.setTUsuario(usuarioDao.save(generaEntityUsuario(nuevoUsuario)));
		
		
		TUsuarioGrupoEmpresaPK id = new TUsuarioGrupoEmpresaPK();
		/*
		id.setT_EMPRESA_Id(usuarioGrupoEmpresa.getTEmpresa().getId());
		id.setT_GRUPO_Id(usuarioGrupoEmpresa.getTGrupo().getId());
		id.setT_USUARIO_Id(usuarioGrupoEmpresa.getTUsuario().getId());
		*/
		usuarioGrupoEmpresa.setId(id);
		
		
	int r=	ugeDao.saveNewRelation(usuarioGrupoEmpresa.getTEmpresa().getId(), usuarioGrupoEmpresa.getTGrupo().getId(), usuarioGrupoEmpresa.getTUsuario().getId());
		
		if(r==1){
		response.setCode(200);
		response.setMessage("El usuario "+nuevoUsuario.getEmail()+ " fue agregado a su empresa correctamente.");
		}else{
			response.setCode(500);
			response.setMessage("Servicio no disponible intente mas tarde");
		}
		return response;
	}

	private TUsuario generaEntityUsuario(NuevoUsuario nuevoUsuario) {
		TUsuario tUsuario = new TUsuario();
		tUsuario.setAcceso_From("web");
		tUsuario.setApellido_Materno(nuevoUsuario.getApellidoMaterno());
		tUsuario.setApellido_Paterno(nuevoUsuario.getApellidoPaterno());
		tUsuario.setAvatar("".getBytes());
		tUsuario.setCelular(nuevoUsuario.getCelular());
		tUsuario.setEmail(nuevoUsuario.getEmail());
		tUsuario.setEstatus("Activo");
		tUsuario.setNombre(nuevoUsuario.getNombre());
		tUsuario.setPass(utilerias.encript(nuevoUsuario.getPass()));
		tUsuario.setToken("");
		tUsuario.setUltima_Ubicacion("");
		tUsuario.setUltimo_Acceso(new Date());
		
		
		return tUsuario;
	}

	@Override
	public List<MiUsuario> obtenUsuariosPorSesion() {
		   
		List<MiUsuario> listaUsuarios = new ArrayList<>();
		try {
			
			TEmpresa tEmpresa= empresaDao.findOne(userContext.getUserCredentials().getIdEmpresaActual());
			
			for(TUsuarioGrupoEmpresa i: tEmpresa.getTUsuarioGrupoEmpresas()){
				try {
					
			
				MiUsuario user = new MiUsuario();
				String nn= i.getTUsuario().getNombre()==null?"":i.getTUsuario().getNombre();
				String ap=i.getTUsuario().getApellido_Paterno()==null?"":i.getTUsuario().getApellido_Paterno();
				String am=i.getTUsuario().getApellido_Materno()==null?"":i.getTUsuario().getApellido_Materno();
				
				user.setCelular(i.getTUsuario().getCelular()==null?"":i.getTUsuario().getCelular());
				user.setEmail(i.getTUsuario().getEmail());
				user.setEstatus(i.getTUsuario().getEstatus()==null?"":i.getTUsuario().getEstatus());
				user.setId(i.getTUsuario().getId());
				user.setNivel(i.getTGrupo().getNombre());
				user.setNombre(nn+" "+ap+" "+am);
				user.setUltimoAcceso(dateTime.marshal(i.getTUsuario().getUltimo_Acceso()));
				
				
				
				if(!listaUsuarios.contains(user) && !user.getNivel().equals("ROOT"))
					listaUsuarios.add(user);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return listaUsuarios;
	}

}

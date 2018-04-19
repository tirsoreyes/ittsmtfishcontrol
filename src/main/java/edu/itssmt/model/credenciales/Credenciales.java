package edu.itssmt.model.credenciales;

import java.util.List;

public class Credenciales {
	
		private int id;
		private String apellido_Materno;
		private String apellido_Paterno;
		private String nombre;
		private String celular;
		private String email;
		private String estatus;
		private String pass;
		private String ultimo_Acceso;
		private String avatar;
		private List<EmpresaBean> listaEmpresas;
		private String nivel;
		private int idEmpresaActual;
		private String nombreEmpresaActual;
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getApellido_Materno() {
			return apellido_Materno;
		}
		public void setApellido_Materno(String apellido_Materno) {
			this.apellido_Materno = apellido_Materno;
		}
		public String getApellido_Paterno() {
			return apellido_Paterno;
		}
		public void setApellido_Paterno(String apellido_Paterno) {
			this.apellido_Paterno = apellido_Paterno;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getCelular() {
			return celular;
		}
		public void setCelular(String celular) {
			this.celular = celular;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getEstatus() {
			return estatus;
		}
		public void setEstatus(String estatus) {
			this.estatus = estatus;
		}
		public String getPass() {
			return pass;
		}
		public void setPass(String pass) {
			this.pass = pass;
		}
		public String getUltimo_Acceso() {
			return ultimo_Acceso;
		}
		public void setUltimo_Acceso(String ultimo_Acceso) {
			this.ultimo_Acceso = ultimo_Acceso;
		}
		public String getAvatar() {
			return avatar;
		}
		public void setAvatar(String avatar) {
			this.avatar = avatar;
		}
		public List<EmpresaBean> getListaEmpresas() {
			return listaEmpresas;
		}
		public void setListaEmpresas(List<EmpresaBean> listaEmpresas) {
			this.listaEmpresas = listaEmpresas;
		}
		public String getNivel() {
			return nivel;
		}
		public void setNivel(String nivel) {
			this.nivel = nivel;
		}
		public int getIdEmpresaActual() {
			return idEmpresaActual;
		}
		public void setIdEmpresaActual(int idEmpresaActual) {
			this.idEmpresaActual = idEmpresaActual;
		}
		public String getNombreEmpresaActual() {
			return nombreEmpresaActual;
		}
		public void setNombreEmpresaActual(String nombreEmpresaActual) {
			this.nombreEmpresaActual = nombreEmpresaActual;
		}
		
		
				
	
	

}

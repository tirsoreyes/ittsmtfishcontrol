package edu.itssmt.model;

public class MiCliente {
	
	private int id;
	private String nombre;
	private String celular;
	private String email;
	private String estatus;
	private String ultimoAcceso;
	private String nivel;
	
	
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getUltimoAcceso() {
		return ultimoAcceso;
	}
	public void setUltimoAcceso(String ultimoAcceso) {
		this.ultimoAcceso = ultimoAcceso;
	}
	
	
	
	

}

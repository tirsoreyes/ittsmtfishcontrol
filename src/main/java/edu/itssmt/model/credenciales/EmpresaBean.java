package edu.itssmt.model.credenciales;


public class EmpresaBean {
	
	private int id;
	private String fecha_Registro;
	private String nombre_Comercial;
	private String nombre_Fiscal;
	private String ubicacion;
	private int idGrupo;
	private String nivel;
	
	
	public int getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}
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
	public String getFecha_Registro() {
		return fecha_Registro;
	}
	public void setFecha_Registro(String fecha_Registro) {
		this.fecha_Registro = fecha_Registro;
	}
	public String getNombre_Comercial() {
		return nombre_Comercial;
	}
	public void setNombre_Comercial(String nombre_Comercial) {
		this.nombre_Comercial = nombre_Comercial;
	}
	public String getNombre_Fiscal() {
		return nombre_Fiscal;
	}
	public void setNombre_Fiscal(String nombre_Fiscal) {
		this.nombre_Fiscal = nombre_Fiscal;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
		

}

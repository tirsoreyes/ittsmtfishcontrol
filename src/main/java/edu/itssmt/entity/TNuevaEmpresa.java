package edu.itssmt.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;



/**
 * The persistent class for the t_empresa database table.
 * 
 */
@Entity
@Table(name="t_nueva_empresa")
@NamedQuery(name="TNuevaEmpresa.findAll", query="SELECT t FROM TNuevaEmpresa t")

public class TNuevaEmpresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="codigo_Postal")
	private String codigoPostal;
	private String colonia;	
	private String direccion;
	private String estado;
	private String municipio;
	private String ciudad;
	@Column(name="nombre_Comercial")
	private String nombreComercial;
	@Column(name="nombre_Fiscal")
	private String nombreFiscal;
	private int idCliente;
	private String nombreCliente;
	private String email;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_Solicitud")
	private Date fechaSolicitud;
	private String estatus;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_Activacion")
	private Date fechaActivacion;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getNombreComercial() {
		return nombreComercial;
	}
	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}
	public String getNombreFiscal() {
		return nombreFiscal;
	}
	public void setNombreFiscal(String nombreFiscal) {
		this.nombreFiscal = nombreFiscal;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}
	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public Date getFechaActivacion() {
		return fechaActivacion;
	}
	public void setFechaActivacion(Date fechaActivacion) {
		this.fechaActivacion = fechaActivacion;
	}
	
	
	
		
	

}
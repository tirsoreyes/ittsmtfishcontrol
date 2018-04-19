package edu.itssmt.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the t_empresa database table.
 * 
 */
@Entity
@Table(name="t_empresa")
@NamedQueries({
@NamedQuery(name="TEmpresa.findAll", query="SELECT t FROM TEmpresa t"),
@NamedQuery(name="TEmpresa.findByNombreComercial", query="SELECT t FROM TEmpresa t where t.nombreComercial =:nombreComercial")
})
public class TEmpresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String ciudad;
	@Column(name="codigo_Postal")
	private String codigoPostal;

	private String colonia;

	private String direccion;

	private String estado;

	private String estatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_Registro")
	private Date fechaRegistro;

	@Lob
	private byte[] logo;

	private String municipio;

	@Column(name="nombre_Comercial")
	private String nombreComercial;

	@Column(name="nombre_Fiscal")
	private String nombreFiscal;

	private String pais;

	private String ubicacion;

	//bi-directional many-to-one association to TCita
	@OneToMany(mappedBy="TEmpresa")
	private List<TCita> TCitas;

	//bi-directional many-to-one association to THorario
	@OneToMany(mappedBy="TEmpresa")
	
	private List<THorario> THorarios;

	//bi-directional many-to-one association to TPago
	@OneToMany(mappedBy="TEmpresa")
	private List<TPago> TPagos;

	//bi-directional many-to-one association to TUsuarioGrupoEmpresa
	@OneToMany(mappedBy="TEmpresa")
	private List<TUsuarioGrupoEmpresa> TUsuarioGrupoEmpresas;

	public TEmpresa() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCodigo_Postal() {
		return this.codigoPostal;
	}

	public void setCodigo_Postal(String codigo_Postal) {
		this.codigoPostal = codigo_Postal;
	}

	public String getColonia() {
		return this.colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstatus() {
		return this.estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Date getFecha_Registro() {
		return this.fechaRegistro;
	}

	public void setFecha_Registro(Date fecha_Registro) {
		this.fechaRegistro = fecha_Registro;
	}

	public byte[] getLogo() {
		return this.logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public String getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getNombre_Comercial() {
		return this.nombreComercial;
	}

	public void setNombre_Comercial(String nombre_Comercial) {
		this.nombreComercial = nombre_Comercial;
	}

	public String getNombre_Fiscal() {
		return this.nombreFiscal;
	}

	public void setNombre_Fiscal(String nombre_Fiscal) {
		this.nombreFiscal = nombre_Fiscal;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public List<TCita> getTCitas() {
		return this.TCitas;
	}

	public void setTCitas(List<TCita> TCitas) {
		this.TCitas = TCitas;
	}

	public TCita addTCita(TCita TCita) {
		getTCitas().add(TCita);
		TCita.setTEmpresa(this);

		return TCita;
	}

	public TCita removeTCita(TCita TCita) {
		getTCitas().remove(TCita);
		TCita.setTEmpresa(null);

		return TCita;
	}

	public List<THorario> getTHorarios() {
		return this.THorarios;
	}

	public void setTHorarios(List<THorario> THorarios) {
		this.THorarios = THorarios;
	}

	public THorario addTHorario(THorario THorario) {
		getTHorarios().add(THorario);
		THorario.setTEmpresa(this);

		return THorario;
	}

	public THorario removeTHorario(THorario THorario) {
		getTHorarios().remove(THorario);
		THorario.setTEmpresa(null);

		return THorario;
	}

	public List<TPago> getTPagos() {
		return this.TPagos;
	}

	public void setTPagos(List<TPago> TPagos) {
		this.TPagos = TPagos;
	}

	public TPago addTPago(TPago TPago) {
		getTPagos().add(TPago);
		TPago.setTEmpresa(this);

		return TPago;
	}

	public TPago removeTPago(TPago TPago) {
		getTPagos().remove(TPago);
		TPago.setTEmpresa(null);

		return TPago;
	}

	public List<TUsuarioGrupoEmpresa> getTUsuarioGrupoEmpresas() {
		return this.TUsuarioGrupoEmpresas;
	}

	public void setTUsuarioGrupoEmpresas(List<TUsuarioGrupoEmpresa> TUsuarioGrupoEmpresas) {
		this.TUsuarioGrupoEmpresas = TUsuarioGrupoEmpresas;
	}

	public TUsuarioGrupoEmpresa addTUsuarioGrupoEmpresa(TUsuarioGrupoEmpresa TUsuarioGrupoEmpresa) {
		getTUsuarioGrupoEmpresas().add(TUsuarioGrupoEmpresa);
		TUsuarioGrupoEmpresa.setTEmpresa(this);

		return TUsuarioGrupoEmpresa;
	}

	public TUsuarioGrupoEmpresa removeTUsuarioGrupoEmpresa(TUsuarioGrupoEmpresa TUsuarioGrupoEmpresa) {
		getTUsuarioGrupoEmpresas().remove(TUsuarioGrupoEmpresa);
		TUsuarioGrupoEmpresa.setTEmpresa(null);

		return TUsuarioGrupoEmpresa;
	}

}
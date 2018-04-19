package edu.itssmt.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the t_usuario database table.
 * 
 */
@Entity
@Table(name="t_usuario")
//@NamedQueries({
@NamedQuery(name="TUsuario.findAll", query="SELECT t FROM TUsuario t")
//@NamedQuery(name="TUsuario.findByEmail", query="SELECT t FROM TUsuario t where t.email =:email"),// verificar la sintaxis
//@NamedQuery(name="TUsuario.findByToken", query="SELECT t FROM TUsuario t where t.token =:token")
//})
public class TUsuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="Acceso_From")
	private String acceso_From;
	@Column(name="Apellido_Materno")
	private String apellido_Materno;
	@Column(name="Apellido_Paterno")
	private String apellido_Paterno;
	@Column(name="Celular")
	private String celular;
	@Column(name="email")
	private String email;
	@Column(name="Estatus")
	private String estatus;
	@Column(name="Nombre")
	private String nombre;
	@Column(name="Pass")
	private String pass;
	@Column(name="Token")
	private String token;
	@Column(name="Ultima_Ubicacion")
	private String ultima_Ubicacion;
	@Column(name="Ultimo_Acceso")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ultimo_Acceso;
	
	@Column(name="avatar")
	@Lob
	private byte[] avatar;
	

	public byte[] getAvatar() {
		return avatar;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

	//bi-directional many-to-one association to TBitacora
	@OneToMany(mappedBy="TUsuario")
	private List<TBitacora> TBitacoras;

	//bi-directional many-to-one association to TCita
	@OneToMany(mappedBy="TUsuario")
	private List<TCita> TCitas;

	//bi-directional many-to-one association to TUsuarioGrupoEmpresa
	@OneToMany(mappedBy="TUsuario")
	private List<TUsuarioGrupoEmpresa> TUsuarioGrupoEmpresas;

	public TUsuario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAcceso_From() {
		return this.acceso_From;
	}

	public void setAcceso_From(String acceso_From) {
		this.acceso_From = acceso_From;
	}

	public String getApellido_Materno() {
		return this.apellido_Materno;
	}

	public void setApellido_Materno(String apellido_Materno) {
		this.apellido_Materno = apellido_Materno;
	}

	public String getApellido_Paterno() {
		return this.apellido_Paterno;
	}

	public void setApellido_Paterno(String apellido_Paterno) {
		this.apellido_Paterno = apellido_Paterno;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstatus() {
		return this.estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUltima_Ubicacion() {
		return this.ultima_Ubicacion;
	}

	public void setUltima_Ubicacion(String ultima_Ubicacion) {
		this.ultima_Ubicacion = ultima_Ubicacion;
	}

	public Date getUltimo_Acceso() {
		return this.ultimo_Acceso;
	}

	public void setUltimo_Acceso(Date ultimo_Acceso) {
		this.ultimo_Acceso = ultimo_Acceso;
	}

	public List<TBitacora> getTBitacoras() {
		return this.TBitacoras;
	}

	public void setTBitacoras(List<TBitacora> TBitacoras) {
		this.TBitacoras = TBitacoras;
	}

	public TBitacora addTBitacora(TBitacora TBitacora) {
		getTBitacoras().add(TBitacora);
		TBitacora.setTUsuario(this);

		return TBitacora;
	}

	public TBitacora removeTBitacora(TBitacora TBitacora) {
		getTBitacoras().remove(TBitacora);
		TBitacora.setTUsuario(null);

		return TBitacora;
	}

	public List<TCita> getTCitas() {
		return this.TCitas;
	}

	public void setTCitas(List<TCita> TCitas) {
		this.TCitas = TCitas;
	}

	public TCita addTCita(TCita TCita) {
		getTCitas().add(TCita);
		TCita.setTUsuario(this);

		return TCita;
	}

	public TCita removeTCita(TCita TCita) {
		getTCitas().remove(TCita);
		TCita.setTUsuario(null);

		return TCita;
	}

	public List<TUsuarioGrupoEmpresa> getTUsuarioGrupoEmpresas() {
		return this.TUsuarioGrupoEmpresas;
	}

	public void setTUsuarioGrupoEmpresas(List<TUsuarioGrupoEmpresa> TUsuarioGrupoEmpresas) {
		this.TUsuarioGrupoEmpresas = TUsuarioGrupoEmpresas;
	}

	public TUsuarioGrupoEmpresa addTUsuarioGrupoEmpresa(TUsuarioGrupoEmpresa TUsuarioGrupoEmpresa) {
		getTUsuarioGrupoEmpresas().add(TUsuarioGrupoEmpresa);
		TUsuarioGrupoEmpresa.setTUsuario(this);

		return TUsuarioGrupoEmpresa;
	}

	public TUsuarioGrupoEmpresa removeTUsuarioGrupoEmpresa(TUsuarioGrupoEmpresa TUsuarioGrupoEmpresa) {
		getTUsuarioGrupoEmpresas().remove(TUsuarioGrupoEmpresa);
		TUsuarioGrupoEmpresa.setTUsuario(null);

		return TUsuarioGrupoEmpresa;
	}

}
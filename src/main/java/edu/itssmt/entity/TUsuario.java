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
@NamedQuery(name="TUsuario.findAll", query="SELECT t FROM TUsuario t")
public class TUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUsuario;

	private String apellidos;

	private String correo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_ultimo_acceso")
	private Date fechaUltimoAcceso;

	private String nombre;

	private String telefono;
	
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

	//bi-directional many-to-one association to TPedido
	@OneToMany(mappedBy="TUsuario")
	private List<TPedido> TPedidos;

	//bi-directional many-to-one association to TGrupo
	@ManyToOne
	@JoinColumn(name="t_grupo_idGrupo")
	private TGrupo TGrupo;

	public TUsuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaUltimoAcceso() {
		return this.fechaUltimoAcceso;
	}

	public void setFechaUltimoAcceso(Date fechaUltimoAcceso) {
		this.fechaUltimoAcceso = fechaUltimoAcceso;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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

	public List<TPedido> getTPedidos() {
		return this.TPedidos;
	}

	public void setTPedidos(List<TPedido> TPedidos) {
		this.TPedidos = TPedidos;
	}

	public TPedido addTPedido(TPedido TPedido) {
		getTPedidos().add(TPedido);
		TPedido.setTUsuario(this);

		return TPedido;
	}

	public TPedido removeTPedido(TPedido TPedido) {
		getTPedidos().remove(TPedido);
		TPedido.setTUsuario(null);

		return TPedido;
	}

	public TGrupo getTGrupo() {
		return this.TGrupo;
	}

	public void setTGrupo(TGrupo TGrupo) {
		this.TGrupo = TGrupo;
	}

}
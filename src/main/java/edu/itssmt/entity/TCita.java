package edu.itssmt.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the t_cita database table.
 * 
 */
@Entity
@Table(name="t_cita")
@NamedQuery(name="TCita.findAll", query="SELECT t FROM TCita t")
public class TCita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Lob
	private String comentarios;

	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_Cita")
	//@OrderColumn(name="fecha_Cita")
	private Date fechaCita;

	public Date getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}

	@Lob
	private String log;

	private double precio;

	private String status;

	//bi-directional many-to-one association to TBitacora
	@OneToMany(mappedBy="TCita")
	private List<TBitacora> TBitacoras;

	//bi-directional many-to-one association to TEmpresa
	@ManyToOne
	@JoinColumn(name="T_EMPRESA_Id")
	private TEmpresa TEmpresa;

	//bi-directional many-to-one association to THorario
	@ManyToOne
	@JoinColumn(name="T_HORARIO_Id")
	private THorario THorario;

	//bi-directional many-to-one association to TUsuario
	@ManyToOne
	@JoinColumn(name="T_USUARIO_Id")
	private TUsuario TUsuario;

	public TCita() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	public String getLog() {
		return this.log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<TBitacora> getTBitacoras() {
		return this.TBitacoras;
	}

	public void setTBitacoras(List<TBitacora> TBitacoras) {
		this.TBitacoras = TBitacoras;
	}

	public TBitacora addTBitacora(TBitacora TBitacora) {
		getTBitacoras().add(TBitacora);
		TBitacora.setTCita(this);

		return TBitacora;
	}

	public TBitacora removeTBitacora(TBitacora TBitacora) {
		getTBitacoras().remove(TBitacora);
		TBitacora.setTCita(null);

		return TBitacora;
	}

	public TEmpresa getTEmpresa() {
		return this.TEmpresa;
	}

	public void setTEmpresa(TEmpresa TEmpresa) {
		this.TEmpresa = TEmpresa;
	}

	public THorario getTHorario() {
		return this.THorario;
	}

	public void setTHorario(THorario THorario) {
		this.THorario = THorario;
	}

	public TUsuario getTUsuario() {
		return this.TUsuario;
	}

	public void setTUsuario(TUsuario TUsuario) {
		this.TUsuario = TUsuario;
	}

}
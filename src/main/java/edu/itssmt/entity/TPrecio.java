package edu.itssmt.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the t_precios database table.
 * 
 */
@Entity
@Table(name="t_precios")
@NamedQuery(name="TPrecio.findAll", query="SELECT t FROM TPrecio t")
public class TPrecio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPrecio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_vigencia")
	private Date fechaVigencia;

	private int idUsuario_creo;

	@Column(name="kilos_inferior")
	private int kilosInferior;

	@Column(name="kilos_superior")
	private int kilosSuperior;

	private BigDecimal precio;

	//bi-directional many-to-one association to TPedido
	@OneToMany(mappedBy="TPrecio")
	private List<TPedido> TPedidos;

	public TPrecio() {
	}

	public int getIdPrecio() {
		return this.idPrecio;
	}

	public void setIdPrecio(int idPrecio) {
		this.idPrecio = idPrecio;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaVigencia() {
		return this.fechaVigencia;
	}

	public void setFechaVigencia(Date fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}

	public int getIdUsuario_creo() {
		return this.idUsuario_creo;
	}

	public void setIdUsuario_creo(int idUsuario_creo) {
		this.idUsuario_creo = idUsuario_creo;
	}

	public int getKilosInferior() {
		return this.kilosInferior;
	}

	public void setKilosInferior(int kilosInferior) {
		this.kilosInferior = kilosInferior;
	}

	public int getKilosSuperior() {
		return this.kilosSuperior;
	}

	public void setKilosSuperior(int kilosSuperior) {
		this.kilosSuperior = kilosSuperior;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public List<TPedido> getTPedidos() {
		return this.TPedidos;
	}

	public void setTPedidos(List<TPedido> TPedidos) {
		this.TPedidos = TPedidos;
	}

	public TPedido addTPedido(TPedido TPedido) {
		getTPedidos().add(TPedido);
		TPedido.setTPrecio(this);

		return TPedido;
	}

	public TPedido removeTPedido(TPedido TPedido) {
		getTPedidos().remove(TPedido);
		TPedido.setTPrecio(null);

		return TPedido;
	}

}
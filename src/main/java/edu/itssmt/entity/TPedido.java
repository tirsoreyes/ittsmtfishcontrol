package edu.itssmt.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the t_pedido database table.
 * 
 */
@Entity
@Table(name="t_pedido")
@NamedQuery(name="TPedido.findAll", query="SELECT t FROM TPedido t")
public class TPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPedido;

	private String comentarios;

	private String estatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_entrega")
	private Date fechaEntrega;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_pedido")
	private Date fechaPedido;

	private int kilos;

	private BigDecimal monto;

	@Column(name="tipo_entrega")
	private String tipoEntrega;

	//bi-directional many-to-one association to TPrecio
	@ManyToOne
	@JoinColumn(name="t_precios_idPrecio")
	private TPrecio TPrecio;

	//bi-directional many-to-one association to TUsuario
	@ManyToOne
	@JoinColumn(name="t_usuario_idUsuario")
	private TUsuario TUsuario;

	public TPedido() {
	}

	public int getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getEstatus() {
		return this.estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Date getFechaEntrega() {
		return this.fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public Date getFechaPedido() {
		return this.fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public int getKilos() {
		return this.kilos;
	}

	public void setKilos(int kilos) {
		this.kilos = kilos;
	}

	public BigDecimal getMonto() {
		return this.monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public String getTipoEntrega() {
		return this.tipoEntrega;
	}

	public void setTipoEntrega(String tipoEntrega) {
		this.tipoEntrega = tipoEntrega;
	}

	public TPrecio getTPrecio() {
		return this.TPrecio;
	}

	public void setTPrecio(TPrecio TPrecio) {
		this.TPrecio = TPrecio;
	}

	public TUsuario getTUsuario() {
		return this.TUsuario;
	}

	public void setTUsuario(TUsuario TUsuario) {
		this.TUsuario = TUsuario;
	}

}
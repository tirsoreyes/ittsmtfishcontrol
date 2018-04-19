package edu.itssmt.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the t_pago database table.
 * 
 */
@Entity
@Table(name="t_pago")
@NamedQuery(name="TPago.findAll", query="SELECT t FROM TPago t")
public class TPago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha_Pago;

	private String metodo_Pago;

	private double monto_Pago;

	private int numero_Pago;

	private String tipo_Pago;

	//bi-directional many-to-one association to TEmpresa
	@ManyToOne
	@JoinColumn(name="T_EMPRESA_IdEmpresa")
	private TEmpresa TEmpresa;

	public TPago() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha_Pago() {
		return this.fecha_Pago;
	}

	public void setFecha_Pago(Date fecha_Pago) {
		this.fecha_Pago = fecha_Pago;
	}

	public String getMetodo_Pago() {
		return this.metodo_Pago;
	}

	public void setMetodo_Pago(String metodo_Pago) {
		this.metodo_Pago = metodo_Pago;
	}

	public double getMonto_Pago() {
		return this.monto_Pago;
	}

	public void setMonto_Pago(double monto_Pago) {
		this.monto_Pago = monto_Pago;
	}

	public int getNumero_Pago() {
		return this.numero_Pago;
	}

	public void setNumero_Pago(int numero_Pago) {
		this.numero_Pago = numero_Pago;
	}

	public String getTipo_Pago() {
		return this.tipo_Pago;
	}

	public void setTipo_Pago(String tipo_Pago) {
		this.tipo_Pago = tipo_Pago;
	}

	public TEmpresa getTEmpresa() {
		return this.TEmpresa;
	}

	public void setTEmpresa(TEmpresa TEmpresa) {
		this.TEmpresa = TEmpresa;
	}

}
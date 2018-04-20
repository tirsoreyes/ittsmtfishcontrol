package edu.itssmt.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_bitacora database table.
 * 
 */
@Entity
@Table(name="t_bitacora")
@NamedQuery(name="TBitacora.findAll", query="SELECT t FROM TBitacora t")
public class TBitacora implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBitacora;

	private String accion;

	private String fecha;

	private String nivel;

	//bi-directional many-to-one association to TUsuario
	@ManyToOne
	@JoinColumn(name="t_usuario_idUsuario")
	private TUsuario TUsuario;

	public TBitacora() {
	}

	public int getIdBitacora() {
		return this.idBitacora;
	}

	public void setIdBitacora(int idBitacora) {
		this.idBitacora = idBitacora;
	}

	public String getAccion() {
		return this.accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNivel() {
		return this.nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public TUsuario getTUsuario() {
		return this.TUsuario;
	}

	public void setTUsuario(TUsuario TUsuario) {
		this.TUsuario = TUsuario;
	}

}
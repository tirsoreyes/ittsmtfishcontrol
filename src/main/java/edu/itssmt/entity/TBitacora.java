package edu.itssmt.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


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
	private int id;

	private String evento;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	//bi-directional many-to-one association to TCita
	@ManyToOne
	@JoinColumn(name="T_CITA_Id")
	private TCita TCita;

	//bi-directional many-to-one association to TUsuario
	@ManyToOne
	@JoinColumn(name="T_USUARIO_Id")
	private TUsuario TUsuario;

	public TBitacora() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEvento() {
		return this.evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public TCita getTCita() {
		return this.TCita;
	}

	public void setTCita(TCita TCita) {
		this.TCita = TCita;
	}

	public TUsuario getTUsuario() {
		return this.TUsuario;
	}

	public void setTUsuario(TUsuario TUsuario) {
		this.TUsuario = TUsuario;
	}

}
package edu.itssmt.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.List;


/**
 * The persistent class for the t_horario database table.
 * 
 */
@Entity
@Table(name="t_horario")
@NamedQuery(name="THorario.findAll", query="SELECT t FROM THorario t")
public class THorario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String activo;

	private String dia;
	@OrderBy
	private Time hora;

	//bi-directional many-to-one association to TCita
	@OneToMany(mappedBy="THorario")
	private List<TCita> TCitas;

	//bi-directional many-to-one association to TEmpresa
	@ManyToOne
	@JoinColumn(name="T_EMPRESA_Id1")
	private TEmpresa TEmpresa;

	public THorario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getDia() {
		return this.dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Time getHora() {
		return this.hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public List<TCita> getTCitas() {
		return this.TCitas;
	}

	public void setTCitas(List<TCita> TCitas) {
		this.TCitas = TCitas;
	}

	public TCita addTCita(TCita TCita) {
		getTCitas().add(TCita);
		TCita.setTHorario(this);

		return TCita;
	}

	public TCita removeTCita(TCita TCita) {
		getTCitas().remove(TCita);
		TCita.setTHorario(null);

		return TCita;
	}

	public TEmpresa getTEmpresa() {
		return this.TEmpresa;
	}

	public void setTEmpresa(TEmpresa TEmpresa) {
		this.TEmpresa = TEmpresa;
	}

}
package edu.itssmt.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the t_grupo database table.
 * 
 */
@Entity
@Table(name="t_grupo")
@NamedQuery(name="TGrupo.findAll", query="SELECT t FROM TGrupo t")
public class TGrupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idGrupo;

	private String nombre;

	private String permisos;

	//bi-directional many-to-one association to TUsuario
	@OneToMany(mappedBy="TGrupo")
	private List<TUsuario> TUsuarios;

	public TGrupo() {
	}

	public int getIdGrupo() {
		return this.idGrupo;
	}

	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPermisos() {
		return this.permisos;
	}

	public void setPermisos(String permisos) {
		this.permisos = permisos;
	}

	public List<TUsuario> getTUsuarios() {
		return this.TUsuarios;
	}

	public void setTUsuarios(List<TUsuario> TUsuarios) {
		this.TUsuarios = TUsuarios;
	}

	public TUsuario addTUsuario(TUsuario TUsuario) {
		getTUsuarios().add(TUsuario);
		TUsuario.setTGrupo(this);

		return TUsuario;
	}

	public TUsuario removeTUsuario(TUsuario TUsuario) {
		getTUsuarios().remove(TUsuario);
		TUsuario.setTGrupo(null);

		return TUsuario;
	}

}
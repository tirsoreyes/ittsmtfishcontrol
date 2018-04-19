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
	private int id;

	private String descripcion;

	private String nombre;

	private String permiso;

	//bi-directional many-to-one association to TUsuarioGrupoEmpresa
	@OneToMany(mappedBy="TGrupo")
	private List<TUsuarioGrupoEmpresa> TUsuarioGrupoEmpresas;

	public TGrupo() {
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPermiso() {
		return this.permiso;
	}

	public void setPermiso(String permiso) {
		this.permiso = permiso;
	}

	public List<TUsuarioGrupoEmpresa> getTUsuarioGrupoEmpresas() {
		return this.TUsuarioGrupoEmpresas;
	}

	public void setTUsuarioGrupoEmpresas(List<TUsuarioGrupoEmpresa> TUsuarioGrupoEmpresas) {
		this.TUsuarioGrupoEmpresas = TUsuarioGrupoEmpresas;
	}

	public TUsuarioGrupoEmpresa addTUsuarioGrupoEmpresa(TUsuarioGrupoEmpresa TUsuarioGrupoEmpresa) {
		getTUsuarioGrupoEmpresas().add(TUsuarioGrupoEmpresa);
		TUsuarioGrupoEmpresa.setTGrupo(this);

		return TUsuarioGrupoEmpresa;
	}

	public TUsuarioGrupoEmpresa removeTUsuarioGrupoEmpresa(TUsuarioGrupoEmpresa TUsuarioGrupoEmpresa) {
		getTUsuarioGrupoEmpresas().remove(TUsuarioGrupoEmpresa);
		TUsuarioGrupoEmpresa.setTGrupo(null);

		return TUsuarioGrupoEmpresa;
	}

}
package edu.itssmt.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the t_usuario_grupo_empresa database table.
 * 
 */
@Embeddable
public class TUsuarioGrupoEmpresaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=true, updatable=true)
	private int t_EMPRESA_Id;

	@Column(insertable=true, updatable=true)
	private int t_USUARIO_Id;

	@Column(insertable=true, updatable=true)
	private int t_GRUPO_Id;
	
	

	public TUsuarioGrupoEmpresaPK() {
	}
	public int getT_EMPRESA_Id() {
		return this.t_EMPRESA_Id;
	}
	public void setT_EMPRESA_Id(int t_EMPRESA_Id) {
		this.t_EMPRESA_Id = t_EMPRESA_Id;
	}
	public int getT_USUARIO_Id() {
		return this.t_USUARIO_Id;
	}
	public void setT_USUARIO_Id(int t_USUARIO_Id) {
		this.t_USUARIO_Id = t_USUARIO_Id;
	}
	public int getT_GRUPO_Id() {
		return this.t_GRUPO_Id;
	}
	public void setT_GRUPO_Id(int t_GRUPO_Id) {
		this.t_GRUPO_Id = t_GRUPO_Id;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TUsuarioGrupoEmpresaPK)) {
			return false;
		}
		TUsuarioGrupoEmpresaPK castOther = (TUsuarioGrupoEmpresaPK)other;
		return 
			(this.t_EMPRESA_Id == castOther.t_EMPRESA_Id)
			&& (this.t_USUARIO_Id == castOther.t_USUARIO_Id)
			&& (this.t_GRUPO_Id == castOther.t_GRUPO_Id);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.t_EMPRESA_Id;
		hash = hash * prime + this.t_USUARIO_Id;
		hash = hash * prime + this.t_GRUPO_Id;
		
		return hash;
	}
}
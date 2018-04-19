package edu.itssmt.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_usuario_grupo_empresa database table.
 * 
 */
@Entity
@Table(name="t_usuario_grupo_empresa")
@NamedQuery(name="TUsuarioGrupoEmpresa.findAll", query="SELECT t FROM TUsuarioGrupoEmpresa t")
public class TUsuarioGrupoEmpresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TUsuarioGrupoEmpresaPK id;

	//bi-directional many-to-one association to TEmpresa
	@ManyToOne
	@JoinColumn(name="T_EMPRESA_Id")
	private TEmpresa TEmpresa;

	//bi-directional many-to-one association to TGrupo
	@ManyToOne
	@JoinColumn(name="T_GRUPO_Id")
	private TGrupo TGrupo;

	//bi-directional many-to-one association to TUsuario
	@ManyToOne
	@JoinColumn(name="T_USUARIO_Id")
	private TUsuario TUsuario;

	public TUsuarioGrupoEmpresa() {
	}

	public TUsuarioGrupoEmpresaPK getId() {
		return this.id;
	}

	public void setId(TUsuarioGrupoEmpresaPK id) {
		this.id = id;
	}

	public TEmpresa getTEmpresa() {
		return this.TEmpresa;
	}

	public void setTEmpresa(TEmpresa TEmpresa) {
		this.TEmpresa = TEmpresa;
	}

	public TGrupo getTGrupo() {
		return this.TGrupo;
	}

	public void setTGrupo(TGrupo TGrupo) {
		this.TGrupo = TGrupo;
	}

	public TUsuario getTUsuario() {
		return this.TUsuario;
	}

	public void setTUsuario(TUsuario TUsuario) {
		this.TUsuario = TUsuario;
	}

}
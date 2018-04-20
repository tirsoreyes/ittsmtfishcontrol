package edu.itssmt.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_nosotros database table.
 * 
 */
@Entity
@Table(name="t_nosotros")
@NamedQuery(name="TNosotro.findAll", query="SELECT t FROM TNosotro t")
public class TNosotro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idNosotros;

	private String contenido;

	@Column(name="fecha_ultimo_acceso")
	private String fechaUltimoAcceso;

	private String mapa;

	private String titulo;

	public TNosotro() {
	}

	public int getIdNosotros() {
		return this.idNosotros;
	}

	public void setIdNosotros(int idNosotros) {
		this.idNosotros = idNosotros;
	}

	public String getContenido() {
		return this.contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getFechaUltimoAcceso() {
		return this.fechaUltimoAcceso;
	}

	public void setFechaUltimoAcceso(String fechaUltimoAcceso) {
		this.fechaUltimoAcceso = fechaUltimoAcceso;
	}

	public String getMapa() {
		return this.mapa;
	}

	public void setMapa(String mapa) {
		this.mapa = mapa;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
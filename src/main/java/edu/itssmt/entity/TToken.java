package edu.itssmt.entity;

import java.io.Serializable;
import javax.persistence.*;


import java.util.Date;


/**
 * The persistent class for the T_TOKEN database table.
 * 
 */
@Entity
@Table(name="t_token")
@NamedQuery(name="TToken.findAll", query="SELECT r FROM TToken r")
public class TToken implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idToken")
	private int idToken;

	@Column(name="token")
	private String token;
	
	@Column(name="fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name="status")
	private String status;



	
	
	public int getIdToken() {
		return idToken;
	}

	public void setIdToken(int idToken) {
		this.idToken = idToken;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	

}
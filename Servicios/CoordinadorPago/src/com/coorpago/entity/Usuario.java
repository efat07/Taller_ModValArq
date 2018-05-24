package com.coorpago.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Usuario implements Serializable {

	private static final long serialVersionUID = -7650122452966806692L;
	private Integer idUsuario;
	
	public Usuario() {}
	
	public Usuario(Integer idUsuario, String mensaje) {
		this.idUsuario = idUsuario;
	}
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
}

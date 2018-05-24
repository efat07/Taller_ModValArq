package com.usuario.entity;

public class Usuario {

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

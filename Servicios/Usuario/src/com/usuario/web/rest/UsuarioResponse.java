package com.usuario.web.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UsuarioResponse {

	private Integer idUsuario;
    private String mensaje;
    
    public UsuarioResponse() {}
    
    public UsuarioResponse(Integer idUsuario, String mensaje) {
        this.idUsuario = idUsuario;
        this.mensaje = mensaje;
    }
    
    public Integer getidUsuario() {
        return idUsuario;
    }
    public void setidUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
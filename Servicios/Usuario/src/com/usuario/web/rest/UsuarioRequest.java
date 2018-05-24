package com.usuario.web.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UsuarioRequest{

	private Integer idUsuario;
    private String mensaje;
    
    public UsuarioRequest() {}
    
    public UsuarioRequest(Integer idUsuario, String mensaje) {
        this.idUsuario = idUsuario;
        this.mensaje = mensaje;
    }
    
    public Integer getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
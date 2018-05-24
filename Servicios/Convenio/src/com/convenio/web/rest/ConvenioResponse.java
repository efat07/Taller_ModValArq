package com.convenio.web.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ConvenioResponse{

	private Integer idConvenio;
	private String nombreConvenio;
	private String mensaje;
    
    public ConvenioResponse() {}
    
    public ConvenioResponse(Integer idConvenio, String nombreConvenio, String mensaje) {
        this.idConvenio = idConvenio;
        this.nombreConvenio = nombreConvenio;
        this.mensaje = mensaje;
    }

	public Integer getIdConvenio() {
		return idConvenio;
	}

	public void setIdConvenio(Integer idConvenio) {
		this.idConvenio = idConvenio;
	}

	public String getNombreConvenio() {
		return nombreConvenio;
	}

	public void setNombreConvenio(String nombreConvenio) {
		this.nombreConvenio = nombreConvenio;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
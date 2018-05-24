package com.convenio.web.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ConvenioRequest {

	private Integer idConvenio;
	private String nombreConvenio;
	
	public ConvenioRequest() {}
	
	public ConvenioRequest(Integer idConvenio, String nombreConvenio) {
		this.idConvenio = idConvenio;
		this.nombreConvenio = nombreConvenio;
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
}

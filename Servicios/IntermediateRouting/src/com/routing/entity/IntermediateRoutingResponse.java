package com.routing.entity;

public class IntermediateRoutingResponse {

	private Integer idConvenio;
	private String nombre;
	private String url;
	private Integer codError;
	
	public IntermediateRoutingResponse() {} 
	
	public IntermediateRoutingResponse(Integer idConvenio, String nombre, String url, Integer codError) {
		this.idConvenio = idConvenio;
		this.nombre = nombre;
	    this.url = url;
	    this.codError = codError;
	}
	
	public String getNombre() {
	    return nombre;
	}
	public void setNombre(String nombre) {
	    this.nombre = nombre;
	}
	public String getUrl() {
	    return url;
	}
	public void setUrl(String url) {
	    this.url = url;
	}
	
	public Integer getIdConvenio() {
		return idConvenio;
	}
	
	public void setIdConvenio(Integer idConvenio) {
		this.idConvenio = idConvenio;
	}
	
	public Integer getCodError() {
		return codError;
	}
	
	public void setCodError(Integer codError) {
		this.codError = codError;
	}

}

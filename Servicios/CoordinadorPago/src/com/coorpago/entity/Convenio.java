package com.coorpago.entity;

public class Convenio {
	private Integer idConvenio = null;
	private String nombreConvenio = null;
	public Convenio() {
	}
	public Convenio(Integer i, String string) {
		this.idConvenio = i;
		this.nombreConvenio = string;
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
	public void setNombreConvenio(String nombreCOnvenio) {
		this.nombreConvenio = nombreCOnvenio;
	}
}

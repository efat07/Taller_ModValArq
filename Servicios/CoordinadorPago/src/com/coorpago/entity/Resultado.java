package com.coorpago.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Resultado implements Serializable{

	private static final long serialVersionUID = -3074467092924742519L;
	private Integer idConvenio;
	private String nombreConvenio;
	private Integer idUsuario;
	private Integer idMedioPago;
	private String nombreMedioPago;
	private String url;	
	private String mensaje;
	private Integer codError;
	private double valorPago;
    
    public Resultado() {}
    
    public Resultado(Integer idConvenio, String nombreConvenio, String mensaje) {
        this.idConvenio = idConvenio;
        this.nombreConvenio = nombreConvenio;
        this.setMensaje(mensaje);
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

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdMedioPago() {
		return idMedioPago;
	}

	public void setIdMedioPago(Integer idMedioPago) {
		this.idMedioPago = idMedioPago;
	}

	public String getNombreMedioPago() {
		return nombreMedioPago;
	}

	public void setNombreMedioPago(String nombreMedioPago) {
		this.nombreMedioPago = nombreMedioPago;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getCodError() {
		return codError;
	}

	public void setCodError(Integer codError) {
		this.codError = codError;
	}

	public double getValorPago() {
		return valorPago;
	}

	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}
}
package com.coorpago.web.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CoordinadorPagoResponse {

	private Integer idFacturaPago;
	private String nombreConvenio;
	private String nombreMedioPago;
	private double valorPago;
	private String mensaje;
	
	public CoordinadorPagoResponse() {}
	
	public CoordinadorPagoResponse(Integer idFacturaPago, String nombreConvenio, 
			String nombreMedioPago, double valorPago, String mensaje) {
		this.idFacturaPago = idFacturaPago;
		this.nombreConvenio =nombreConvenio;
		this.nombreMedioPago = nombreMedioPago;
		this.valorPago = valorPago;
		this.mensaje = mensaje;
	}
	
	public Integer getIdFacturaPago() {
		return idFacturaPago;
	}
	public void setIdFacturaPago(Integer idFacturaPago) {
		this.idFacturaPago = idFacturaPago;
	}
	public String getNombreConvenio() {
		return nombreConvenio;
	}
	public void setNombreConvenio(String nombreConvenio) {
		this.nombreConvenio = nombreConvenio;
	}
	public String getNombreMedioPago() {
		return nombreMedioPago;
	}
	public void setNombreMedioPago(String nombreMedioPago) {
		this.nombreMedioPago = nombreMedioPago;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public double getValorPago() {
		return valorPago;
	}

	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}
	
	
}

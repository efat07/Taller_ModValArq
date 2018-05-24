package com.coorpago.web.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CoordinadorPagoRequest {

	private Integer idUsuario;
	private Integer idConvenio;
	private Integer idFacturaPago;
	private Integer idMedioPago;
	
	public CoordinadorPagoRequest() {}
	
	public CoordinadorPagoRequest(Integer idUsuario, Integer idConvenio, Integer idMedioPago, Integer idFacturaPago) {
		this.idUsuario = idUsuario;
		this.idConvenio = idConvenio;
		this.idFacturaPago = idFacturaPago;
		this.idMedioPago = idMedioPago;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdConvenio() {
		return idConvenio;
	}

	public void setIdConvenio(Integer idConvenio) {
		this.idConvenio = idConvenio;
	}

	public Integer getIdFacturaPago() {
		return idFacturaPago;
	}

	public void setIdFacturaPago(Integer idFacturaPago) {
		this.idFacturaPago = idFacturaPago;
	}

	public Integer getIdMedioPago() {
		return idMedioPago;
	}

	public void setIdMedioPago(Integer idMedioPago) {
		this.idMedioPago = idMedioPago;
	}
}

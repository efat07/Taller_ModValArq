package com.mediopago.web.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MedioPagoRequest{

	private Integer idMedioPago;
	
	public MedioPagoRequest() {}
	
	public MedioPagoRequest(Integer idMedioPago) {
		this.setIdMedioPago(idMedioPago);
	}

	public Integer getIdMedioPago() {
		return idMedioPago;
	}

	public void setIdMedioPago(Integer idMedioPago) {
		this.idMedioPago = idMedioPago;
	}
}

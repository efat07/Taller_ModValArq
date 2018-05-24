package com.coorpago.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MedioPago{

	private Integer idMedioPago;
	private String nombreMedioPago;
	
	public MedioPago() {}
	
	public MedioPago(Integer idMedioPago, String nombreMedioPago) {
		this.setIdMedioPago(idMedioPago);
		this.setNombreMedioPago(nombreMedioPago);
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
}

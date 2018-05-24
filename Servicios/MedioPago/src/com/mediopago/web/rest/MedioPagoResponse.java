package com.mediopago.web.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MedioPagoResponse{

	private Integer idMedioPago;
	private String nombreMedioPago;
    private String mensaje;
    
    public MedioPagoResponse() {}
    
    public MedioPagoResponse(Integer idMedioPago, String nombreMedioPago, String mensaje) {
        this.setIdMedioPago(idMedioPago);
        this.nombreMedioPago = nombreMedioPago;
        this.mensaje = mensaje;
    }
    
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
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
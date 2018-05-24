package com.coorpago.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Factura{

	private Integer idUsuario;
	private Integer idConvenio;
	private Integer idFacturaPago;
	private Integer idMedioPago;
	private String mensaje;
	
	public Factura() {}
	
	public Factura(Integer idUsuario, Integer idConvenio, String mensaje, Integer idMedioPago, Integer idFacturaPago) {
		this.idUsuario = idUsuario;
		this.idConvenio = idConvenio;
		this.idFacturaPago = idFacturaPago;
		this.idMedioPago = idMedioPago;
		this.mensaje = mensaje;
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

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
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

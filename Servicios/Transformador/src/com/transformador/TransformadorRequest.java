package com.transformador;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TransformadorRequest {

    private int idFactura;
    private double valorFactura;
    private Integer idFacturaPago;
    private double valorPago;
    private String mensaje;
    
    
    public TransformadorRequest() {
    }

    public TransformadorRequest(double valorFactura) {
        this.valorFactura = valorFactura;
    }

    public TransformadorRequest(int idFactura, double valorFactura) {
        this.idFactura = idFactura;
        this.valorFactura = valorFactura;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public double getValorFactura() {
        return valorFactura;
    }

    public void setValorFactura(double valorFactura) {
        this.valorFactura = valorFactura;
    }

	public Integer getIdFacturaPago() {
		return idFacturaPago;
	}

	public void setIdFacturaPago(Integer idFacturaPago) {
		this.idFacturaPago = idFacturaPago;
	}

	public double getValorPago() {
		return valorPago;
	}

	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
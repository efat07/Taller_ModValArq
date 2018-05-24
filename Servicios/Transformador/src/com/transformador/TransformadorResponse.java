package com.transformador;

public class TransformadorResponse {
	private int idFactura;
    private double valorFactura;
    private Integer idFacturaPago;
    private double valorPago;
    private String mensaje;
    
    public TransformadorResponse() {
    }

    public TransformadorResponse(double valorFactura) {
        this.valorFactura = valorFactura;
    }

    public TransformadorResponse(int idFactura, double valorFactura) {
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

}/*
	private Integer idConvenio;
	private String nombre;
	private String url;
	private Integer codError;
	
	public TransformadorResponse() {} 
	
	public TransformadorResponse(Integer idConvenio, String nombre, String url, Integer codError) {
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

}*/

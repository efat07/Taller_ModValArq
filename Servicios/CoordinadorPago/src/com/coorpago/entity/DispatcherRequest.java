package com.coorpago.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DispatcherRequest {
	
	private Integer idFacturaPago;
    private String url;
    
    public DispatcherRequest() {} 
    
	public DispatcherRequest(Integer idFacturaPago, String url) {
        this.idFacturaPago = idFacturaPago;
        this.url = url;
    }

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getIdFacturaPago() {
		return idFacturaPago;
	}

	public void setIdFacturaPago(Integer idFacturaPago) {
		this.idFacturaPago = idFacturaPago;
	}

	
}

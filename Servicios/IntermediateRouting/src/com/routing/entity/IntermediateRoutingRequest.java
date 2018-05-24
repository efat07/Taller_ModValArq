package com.routing.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class IntermediateRoutingRequest {
	
    private Integer idConvenio;
    
    public IntermediateRoutingRequest() {} 
    
	public IntermediateRoutingRequest(Integer idConvenio) {
        this.idConvenio = idConvenio;
    }
	
   public Integer getIdConvenio() {
		return idConvenio;
	}

	public void setIdConvenio(Integer idConvenio) {
		this.idConvenio = idConvenio;
	}
}

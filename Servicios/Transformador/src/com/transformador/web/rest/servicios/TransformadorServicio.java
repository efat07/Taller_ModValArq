package com.transformador.web.rest.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.transformador.TransformadorRequest;
import com.transformador.TransformadorResponse;

@Path("transformador")
public class TransformadorServicio {

	public TransformadorServicio() {
	}
	
	@POST
    @Path("consultavalor")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TransformadorResponse transformarPagoEntrada(TransformadorRequest transformadorRequest) {
		TransformadorResponse transformadorResponse = new TransformadorResponse();
		transformadorResponse.setValorPago(transformadorRequest.getValorFactura());
        return transformadorResponse;
    }
	
	@POST
    @Path("pagarvalorida")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TransformadorResponse transformarPagarValorOut(TransformadorRequest transformadorRequest) {
		TransformadorResponse transformadorResponse = new TransformadorResponse();
		transformadorResponse.setIdFactura(transformadorRequest.getIdFacturaPago());
        return transformadorResponse;
    }
	
	@POST
    @Path("pagarvalorregreso")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TransformadorResponse transformarPagarValorIn(TransformadorRequest transformadorRequest) {
		TransformadorResponse transformadorResponse = new TransformadorResponse();
		transformadorResponse.setIdFacturaPago(transformadorRequest.getIdFactura());
		transformadorResponse.setMensaje(transformadorRequest.getMensaje());
        return transformadorResponse;
    }
}
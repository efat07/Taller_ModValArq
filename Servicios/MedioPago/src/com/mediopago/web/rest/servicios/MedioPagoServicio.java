package com.mediopago.web.rest.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mediopago.entity.MedioPago;
import com.mediopago.web.rest.MedioPagoRequest;
import com.mediopago.web.rest.MedioPagoResponse;

@Path("mediopago")
public class MedioPagoServicio {

	public static List<MedioPago> medioPagos= null;
	
	public MedioPagoServicio() {
		inicializarUsuarios();
	}
	
	@POST
    @Path("seleccionar")
    @Produces(MediaType.APPLICATION_JSON)
    public MedioPagoResponse validarUsuario(MedioPagoRequest medioPagoRequest) {
		MedioPagoResponse medioPagoResponse = new MedioPagoResponse();
		medioPagoResponse.setMensaje("KO");
		if (medioPagoRequest.getIdMedioPago() != null) {
			medioPagoResponse.setIdMedioPago(medioPagoRequest.getIdMedioPago());
			if(medioPagos != null && !medioPagos.isEmpty()) {
	        	for (MedioPago medioPago : medioPagos) {
					if(medioPago.getIdMedioPago().equals(medioPagoRequest.getIdMedioPago())) {
						medioPagoResponse.setMensaje("OK");
						medioPagoResponse.setNombreMedioPago(medioPago.getNombreMedioPago());
					}
				}
	        }
		}
        return medioPagoResponse;
    }
	
	private void inicializarUsuarios() {
		//Simula la base de datos, carga una lista de id de usuarios para luego validar si el usuario existe
		if (medioPagos == null) {
			medioPagos = new ArrayList<MedioPago>();
            
			medioPagos.add(new MedioPago(1, "PSE"));
			medioPagos.add(new MedioPago(2, "PayPal"));
			medioPagos.add(new MedioPago(3, "PayU"));
        }
	}
}

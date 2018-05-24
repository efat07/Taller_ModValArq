package com.routing.web.rest.servicios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.routing.entity.IntermediateRoutingResponse;

@Path("routing")
public class RoutingServicio {

	List<RoutingServicio> routingServicios = null;
	
	public RoutingServicio() {
		//inicializarRoutings();
	}
	
	@GET
    @Path("{idConvenio}")
    @Produces(MediaType.APPLICATION_JSON)
    public IntermediateRoutingResponse consultarServicio(@PathParam("idConvenio")  Integer idConvenio) {
		
		/*IntermediateRouting intermediateRouting = new IntermediateRouting();
		if (idConvenio != null) {
			intermediateRouting.setIdConvenio(idConvenio);
			
			if(convenios != null && !convenios.isEmpty()) {
	        	for (Convenio convenio : convenios) {
					if(convenio.getIdConvenio().equals(convenioIn.getIdConvenio())) {
						resultado.setMensaje("OK");
						resultado.setNombreConvenio(convenio.getNombreConvenio());
					}
				}
	        }
		}
        return resultado;*/
		
		IntermediateRoutingResponse intermediateRouting = new IntermediateRoutingResponse();
		intermediateRouting = consultarConvenioRouting(idConvenio);
        return intermediateRouting;
    }
	
	private IntermediateRoutingResponse consultarConvenioRouting(Integer idConvenio) {
		IntermediateRoutingResponse intermediateRoutingResponse = new IntermediateRoutingResponse();
		intermediateRoutingResponse.setCodError(1);
		InputStream inputProp = null;
		try {
			 Properties p = new Properties();

			//Properties p = new Properties();
			//InputStream inputStream = this.getClass().getClassLoader()
	         //       .getResourceAsStream("IntermediateRouting/inventarioServicios.properties");
			//FileReader fileReader = new FileReader(inputStream);
			
			//p.load(inputStream);}
		        
		        
		        
	        inputProp = RoutingServicio.class.getClassLoader().getResourceAsStream("com/routing/prop/inventarioServicios.properties");
	        p.load(inputProp);    
	        
	        intermediateRoutingResponse.setIdConvenio(idConvenio);
			intermediateRoutingResponse.setUrl(p.getProperty(String.valueOf(idConvenio)));
			intermediateRoutingResponse.setCodError(0);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return intermediateRoutingResponse;
	}
	
	/*public static void main(String[] args) {
		IntermediateRouting intermediateRouting = new IntermediateRouting();
		intermediateRouting = consultarConvenioRouting(1);
		System.out.println(intermediateRouting.getUrl());
	}*/
	
	/*private IntermediateRouting consultarConvenioRouting(Integer idConvenio) {
		IntermediateRouting intermediateRouting = null;
		try {
			Properties p = new Properties();
			InputStream inputStream = this.getClass().getClassLoader()
	                .getResourceAsStream("IntermediateRouting/inventarioServicios.properties");
			//FileReader fileReader = new FileReader(inputStream);
			
			p.load(inputStream);
			intermediateRouting = new IntermediateRouting();
			intermediateRouting.setIdConvenio(idConvenio);
			intermediateRouting.setUrl(p.getProperty(String.valueOf(idConvenio)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return intermediateRouting;
	}*/
	
	/*private void inicializarRoutings() {
		//Simula la base de datos, carga una lista de id de convenios para luego validar si el convenio existe y retornar el codigo de referencia de pago
		if (routingServicios == null) {
			routingServicios = new ArrayList<RoutingServicio>();
			routingServicios.add(new Convenio(1, "Agua"));
			routingServicios.add(new Convenio(2, "Gas"));
			routingServicios.add(new Convenio(3, "Luz"));
			routingServicios.add(new Convenio(4, "Telefonía"));
        }
	}*/
}

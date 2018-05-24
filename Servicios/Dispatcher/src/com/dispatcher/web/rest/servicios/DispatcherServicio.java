package com.dispatcher.web.rest.servicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dispatcher.Factura;
import com.dispatcher.web.rest.DispatcherRequest;
import com.dispatcher.web.rest.DispatcherResponse;
import com.google.gson.Gson;

@Path("dispatcher")
public class DispatcherServicio {

	private static final String URI_TRANSFORMADOR_VAL_FAC_RTA =    "http://localhost:8080/Transformador/servicios/transformador/consultavalor";
	private static final String URI_TRANSFORMADOR_PAG_VAL_IDA =    "http://localhost:8080/Transformador/servicios/transformador/pagarvalorida";
	private static final String URI_TRANSFORMADOR_PAG_VAL_REGRESO =    "http://localhost:8080/Transformador/servicios/transformador/pagarvalorregreso";
	
	public DispatcherServicio() {
	}
	
	@POST
    @Path("infofactura")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public DispatcherResponse consultaValorFactura(DispatcherRequest dispatcherRequest) {
		DispatcherResponse dispatcherResponse = new DispatcherResponse();
		Client clienteDispatcher = ClientBuilder.newClient();
		Response responseDispatcher = clienteDispatcher.target(dispatcherRequest.getUrl()+"/"+dispatcherRequest.getIdFacturaPago()).request().get();
	    if(responseDispatcher.getStatus() == 200) {
	    	Factura factura = responseDispatcher.readEntity(Factura.class);
	    	Client clienteTransformadorRta = ClientBuilder.newClient();
	    	
	    	/*try {
	    		URL targetUrl = new URL(URI_TRANSFORMADOR_VAL_FAC_RTA);
	            HttpURLConnection httpConnection = (HttpURLConnection) targetUrl.openConnection();
	            httpConnection.setDoOutput(true);
	            httpConnection.setRequestMethod("POST");
	            httpConnection.setRequestProperty("Content-Type", "application/json");
		    	Gson gson = new Gson();
	            String input = gson.toJson(factura);
	            OutputStream outputStream = httpConnection.getOutputStream();
	            outputStream.write(input.getBytes());
	            outputStream.flush();
	            //valida rta envio peticion
	            if (httpConnection.getResponseCode() != 200) {
	                throw new RuntimeException("Failed : HTTP error code: "    + httpConnection.getResponseCode());
	            }
	            BufferedReader responseBuffer2 = new BufferedReader(new InputStreamReader((httpConnection.getInputStream())));
	            String output2;
	            output2=responseBuffer2.readLine();
	            //returnList=output2;
	            
	            httpConnection.disconnect();
	            dispatcherResponse = gson.fromJson(output2, DispatcherResponse.class);
			} catch ( IOException e) {
				e.printStackTrace();
			}*/
	    	
			Response responseTransformadorRta = clienteTransformadorRta.target(URI_TRANSFORMADOR_VAL_FAC_RTA).request().post(Entity.entity(factura, MediaType.APPLICATION_JSON_TYPE));
			dispatcherResponse = responseTransformadorRta.readEntity(DispatcherResponse.class);
			return dispatcherResponse;
	    }
		return dispatcherResponse;
	}
	
	@POST
    @Path("pagofactura")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public DispatcherResponse pagarFactura(DispatcherRequest dispatcherRequest) {
		DispatcherResponse dispatcherResponse = new DispatcherResponse();
		
		Client clienteTransformaIda = ClientBuilder.newClient();
		Response responseTransformadorIda = clienteTransformaIda.target(URI_TRANSFORMADOR_PAG_VAL_IDA).request().post(Entity.entity(dispatcherRequest, MediaType.APPLICATION_JSON_TYPE));
		dispatcherResponse = responseTransformadorIda.readEntity(DispatcherResponse.class);
				
		Client clienteDispatcher = ClientBuilder.newClient();
		Response responseDispatcher = clienteDispatcher.target(dispatcherRequest.getUrl()+"/"+dispatcherRequest.getIdFacturaPago()).request().post(Entity.entity(dispatcherResponse, MediaType.APPLICATION_JSON_TYPE));
	    
		
		if(responseDispatcher.getStatus() == 200) {
			DispatcherResponse dispatcherResponseFactura = responseDispatcher.readEntity(DispatcherResponse.class);
	    	Client clienteTransformadorRta = ClientBuilder.newClient();
	    	Response responseTransformadorRta = clienteTransformadorRta.target(URI_TRANSFORMADOR_PAG_VAL_REGRESO).request().post(Entity.entity(dispatcherResponseFactura, MediaType.APPLICATION_JSON_TYPE));
			dispatcherResponse = responseTransformadorRta.readEntity(DispatcherResponse.class);
			return dispatcherResponse;
	    }
		return dispatcherResponse;
	}
}

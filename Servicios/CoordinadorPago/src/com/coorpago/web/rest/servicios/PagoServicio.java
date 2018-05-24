package com.coorpago.web.rest.servicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
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

import com.coorpago.entity.Convenio;
import com.coorpago.entity.DispatcherRequest;
import com.coorpago.entity.MedioPago;
import com.coorpago.entity.Resultado;
import com.coorpago.entity.Usuario;
import com.coorpago.utils.Constante;
import com.coorpago.web.rest.CoordinadorPagoRequest;
import com.coorpago.web.rest.CoordinadorPagoResponse;
//import com.dispatcher.web.rest.DispatcherResponse;
import com.google.gson.Gson;

@Path("pagos")
public class PagoServicio {
		
	/*private static final String URI_USUARIO_VALIDAR =    "http://localhost:8083/Usuario/servicios/usuarios/validar";
	private static final String URI_CONVENIO_VALIDAR =   "http://localhost:8084/Convenio/servicios/convenios/seleccionar";
	private static final String URI_MEDIO_PAGO_VALIDAR = "http://localhost:8085/MedioPago/servicios/mediopago/seleccionar";
	private static final String URI_ROUTING =            "http://localhost:8086/IntermediateRouting/servicios/routing";
	private static final String URI_DISPATCHER =         "http://localhost:8087/Dispatcher/servicios/dispatcher/infofactura";
	*/
	
	private static final String URI_USUARIO_VALIDAR =    "http://localhost:8080/Usuario/servicios/usuarios/validar";
	private static final String URI_CONVENIO_VALIDAR =   "http://localhost:8080/Convenio/servicios/convenios/seleccionar";
	private static final String URI_MEDIO_PAGO_VALIDAR = "http://localhost:8080/MedioPago/servicios/mediopago/seleccionar";
	private static final String URI_ROUTING =            "http://localhost:8080/IntermediateRouting/servicios/routing";
	private static final String URI_DISPATCHER =         "http://localhost:8080/Dispatcher/servicios/dispatcher/infofactura";
	private static final String URI_DISPATCHER_P =         "http://localhost:8080/Dispatcher/servicios/dispatcher/pagofactura";
	
	public PagoServicio() {
	}
	
	@POST
    @Path("pagarfactura")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CoordinadorPagoResponse pagar(CoordinadorPagoRequest coordinadorPagoRequest) {
		CoordinadorPagoResponse coordinadorPagoResponse = new CoordinadorPagoResponse();
		
		//Validacion de usuario
		Client clienteUsuario = ClientBuilder.newClient();
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(coordinadorPagoRequest.getIdUsuario());
		
		
		/*Gson gson = new Gson();
		String input = gson.toJson(usuario);
		conectar(URI_USUARIO_VALIDAR, "POST", input);
		
		dispatcherResponse = gson.fromJson(output2, DispatcherResponse.class);*/
		
		
		Response responseUsuario = clienteUsuario.target(URI_USUARIO_VALIDAR).request().post(Entity.entity(usuario, MediaType.APPLICATION_JSON_TYPE));
		if(responseUsuario.getStatus() == 200) {
			Resultado resultado = responseUsuario.readEntity(Resultado.class);
			if(resultado.getMensaje().equalsIgnoreCase(Constante.KO)) {
	    		coordinadorPagoResponse.setMensaje(Constante.MSG_ERROR_USUARIO_NO_EXISTE);
	    		return coordinadorPagoResponse;
	    	}
	    }
		
		
		
	    
	    //Seleccion de servicio a pagar
	    Client clienteConvenio = ClientBuilder.newClient();
	    Convenio convenio = new Convenio();
	    convenio.setIdConvenio(coordinadorPagoRequest.getIdConvenio());
	    Response responseConvenio = clienteConvenio.target(URI_CONVENIO_VALIDAR).request().post(Entity.entity(convenio, MediaType.APPLICATION_JSON_TYPE));
	    Resultado resultadoConvenio = responseConvenio.readEntity(Resultado.class);
	    if(responseConvenio.getStatus() == 200) {
	    	if(resultadoConvenio.getMensaje().equalsIgnoreCase(Constante.KO)) {
	    		coordinadorPagoResponse.setMensaje(Constante.MSG_ERROR_CONVENIO_NO_EXISTE);
	    		return coordinadorPagoResponse;
	    	}else {
	    		coordinadorPagoResponse.setNombreConvenio(resultadoConvenio.getNombreConvenio());
	    	}
	    }
	    
	    //Seleccion de medio de pago
	    Client clienteMedioPago = ClientBuilder.newClient();
	    MedioPago medioPago = new MedioPago();
	    medioPago.setIdMedioPago(coordinadorPagoRequest.getIdMedioPago());
	    Response responseMedioPago = clienteMedioPago.target(URI_MEDIO_PAGO_VALIDAR).request().post(Entity.entity(medioPago, MediaType.APPLICATION_JSON_TYPE));
	    Resultado resultadoMedioPago = responseMedioPago.readEntity(Resultado.class);
	    if(responseMedioPago.getStatus() == 200) {
	    	if(resultadoMedioPago.getMensaje().equalsIgnoreCase(Constante.KO)) {
	    		coordinadorPagoResponse.setMensaje(Constante.MSG_ERROR_MEDIO_PAGO_NO_EXISTE);
	    		return coordinadorPagoResponse;
	    	}else {
	    		coordinadorPagoResponse.setNombreMedioPago(resultadoMedioPago.getNombreMedioPago());
	    	}
	    }
	    
	    //Routing: se envia el id del convenio y devuelve la ruta
	    Client clienteRouting = ClientBuilder.newClient();
	    Response responseRouting = clienteRouting.target(URI_ROUTING+"/"+coordinadorPagoRequest.getIdConvenio()).request().get();
	    Resultado resultadoIntermediateRoutingResponse = null;
	    if(responseRouting.getStatus() == 200) {
	    	resultadoIntermediateRoutingResponse = responseRouting.readEntity(Resultado.class);
	    	if(resultadoIntermediateRoutingResponse.getCodError().equals(Constante.ERROR)) {
	    		coordinadorPagoResponse.setMensaje(Constante.MSG_ERROR_RUTA_CONVENIO);
	    		return coordinadorPagoResponse;
	    	}
	    }
	    
	    Client clienteDispatcher = ClientBuilder.newClient();
	    DispatcherRequest dispatcherRequest = new DispatcherRequest();
	    dispatcherRequest.setIdFacturaPago(coordinadorPagoRequest.getIdFacturaPago());
	    dispatcherRequest.setUrl(resultadoIntermediateRoutingResponse.getUrl());
	    Response responseDispatcher = clienteDispatcher.target(URI_DISPATCHER).request().post(Entity.entity(dispatcherRequest, MediaType.APPLICATION_JSON_TYPE));
	    if(responseDispatcher.getStatus() == 200) {
	    	Resultado resultadoDispatcher = responseDispatcher.readEntity(Resultado.class);
	    	coordinadorPagoResponse.setValorPago(resultadoDispatcher.getValorPago());
	    }
	    
	    
	    Client clienteDispatcherP = ClientBuilder.newClient();
	    DispatcherRequest dispatcherRequestP = new DispatcherRequest();
	    dispatcherRequestP.setIdFacturaPago(coordinadorPagoRequest.getIdFacturaPago());
	    dispatcherRequestP.setUrl(resultadoIntermediateRoutingResponse.getUrl());
	    Response responseDispatcherP = clienteDispatcherP.target(URI_DISPATCHER_P).request().post(Entity.entity(dispatcherRequest, MediaType.APPLICATION_JSON_TYPE));
	    if(responseDispatcherP.getStatus() == 200) {
	    	Resultado resultadoDispatcherP = responseDispatcherP.readEntity(Resultado.class);
	    	coordinadorPagoResponse.setMensaje(resultadoDispatcherP.getMensaje());
	    }else {
	    	coordinadorPagoResponse.setMensaje("Error realizando el pago");
	    }
	    
	    //Resultado resultadoMedioPago = responseDispatcher.readEntity(Resultado.class);
	    
	    /**/
	    
		/*
		
        JsonObject jsonObject = new 
        
        return pago;*/
		
		
	    /*Response response = client.target(URI_BOOK+"/"+facturaIn.getIdFacturaPago()).request().get();
	    int status = response.getStatus();
	    System.out.println("Status code: " + status);
	    if(status == 200) {
	    	FacturaAgua factura = response.readEntity(FacturaAgua.class);
	    	pago.setIdFacturaPago( (int) factura.getValorFactura());
	    }
	    
	    FacturaAgua agua = new FacturaAgua();
	    agua.setIdFactura(facturaIn.getIdFacturaPago());
	    
	    
	    Response response2 = client.target(URI_BOOK+"/"+agua.getIdFactura()).request().post(Entity.entity(agua, MediaType.APPLICATION_JSON_TYPE));
	    Resultado resultado = response2.readEntity(Resultado.class);
	    pago.setMensaje(resultado.getMensaje());
	    */
	    return coordinadorPagoResponse;
    }
		
	public String conectar(String url, String estado, String strJsonIn) {
		String output2 = "";
		try {
    		URL targetUrl = new URL(url);
            HttpURLConnection httpConnection = (HttpURLConnection) targetUrl.openConnection();
            httpConnection.setDoOutput(true);
            httpConnection.setRequestMethod(estado);
            httpConnection.setRequestProperty("Content-Type", "application/json");
	    	OutputStream outputStream = httpConnection.getOutputStream();
            outputStream.write(strJsonIn.getBytes());
            outputStream.flush();
            //valida rta envio peticion
            if (httpConnection.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code: "    + httpConnection.getResponseCode());
            }
            BufferedReader responseBuffer2 = new BufferedReader(new InputStreamReader((httpConnection.getInputStream())));
            
            output2=responseBuffer2.readLine();
            
            httpConnection.disconnect();
		} catch ( IOException e) {
			e.printStackTrace();
		}
		return output2;
	}
}

package com.convenio.web.rest.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.convenio.entity.Convenio;
import com.convenio.web.rest.ConvenioRequest;
import com.convenio.web.rest.ConvenioResponse;

@Path("convenios")
public class ConvenioServicio {

	public static List<Convenio> convenios = null;
	
	public ConvenioServicio() {
		inicializarConvenios();
	}
	
	@POST
    @Path("seleccionar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ConvenioResponse validarConvenio(ConvenioRequest convenioRequest) {
		ConvenioResponse convenioResponse = new ConvenioResponse();
		convenioResponse.setMensaje("KO");
		if (convenioRequest.getIdConvenio() != null) {
			convenioResponse.setIdConvenio(convenioRequest.getIdConvenio());
			if(convenios != null && !convenios.isEmpty()) {
	        	for (Convenio convenio : convenios) {
					if(convenio.getIdConvenio().equals(convenioRequest.getIdConvenio())) {
						convenioResponse.setMensaje("OK");
						convenioResponse.setNombreConvenio(convenio.getNombreConvenio());
					}
				}
	        }
		}
        return convenioResponse;
    }
	
	private void inicializarConvenios() {
		//Simula la base de datos, carga una lista de id de convenios para luego validar si el convenio existe y retornar el codigo de referencia de pago
		if (convenios == null) {
			convenios = new ArrayList<Convenio>();
			convenios.add(new Convenio(1, "Agua"));
			convenios.add(new Convenio(2, "Gas"));
			convenios.add(new Convenio(3, "Luz"));
			convenios.add(new Convenio(4, "Telefonía"));
        }
		/*if(convenios == null) {
			convenios = new ArrayList<Convenio>();
			String nombreArchivo = "C:\\dbBanco\\ConvenioTabla.txt";
			try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {

				String sCurrentLine;

				while ((sCurrentLine = br.readLine()) != null) {
					System.out.println(sCurrentLine);
					String [] result = sCurrentLine.split(";");
			        Convenio convenio = new Convenio();
			        convenio.setIdConvenio(Integer.parseInt(result[0]));
			        convenio.setNombreConvenio(result[1]);
			        convenios.add(convenio);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
	}
}

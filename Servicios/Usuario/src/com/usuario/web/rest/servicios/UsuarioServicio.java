package com.usuario.web.rest.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.usuario.entity.Usuario;
import com.usuario.web.rest.UsuarioRequest;
import com.usuario.web.rest.UsuarioResponse;

@Path("usuarios")
public class UsuarioServicio {

	public static List<Usuario> usuarios = null;
	
	public UsuarioServicio() {
		inicializarUsuarios();
	}
	
	@POST
    @Path("validar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UsuarioResponse validarUsuario(UsuarioRequest usuarioRequest) {
		UsuarioResponse usuarioResponse = new UsuarioResponse();
		usuarioResponse.setMensaje("KO");
		if (usuarioRequest.getIdUsuario() != null) {
			usuarioResponse.setidUsuario(usuarioRequest.getIdUsuario());
			if(usuarios != null && !usuarios.isEmpty()) {
	        	for (Usuario usuario : usuarios) {
					if(usuario.getIdUsuario().equals(usuarioRequest.getIdUsuario())) {
						usuarioResponse.setMensaje("OK");
					}
				}
	        }
		}
        return usuarioResponse;
    }
	
	private void inicializarUsuarios() {
		//Simula la base de datos, carga una lista de id de usuarios para luego validar si el usuario existe
		if (usuarios == null) {
			usuarios = new ArrayList<Usuario>();
            
			usuarios.add(new Usuario(1, ""));
			usuarios.add(new Usuario(2, ""));
			usuarios.add(new Usuario(3, ""));
        }
	}
}

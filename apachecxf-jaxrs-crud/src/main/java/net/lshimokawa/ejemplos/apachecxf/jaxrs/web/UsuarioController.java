package net.lshimokawa.ejemplos.apachecxf.jaxrs.web;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import net.lshimokawa.ejemplos.apachecxf.jaxrs.model.Usuario;
import net.lshimokawa.ejemplos.apachecxf.jaxrs.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;

@Path("/usuarios")
@Produces("application/json")
@Consumes("application/json")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@Path("/{username}")
	@GET
	public Usuario find(@PathParam("username") String username) {
		return usuarioService.find(username);
	}

	public void save(Usuario usuario) {
		usuarioService.save(usuario);
	}

	public void update(Usuario usuario) {
		usuarioService.update(usuario);
	}

	public void delete(Usuario usuario) {
		usuarioService.delete(usuario);
	}

}

package com.distribuida.rest;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.entidades.Singer;
import com.distribuida.servicios.ServicioSinger;

@Path(value = "/singers")
@ApplicationScoped
public class RestSinger implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ServicioSinger servicio;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//	@Produces(MediaType.APPLICATION_JSON)
	public List<Singer> listarSingers() {
		List<Singer> singers = servicio.listar();
		return singers;
	}
	
	@GET
	@Path(value = "/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//	@Produces(MediaType.APPLICATION_JSON)
	public Singer buscarPorId(@PathParam(value = "id") Integer id) {
		return servicio.buscar(id);
	}
	
}

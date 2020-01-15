package com.distribuida.rest;

import com.distribuida.entidades.Album;
import com.distribuida.servicios.ServicioAlbum;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;
import java.util.List;

@Path(value = "/albums")
@ApplicationScoped
public class AlbumRest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    ServicioAlbum servicioAlbum;

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Album> listar() {
        return servicioAlbum.listar();
    }

    @GET
    @Path(value = "/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Album buscar(@PathParam(value = "id") Integer id){
        return servicioAlbum.buscar(id);
    }

    @DELETE
    @Path(value = "/{id}")
    public void eliminar(@PathParam(value = "id") Integer id){
        servicioAlbum.eliminar(id);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void crear(Album album){
        servicioAlbum.crear(album);
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void editar(Album album){
        servicioAlbum.editar(album);
    }
}

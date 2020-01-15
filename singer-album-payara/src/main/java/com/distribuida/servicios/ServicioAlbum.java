package com.distribuida.servicios;

import com.distribuida.entidades.Album;

import java.util.List;

public interface ServicioAlbum {

    List<Album> listar();
    Album buscar(Integer id);

    void eliminar(Integer id);
    void crear(Album album);
    void editar(Album album);
}

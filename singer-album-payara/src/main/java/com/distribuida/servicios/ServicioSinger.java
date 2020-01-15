package com.distribuida.servicios;

import java.util.List;

import com.distribuida.entidades.Singer;

public interface ServicioSinger {
		
	List<Singer> listar();
	Singer buscar(Integer id);
	
	void eliminar(Integer id);
	void crear(Singer singer);
	void editar(Singer singer);
}

package com.rrojas.SpringWebEmpleos.service;

import java.util.List;

import com.rrojas.SpringWebEmpleos.model.Categoria;

public interface CategoriasService {
	List<Categoria> buscarTodas();

	Categoria buscarPorId(Integer idCategoria);

	void guardar(Categoria categoria);
	
	void eliminar(Integer idCategoria);
}

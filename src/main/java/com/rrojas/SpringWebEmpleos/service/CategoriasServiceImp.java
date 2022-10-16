package com.rrojas.SpringWebEmpleos.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rrojas.SpringWebEmpleos.model.Categoria;

@Service
public class CategoriasServiceImp implements CategoriasService {

	private List<Categoria> lista = null;

	public CategoriasServiceImp() {
		lista = new LinkedList<Categoria>();

		Categoria cat1 = new Categoria();
		cat1.setId(1);
		cat1.setNombre("Contabilidad");
		cat1.setDescripcion("Descripción de la categoria de contabilidad");

		lista.add(cat1);
	}

	public void save(Categoria categoria) {
		lista.add(categoria);
	}

	public List<Categoria> buscarTodas() {
		return lista;
	}

	public Categoria buscarPorId(Integer idCategoria) {
		for (Categoria cat : lista) {
			if (cat.getId() == idCategoria) {
				return cat;
			}
		}
		return null;
	}

	@Override
	public void guardar(Categoria categoria) {
		// TODO Auto-generated method stub
		
	}
}

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
		
		Categoria cat2 = new Categoria();
		cat2.setId(2);
		cat2.setNombre("Finanzas");
		cat2.setDescripcion("Descripción de la categoria de finanzas");
		
		Categoria cat3 = new Categoria();
		cat3.setId(3);
		cat3.setNombre("Informatica");
		cat3.setDescripcion("Descripción de la categoria de informatica");
		
		Categoria cat4 = new Categoria();
		cat4.setId(4);
		cat4.setNombre("Arquitectura");
		cat4.setDescripcion("Descripción de la categoria de arquitectura");
		
		Categoria cat5 = new Categoria();
		cat5.setId(5);
		cat5.setNombre("Comunicación");
		cat5.setDescripcion("Descripción de la categoria de Comunicación");

		lista.add(cat1);
		lista.add(cat2);
		lista.add(cat3);
		lista.add(cat4);
		lista.add(cat5);
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

	@Override
	public void eliminar(Integer idCategoria) {
		// TODO Auto-generated method stub
		
	}
}

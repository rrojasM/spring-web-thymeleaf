package com.rrojas.SpringWebEmpleos.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.rrojas.SpringWebEmpleos.Repository.CategoriasRepository;
import com.rrojas.SpringWebEmpleos.model.Categoria;
import com.rrojas.SpringWebEmpleos.service.CategoriasService;

@Service
@Primary
public class CategoriaServiceJPA implements CategoriasService {

	@Autowired
	private CategoriasRepository categoriasRepo;

	@Override
	public List<Categoria> buscarTodas() {
		// TODO Auto-generated method stub
		return categoriasRepo.findAll();
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		// TODO Auto-generated method stub
		Optional<Categoria> optional = categoriasRepo.findById(idCategoria);
		return optional.orElse(null);
	}

	@Override
	public void guardar(Categoria categoria) {
		categoriasRepo.save(categoria);
	}

	@Override
	public void eliminar(Integer idCategoria) {
		categoriasRepo.deleteById(idCategoria);
	}
}

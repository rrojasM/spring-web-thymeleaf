package com.rrojas.SpringWebEmpleos.service.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rrojas.SpringWebEmpleos.Repository.UsuarioRepository;
import com.rrojas.SpringWebEmpleos.model.Usuario;
import com.rrojas.SpringWebEmpleos.service.UsuarioService;

@Service
public class UsuarioServiceJPA implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Override
	public void guardar(Usuario usuario) {
		usuarioRepo.save(usuario);
	}

	@Override
	public void eliminar(Integer idUsuario) {
		usuarioRepo.deleteById(idUsuario);
	}

	@Override
	public List<Usuario> buscarTodos() {
		return usuarioRepo.findAll();
	}

}

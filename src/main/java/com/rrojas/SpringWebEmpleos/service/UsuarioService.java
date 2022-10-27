package com.rrojas.SpringWebEmpleos.service;

import java.util.List;

import com.rrojas.SpringWebEmpleos.model.Usuario;

public interface UsuarioService {

	void guardar(Usuario usuario);
	void eliminar(Integer idUsuario);
	List<Usuario> buscarTodos();
	Usuario buscarPorUsername(String username);
}

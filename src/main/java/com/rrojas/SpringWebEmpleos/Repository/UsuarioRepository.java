package com.rrojas.SpringWebEmpleos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rrojas.SpringWebEmpleos.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}

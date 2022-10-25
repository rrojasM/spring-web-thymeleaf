package com.rrojas.SpringWebEmpleos.service;

import java.util.List;

import org.springframework.data.domain.Example;

import com.rrojas.SpringWebEmpleos.model.Vacante;

public interface VacantesService {
	List<Vacante> buscarTodas();

	Vacante buscarPorId(Integer idVacante);

	void guardar(Vacante vacante);

	List<Vacante> buscarDestacadas();
	void eliminar(Integer idVacante);
	List<Vacante> buscarByExample(Example<Vacante> example);
}

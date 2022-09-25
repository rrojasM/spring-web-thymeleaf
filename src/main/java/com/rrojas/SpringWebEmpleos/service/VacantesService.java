package com.rrojas.SpringWebEmpleos.service;

import java.util.List;
import com.rrojas.SpringWebEmpleos.model.Vacante;

public interface VacantesService {
	List<Vacante> buscarTodas();
	Vacante buscarPorId(Integer idVacante);
}
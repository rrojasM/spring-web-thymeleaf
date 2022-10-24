package com.rrojas.SpringWebEmpleos.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rrojas.SpringWebEmpleos.model.Vacante;

public interface VacanteRepository extends JpaRepository<Vacante, Integer> {
	
	List<Vacante> findByEstatus(String estatus);
	
	List<Vacante> findByDestacadoAndEstatusOrderByIdDesc(int destacado, String estatus);
	List<Vacante> findBySalarioBetween(double s1, double s2);
	List<Vacante> findByEstatusIn(String[] estatus);
}

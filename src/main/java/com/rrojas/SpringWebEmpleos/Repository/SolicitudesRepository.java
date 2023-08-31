package com.rrojas.SpringWebEmpleos.Repository;

import com.rrojas.SpringWebEmpleos.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudesRepository extends JpaRepository<Solicitud, Integer> {
}

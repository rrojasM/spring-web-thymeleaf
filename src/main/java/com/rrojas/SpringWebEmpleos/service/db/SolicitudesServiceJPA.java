package com.rrojas.SpringWebEmpleos.service.db;

import com.rrojas.SpringWebEmpleos.Repository.SolicitudesRepository;
import com.rrojas.SpringWebEmpleos.model.Solicitud;
import com.rrojas.SpringWebEmpleos.service.ISolicitudesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitudesServiceJPA implements ISolicitudesService {
    @Autowired
    private SolicitudesRepository solicitudesRepository;

    @Override
    public void guardar(Solicitud solicitud) {
        solicitudesRepository.save(solicitud);
    }

    @Override
    public void eliminar(Integer idSolicitud) {
        solicitudesRepository.deleteById(idSolicitud);
    }

    @Override
    public List<Solicitud> buscarTodas() {
        return solicitudesRepository.findAll();
    }

    @Override
    public Solicitud buscarPorId(Integer idSolicitud) {
        Optional<Solicitud> optional = solicitudesRepository.findById(idSolicitud);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public Page<Solicitud> buscarTodas(Pageable page) {
        return solicitudesRepository.findAll(page);
    }
}

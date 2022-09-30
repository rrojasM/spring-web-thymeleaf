package com.rrojas.SpringWebEmpleos.controller;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rrojas.SpringWebEmpleos.model.Vacante;
import com.rrojas.SpringWebEmpleos.service.VacantesService;

@Controller
public class HomeController {
	
	@Autowired
	private VacantesService vacantesService;

	@RequestMapping("/")
	public String MostrarHome(Model model) {
		List<Vacante> listaVacantes = vacantesService.buscarTodas();
		
		model.addAttribute("vacantes", listaVacantes);
		return "home";
	}

	@RequestMapping("/listado")
	public String mostrarListado(Model model) {

		List<String> lista = new LinkedList<>();
		lista.add("Ingeniero en sistemas");
		lista.add("Auxiliar de contabilidad");
		lista.add("Vendedor");
		lista.add("Arquitecto");

		model.addAttribute("empleos", lista);

		return "listado";
	}

	@RequestMapping("/detalle")
	public String mostrarDetalleVacante(Model model) { 
		Vacante vacante = new Vacante();
		vacante.setNombre("Ingeniero en sistemas");
		vacante.setDescripcion("Solicita ingeniero para soporte");
		vacante.setFecha(new Date());
		vacante.setSalario(1850.0);
		
		model.addAttribute("vacante", vacante);
		return "detalle";
	}

	@RequestMapping("/tabla")
	public String mostrarTabla(Model model) {
		//List<Vacante> lista = getVacantes();
		List<Vacante> lista = vacantesService.buscarTodas();
		model.addAttribute("vacante", lista);
		return "tabla";
	}
}

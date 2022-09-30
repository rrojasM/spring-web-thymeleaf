package com.rrojas.SpringWebEmpleos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rrojas.SpringWebEmpleos.model.Vacante;
import com.rrojas.SpringWebEmpleos.service.VacantesService;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

	@Autowired
	VacantesService vacanteService;

	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idVacante, Model model) {
		Vacante vacante = vacanteService.buscarPorId(idVacante);
		System.out.println("VACANTE: " + vacante);
		model.addAttribute("vacante", vacante);
		
		return "detalle";
	}

	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") int idVacante, Model model) {
		System.out.println("Borrando vacante con ID: " + idVacante);
		model.addAttribute("id", idVacante);
		return "mensaje";
	}
	
	
	@GetMapping("/create")
	public String crearVacante() {
		return "vacantes/formVacante";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion, @RequestParam("estatus") String estatus,
			@RequestParam("fecha") String fecha, @RequestParam("destacado") int destacado, @RequestParam("salario") double salario, @RequestParam("detalles") String detalles) {
		
		
		System.out.println(nombre);
		System.out.println(descripcion);
		System.out.println(estatus);
		System.out.println(fecha);
		System.out.println(destacado);
		System.out.println(salario);
		System.out.println(detalles);
		
		return "vacantes/listVacantes";
	}
}

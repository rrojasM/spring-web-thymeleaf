package com.rrojas.SpringWebEmpleos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/categorias")
public class CategoriasController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String mostrarIndex(Model model) {
		return "categorias/listCategorias";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create() {
		return "categorias/formCategoria";
	}

	//@PostMapping("/save")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion) {
		System.out.println("Nombre: "+ nombre);
		System.out.println("Descripcion: "+ descripcion);
		return "categorias/listCategorias";
	}
}

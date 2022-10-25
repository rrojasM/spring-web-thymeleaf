package com.rrojas.SpringWebEmpleos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rrojas.SpringWebEmpleos.model.Categoria;
import com.rrojas.SpringWebEmpleos.service.CategoriasService;

@Controller
@RequestMapping(value = "/categorias")
public class CategoriasController {
	
	@Autowired
	//@Qualifier("categoriaServiceJPA")
	private CategoriasService categoriasService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String mostrarIndex(Model model) {
		List<Categoria> lista =categoriasService.buscarTodas();
		model.addAttribute("categorias", lista);
		return "categorias/listCategorias";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String crear(Categoria categoria) {
		return "categorias/formCategoria";
	}

	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String guardar(Categoria categoria, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			System.out.println("EXISTEN ERRORES");
			return "categorias/formCategoria";
		}
		
		categoriasService.guardar(categoria);
		attributes.addFlashAttribute("msg", "Los datos de la categoria fueron guardados");
		return "redirect:/categorias/index";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idCategoria, RedirectAttributes attributes) {
		
		categoriasService.eliminar(idCategoria);
		attributes.addFlashAttribute("msg", "Categoria eliminada.");
		return "redirect:/categorias/index";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idCategoria, Model model) {
		Categoria categoria = categoriasService.buscarPorId(idCategoria);
		model.addAttribute("categoria", categoria);
		
		return "categorias/formCategoria";
	}
}

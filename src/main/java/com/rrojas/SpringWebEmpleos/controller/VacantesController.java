package com.rrojas.SpringWebEmpleos.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rrojas.SpringWebEmpleos.model.Vacante;
import com.rrojas.SpringWebEmpleos.service.CategoriasService;
import com.rrojas.SpringWebEmpleos.service.VacantesService;
import com.rrojas.SpringWebEmpleos.utils.Utileria;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

	@Autowired
	private VacantesService vacanteService;

	@Autowired
	private CategoriasService categoriaService;

	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idVacante, Model model) {
		Vacante vacante = vacanteService.buscarPorId(idVacante);
		model.addAttribute("vacante", vacante);
		return "detalle";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idVacante, Model model) {
		Vacante vacante = vacanteService.buscarPorId(idVacante);
		model.addAttribute("vacante", vacante);
		//model.addAttribute("categorias", categoriaService.buscarTodas());
		
		return "vacantes/formVacante";
	}

	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idVacante, RedirectAttributes attributes) {
		vacanteService.eliminar(idVacante);
		attributes.addFlashAttribute("msg", "Vacante eliminada.");
		return "redirect:/vacantes/index";
	}

	@GetMapping("/create")
	public String crearVacante(Vacante vacante, Model model) {
		//model.addAttribute("categorias", categoriaService.buscarTodas());
		return "vacantes/formVacante";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Vacante vacante, BindingResult result, RedirectAttributes attributes,
			@RequestParam("archivoImagen") MultipartFile multiPart) {

		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrio un error: " + error.getDefaultMessage());
			}
			return "vacantes/formVacante";
		}

		if (!multiPart.isEmpty()) {
			String ruta = "C:/Users/ruf_r/Documents/dev/thymeleaf-image/";
			String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
			if (nombreImagen != null) {
				vacante.setImagen(nombreImagen);
			}
		}

		vacanteService.guardar(vacante);
		attributes.addFlashAttribute("msg", "Vacante Guardada Exitosamente");
		return "redirect:/vacantes/index";
	}

	@RequestMapping(value = "/index")
	public String mostrarIndex(Model model) {
		List<Vacante> lista = vacanteService.buscarTodas();
		model.addAttribute("vacantes", lista);
		return "vacantes/listVacantes";
	}
	
	@ModelAttribute
	public void setGenericos(Model model) {
		model.addAttribute("categorias", categoriaService.buscarTodas());
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}

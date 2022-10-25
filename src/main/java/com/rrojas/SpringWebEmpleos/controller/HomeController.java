package com.rrojas.SpringWebEmpleos.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rrojas.SpringWebEmpleos.model.Perfil;
import com.rrojas.SpringWebEmpleos.model.Usuario;
import com.rrojas.SpringWebEmpleos.model.Vacante;
import com.rrojas.SpringWebEmpleos.service.CategoriasService;
import com.rrojas.SpringWebEmpleos.service.UsuarioService;
import com.rrojas.SpringWebEmpleos.service.VacantesService;

@Controller
public class HomeController {

	@Autowired
	private VacantesService vacantesService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private CategoriasService categoriaService;

	@RequestMapping("/")
	public String MostrarHome(Model model) {
		// List<Vacante> listaVacantes = vacantesService.buscarTodas();
		// model.addAttribute("vacantes", listaVacantes);
		return "home";
	}

	@GetMapping("/signup")
	public String registrarse(Usuario usuario) {
		return "formRegistro";
	}

	@PostMapping("/signup")
	public String guardarRegistro(Usuario usuario, RedirectAttributes attributes) {
		usuario.setEstatus(1); // Activado por defecto
		usuario.setFechaRegistro(new Date()); // Fecha de Registro, la fecha actual del servidor

		// Creamos el Perfil que le asignaremos al usuario nuevo
		Perfil perfil = new Perfil();
		perfil.setId(3); // Perfil USUARIO
		usuario.addPerfil(perfil);

		/**
		 * Guardamos el usuario en la base de datos. El Perfil se guarda automaticamente
		 */
		usuarioService.guardar(usuario);
		attributes.addFlashAttribute("msg", "El registro fue guardado correctamente!");

		return "redirect:/usuarios/index";
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
		List<Vacante> lista = vacantesService.buscarDestacadas();
		model.addAttribute("vacante", lista);
		return "tabla";
	}

	@RequestMapping("/search")
	public String buscar(@ModelAttribute("search") Vacante vacante, Model model) {
		System.out.println("Buscando por " + vacante);
		
		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("descripcion", 
				ExampleMatcher.GenericPropertyMatchers.contains());

		Example<Vacante> example = Example.of(vacante, matcher);
		List<Vacante> lista = vacantesService.buscarByExample(example);
		model.addAttribute("vacantes", lista);

		return "home";

	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@ModelAttribute
	public void setGenericos(Model model) {
		Vacante vacanteSearch = new Vacante();
		vacanteSearch.reset();
		model.addAttribute("vacantes", vacantesService.buscarDestacadas());
		model.addAttribute("categorias", categoriaService.buscarTodas());
		model.addAttribute("search", vacanteSearch);
	}
}

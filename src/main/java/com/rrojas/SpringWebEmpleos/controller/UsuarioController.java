package com.rrojas.SpringWebEmpleos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rrojas.SpringWebEmpleos.model.Usuario;
import com.rrojas.SpringWebEmpleos.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Usuario> lista = usuarioService.buscarTodos();
		model.addAttribute("usuarios", lista);
		return "usuarios/listUsuarios";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idUsuario, RedirectAttributes attributes) {
		usuarioService.eliminar(idUsuario);
		attributes.addFlashAttribute("msg", "Usuario eliminado");
		return "redirect:/usuarios/index";
	}
}

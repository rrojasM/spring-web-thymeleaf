package com.rrojas.SpringWebEmpleos.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rrojas.SpringWebEmpleos.model.Vacante;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String MostrarHome(Model model) {
		/*
		 * model.addAttribute("mensaje", "Bienvenidos a Empleos APP");
		 * model.addAttribute("fecha", new Date());
		 */
		String vacante = "Auxiliar de Contabilidad";
		Date fecha = new Date();
		double salario = 9500;
		boolean vigente = true;

		model.addAttribute("nombre", vacante);
		model.addAttribute("fecha", fecha);
		model.addAttribute("salario", salario);
		model.addAttribute("vigente", vigente);
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

	private List<Vacante> getVacantes() {

		SimpleDateFormat formatDate = new SimpleDateFormat("DD-MM-YYYY");
		List<Vacante> listaVacantes = new LinkedList<Vacante>();

		try {

			Vacante vacante1 = new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Desarrollador Android");
			vacante1.setDescripcion("Generar aplicaciones android");
			vacante1.setFecha(formatDate.parse("10-10-2022"));
			vacante1.setSalario(20000.0);
			vacante1.setDestacado(1);
			vacante1.setImage("empresa1.png");

			Vacante vacante2 = new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Desarrollador Ios");
			vacante2.setDescripcion("Generar aplicaciones Ios");
			vacante2.setFecha(formatDate.parse("10-10-2022"));
			vacante2.setSalario(20000.0);
			vacante2.setDestacado(0);
			vacante2.setImage("empresa2.png");

			Vacante vacante3 = new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Desarrollador React-native");
			vacante3.setDescripcion("Generar aplicaciones android y ios");
			vacante3.setFecha(formatDate.parse("10-10-2022"));
			vacante3.setSalario(20000.0);
			vacante3.setDestacado(0);
			vacante3.setImage("empresa3.png");
			
			Vacante vacante4 = new Vacante();
			vacante4.setId(4);
			vacante4.setNombre("Desarrollador FullStack");
			vacante4.setDescripcion("Desarrollar sistemas fullstack");
			vacante4.setFecha(formatDate.parse("10-10-2022"));
			vacante4.setSalario(20000.0);
			vacante4.setDestacado(1);
			
			listaVacantes.add(vacante1);
			listaVacantes.add(vacante2);
			listaVacantes.add(vacante3);
			listaVacantes.add(vacante4);

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println("ERROR: " + e.getMessage());
		}

		return listaVacantes;
	}

	@RequestMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Vacante> lista = getVacantes();
		model.addAttribute("vacante", lista);
		return "tabla";
	}
}

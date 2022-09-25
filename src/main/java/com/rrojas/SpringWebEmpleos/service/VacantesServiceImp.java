package com.rrojas.SpringWebEmpleos.service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.rrojas.SpringWebEmpleos.model.Vacante;

@Service
public class VacantesServiceImp implements VacantesService {

	private List<Vacante> listaVacantes = null;

	public VacantesServiceImp() {

		SimpleDateFormat formatDate = new SimpleDateFormat("DD-MM-YYYY");
		listaVacantes = new LinkedList<Vacante>();

		try {

			Vacante vacante1 = new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Desarrollador Android");
			vacante1.setDescripcion("Generar aplicaciones android");
			vacante1.setFecha(formatDate.parse("10-10-2022"));
			vacante1.setSalario(25000.0);
			vacante1.setDestacado(1);
			vacante1.setImage("logo1.png");

			Vacante vacante2 = new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Desarrollador Ios");
			vacante2.setDescripcion("Generar aplicaciones Ios");
			vacante2.setFecha(formatDate.parse("10-10-2022"));
			vacante2.setSalario(28000.0);
			vacante2.setDestacado(0);
			vacante2.setImage("logo2.png");

			Vacante vacante3 = new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Desarrollador React-native");
			vacante3.setDescripcion("Generar aplicaciones android y ios");
			vacante3.setFecha(formatDate.parse("10-10-2022"));
			vacante3.setSalario(23000.0);
			vacante3.setDestacado(0);
			vacante3.setImage("logo3.png");

			Vacante vacante4 = new Vacante();
			vacante4.setId(4);
			vacante4.setNombre("Desarrollador FullStack");
			vacante4.setDescripcion("Desarrollar sistemas fullstack");
			vacante4.setFecha(formatDate.parse("10-10-2022"));
			vacante4.setSalario(21000.0);
			vacante4.setDestacado(1);

			listaVacantes.add(vacante1);
			listaVacantes.add(vacante2);
			listaVacantes.add(vacante3);
			listaVacantes.add(vacante4);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR: " + e.getMessage());
		}
	}

	@Override
	public List<Vacante> buscarTodas() {
		return listaVacantes;
	}

	@Override
	public Vacante buscarPorId(Integer idVacante) {

		for (Vacante v : listaVacantes) {

			if (v.getId() == idVacante) {
				return v;
			}
		}

		return null;
	}

}
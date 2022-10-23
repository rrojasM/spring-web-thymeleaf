package com.rrojas.SpringWebEmpleos.utils;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class Utileria {

	public static String guardarArchivo(MultipartFile multiPart, String ruta) {

		String nombreOriginal = multiPart.getOriginalFilename();

		try {
			File imageFile = new File(ruta + nombreOriginal);
			System.out.println("ARCHIVO => " + imageFile.getAbsolutePath());
			multiPart.transferTo(imageFile);
			return nombreOriginal;

		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("ERROR => " + e.getMessage());
			return null;
		}
	}
}

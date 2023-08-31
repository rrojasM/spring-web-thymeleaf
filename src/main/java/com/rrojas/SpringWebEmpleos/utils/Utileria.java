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

	public static String randomAlphaNumeric(int count){
		String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder  builder  = new StringBuilder();

		while (count -- != 0){
			int character = (int) (Math.random() *  CARACTERES.length());
			builder.append(CARACTERES.charAt(character));
		}

		return  builder.toString();
	}
}

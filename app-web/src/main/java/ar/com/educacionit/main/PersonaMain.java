package ar.com.educacionit.main;

import ar.com.educacionit.entidades.Espanol;
import ar.com.educacionit.entidades.Ingles;
import ar.com.educacionit.entidades.Persona;
import ar.com.educacionit.entidades.Portugues;
import ar.com.educacionit.exceptions.checked.NoSabeException;

public class PersonaMain {

	public static void main(String[] args) {
		System.out.println("Hola mundo!");

		Persona p1 = new Persona(); // Porque tengo un constructor generico (object)
		Persona p2 = new Persona("Pedro", "Rodriguez", new Espanol());
		System.out.println(p1);
		System.out.println(p1.toString());
		System.out.println(p2);
		
		Ingles i1 = new Ingles();
		
		Persona p3 = new Persona("Laura", "Gimenez", i1);
		System.out.println(p3);
		
		p2.aprender(i1);
		Portugues portu1 = new Portugues();
		p2.aprender(portu1);
		
		p2.decir("palabra");
		p3.decir("palabra");
		
		System.out.println(p2);
		// Espanol espa = new Espanol();
		try {
			p2.decir("Hola", i1);
		} catch (NoSabeException e) {
			e.printStackTrace();
		}
		Espanol esp1 = new Espanol();
		p3.aprender(esp1); // 32131
		p3.aprender(portu1);
		System.out.println(p3);
		try {
			p3.decir("Chau", portu1);
		} catch (NoSabeException e) {
			e.printStackTrace();
		}
		Espanol esp2 = new Espanol();
		try {
			p3.decir("Chau", esp2);
		} catch (NoSabeException e) {
			e.printStackTrace();
		} // 134867
		
		System.out.println("Fin del programa");
		
	}

}

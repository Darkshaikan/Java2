package ar.com.educacionit.main;

import java.util.HashSet;
import java.util.Iterator;

public class SetMain {

	public static void main(String[] args) {
		
		// creo
		HashSet<Integer> edades = new HashSet<>();
		
		boolean agrego = edades.add(1);
		System.out.println(agrego);
		agrego = edades.add(3);
		System.out.println(agrego);
		agrego = edades.add(5);
		System.out.println(agrego);
		
		if ( agrego ) {
			System.out.println("5 agregado");
		}
		
		agrego = edades.add(3);
		
		if ( agrego ) {
			System.out.println("Se agrego 3");
		} else {
			System.out.println("3 no se agregó");
		}
		
		// recorrer un set
		for (Integer edad : edades) {
			System.out.println(edad);
		}
		
		// Cantidad de elementos
		System.out.println("Hay " + edades.size() + " edades");
		
		// Eliminar un elemento
		boolean elimino = edades.remove(30);
		System.out.println(elimino);
		elimino = edades.remove(3);
		System.out.println(elimino);
		
		// vaciar el set
		edades.clear();
		
		// Cantidad de elementos
		System.out.println("Hay " + edades.size() + " edades");
				
		System.out.println("FIN");
				
	}

}

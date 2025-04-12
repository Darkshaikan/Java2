package ar.com.educacionit.main;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetMain {

	public static void main(String[] args) {
		TreeSet<Integer> alturas = new TreeSet<>();
		
		alturas.add(172);
		alturas.add(167);
		alturas.add(182);
		alturas.add(153);
		alturas.add(171);
		
		// 153 167 171 172 182
		
		System.out.println(alturas);
		
		// Java 11
		Set<String> nombres2 = Set.of("Fernando", "Lorena", "Mariana", "Diego");
		TreeSet<String> nombres = new TreeSet<>(nombres2); 
				
		System.out.println(nombres);
		
		
		
	}

}

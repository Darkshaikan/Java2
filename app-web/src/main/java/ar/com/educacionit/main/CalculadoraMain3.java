package ar.com.educacionit.main;

import ar.com.educacionit.entidades.Calculadora;
import ar.com.educacionit.exceptions.checked.DivisionPorCeroException;

public class CalculadoraMain3 {

	public static void main(String[] args) {
		
		int a = 20;
		int b = 0;
		
		boolean continuar = true;
		
		// do while se ejecuta aunque sea una vez. 
		// Y al final evalua una condición
		do {
			
			try {
				System.out.println("Primera línea");
				Calculadora.dividir(a, b);
				continuar = false;
				System.out.println("esta línea");
			} catch (DivisionPorCeroException e) {
				e.printStackTrace();
				b = 1;
			} 
			
		} while (continuar);	
		
		System.out.println("FIN");

	}

}

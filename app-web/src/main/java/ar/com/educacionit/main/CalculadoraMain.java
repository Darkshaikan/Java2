package ar.com.educacionit.main;

import ar.com.educacionit.entidades.Calculadora;
import ar.com.educacionit.exceptions.checked.DivisionPorCeroException;

public class CalculadoraMain {

	public static void main(String[] args) throws DivisionPorCeroException {
		
		int a = 20;
		int b = 0;
		
		// Si no quiero controlar el error con try/catch, agrego throws en el método
		int res = Calculadora.dividir(a, b);
		System.out.println(res);
		
		System.out.println("FIN");

	}

}

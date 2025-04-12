package ar.com.educacionit.interfaces;

public interface IIdioma {
	// Creamos nuestro contrato
	public void decir(String palabra); // Solo coloco la firma. Hasta versión de JAVA 8
	
	// Todas las clases que implementen esta interfaz, tendrán disponible
	// El método noSeDecir
	public default void noSeDecir(String palabra) {
		System.out.println("No sé decir..." + palabra);
	}
}

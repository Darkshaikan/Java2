package ar.com.educacionit.herencia;

public class Bazar extends Articulo {

	// Atributos
	private int capacidad;

	public Bazar(String nombre, int capacidad) {
		super(nombre); // Llama al construtor del que extiende -> Articulo
		this.capacidad = capacidad;
	}
	
	public Bazar(String nombre, float precio, int capacidad) {
		super(nombre, precio);
		this.capacidad = capacidad;
	}

	@Override
	public String toString() {
		return "Bazar [capacidad=" + capacidad + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
}

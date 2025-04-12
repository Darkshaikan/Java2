package ar.com.educacionit.herencia;

public class Buscador {

	// atributos
	private String claveBusqueda;
	private Integer cantidadResultados;
	private Articulo[] resultados;
	
	// alt + shift + s
	public Buscador() {	
		this.resultados = new Articulo[0];
		this.cantidadResultados = 0;
		this.claveBusqueda = "";
	}	
	
	public String getClaveBusqueda() {
		/*if ( this.claveBusqueda == null ) {
			return "";
		} 
		return this.claveBusqueda; */
		// Ternario
		// return (this.claveBusqueda == null) ? "" : this.claveBusqueda;
		return this.claveBusqueda;
	}
	
	public void setClaveBusqueda(String claveBusqueda) {
		/* if(claveBusqueda != null) {
			this.claveBusqueda = claveBusqueda;			
		} */
		this.claveBusqueda = claveBusqueda.toLowerCase();
	}

	public Integer getCantidadResultados() {
		/* if ( this.resultados == null) {
			return 0;
		} else {
			return this.resultados.length; // tamaño del array
		} */
		return this.resultados.length;
	}

	public Articulo[] getResultados() {
		/* if ( this.resultados == null) {
			return new String[0];
		}*/ 
		return this.resultados;
	}	
	
	public void buscar() {
		// select * form articulos where titulo like '%this.claveBusqueda%'
		Articulo[] resultados = new Articulo[] {
				new Ropa("Pantalón Largo", 33.2f, "xs"),
				new Electronico("Celular", 444.2f, "Sony"),
				new Bazar("Botella", 55.2f, 1),
				new Ropa("Buzo", 22.2f, "s"),
				new Electronico("PC", 445.2f, "Lenovo")
		};
		
		this.resultados = resultados;
		this.cantidadResultados = resultados.length;
	}
	
	public boolean hayResultados() {
		return (this.cantidadResultados == 0) ? false : true;
	}
	

}

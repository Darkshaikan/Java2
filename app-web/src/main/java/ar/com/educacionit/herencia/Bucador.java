package ar.com.educacionit.herencia;

public class Bucador {
	
	// atributos
	
	private String claveBusqueda;
	private Integer cantidadResultados;
	private Articulo[] resultados;
	public Bucador()
	{
		this.resultados = new Articulo[0];
		this.cantidadResultados = 0;
		this.claveBusqueda = "";
	}
	
	
	
	
	/*public Bucador(String claveBusqueda, Integer cantidadResultados, String[] resultados) {
		super();
		this.claveBusqueda = claveBusqueda;
		this.cantidadResultados = cantidadResultados;
		this.resultados = resultados;
	}*/




	public String getClaveBusqueda() {
		/*if (claveBusqueda == null) {
			return "";
		}
		return this.claveBusqueda;*/
		
		//return this.claveBusqueda == null ? "" : this.claveBusqueda;
		return this.claveBusqueda;
	}
	
	public void setClaveBusqueda(String claveBusqueda) {
		/*if(claveBusqueda != null) {
		this.claveBusqueda = claveBusqueda;
		}*/
		this.claveBusqueda = claveBusqueda.toLowerCase();
		//
	}

	public Integer getCantidadResultados() {
		/*if (this.resultados == null) {
			return 0;
		} else {
			return this.resultados.length; // Tamano del Array
		}*/
		return this.resultados.length;
		
	}

	public Articulo[] getResultados() {
		/*if (this.resultados == null) {
			return new String [0];
			
		}*/
		return this.resultados;
	}
	
	public void buscar() {
		Articulo[] resultados = new Articulo[] {
				new Ropa ("Pantalon Largo",220f, "xs" ),
				new Electronico("Celular", 225f, "Samgung" ),
				new Bazar ("Botella", 223.25f, 1 ),
				new Ropa ("Pantalon Short", 335f, "XL" )
		};
		
		this.resultados = resultados;
		this.cantidadResultados = resultados.length;
		
	}
	
	public boolean hayResultados() {
		return this.cantidadResultados == 0 ? false : true;
		
	}
	
	
	
}

package ar.edu.unlp.info.oo2.facturacion_llamadas;

public abstract class Persona {
	private String nombre;

	public Persona (String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	
	public abstract double calcularDescuento();
}

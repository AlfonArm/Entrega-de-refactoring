package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class PersonaFísica extends Persona {
	private String dni;
	public PersonaFísica(String nombre, String dni) {
		super(nombre);
		this.dni = dni;
	}

	public double calcularDescuento() {
		return Empresa.descuentoFis;
	}

	public String getDni() {
		return dni;
	}
}

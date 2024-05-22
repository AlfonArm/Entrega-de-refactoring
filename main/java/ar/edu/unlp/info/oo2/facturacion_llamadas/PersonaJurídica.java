package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class PersonaJurídica extends Persona {
	private String cuil;
	public PersonaJurídica(String nombre, String cuil) {
		super(nombre);
		this.cuil = cuil;
	}

	public double calcularDescuento() {
		return Empresa.descuentoJur;
	}

	public String getCuil() {
		return cuil;
	}
}

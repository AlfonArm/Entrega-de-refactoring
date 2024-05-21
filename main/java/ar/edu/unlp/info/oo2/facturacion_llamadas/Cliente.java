package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cliente {
	private List<Llamada> llamadas = new ArrayList<Llamada>();
	private String tipo;
	private String nombre;
	private String numeroTelefono;
	private String dni;

	public Cliente (String tipo, String nombre, String numeroTelefono, String dni) {
		this.tipo = tipo;
		this.nombre = nombre;
		this.numeroTelefono = numeroTelefono;
		this.dni = dni;
	}
	public String getTipo() {
		return tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}


	public String getDNI() {
		return dni;
	}

	public List<Llamada> getLlamadas () { 
		return Collections.unmodifiableList(this.llamadas);
	}
	
	public void addLlamada (Llamada llamada) {
		this.llamadas.add(llamada);
	}
	
	public boolean removeLlamada (Llamada llamada) {
		return this.llamadas.remove(llamada);
	}
}

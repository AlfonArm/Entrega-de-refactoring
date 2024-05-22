package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cliente {
	private List<Llamada> llamadas = new ArrayList<Llamada>();
	private Persona persona;
	private String numeroTelefono;

	public Cliente (String numeroTelefono, Persona persona) {
		this.persona = persona;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
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
	
	public double calcularDescuento () {
		return this.getPersona().calcularDescuento();
	}
	private Persona getPersona() {
		return this.persona;
	}
	
	public double calcularMontoTotalLlamadas() {
		// acá meter replace temp with query y un stream bien gordo
		double c = 0;
		for (Llamada l : this.getLlamadas()) {
			c += this.calcularMontoDeUnaLlamada(l);
		}
		return c;
	}
	
	private double calcularMontoDeUnaLlamada (Llamada l) {
		return (1 - this.calcularDescuento ()) * l.calcularMontoBase();
	}
}

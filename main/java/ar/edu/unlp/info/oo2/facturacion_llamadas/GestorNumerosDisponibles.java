package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.TreeSet;
import java.util.SortedSet;

public class GestorNumerosDisponibles {
	private SortedSet<String> lineas = new TreeSet<String>();
	private GeneradorNúmeros tipoGenerador;

	public SortedSet<String> getLineas() {
		return lineas;
	}
	
	public GestorNumerosDisponibles (GeneradorNúmeros generador) {
		this.tipoGenerador = generador;
	}

	public String obtenerNumeroLibre() {
		return this.tipoGenerador.obtenerNúmeroLibre(lineas);
	}

	public void cambiarTipoGenerador(GeneradorNúmeros generador) {
		this.tipoGenerador = generador;
	}
	
	//query
	public boolean agregarNumeroTelefono(String str) {
		if (!this.getLineas().contains(str)) {
			this.getLineas().add(str);
			return true;
		}
		return false;
	}
}

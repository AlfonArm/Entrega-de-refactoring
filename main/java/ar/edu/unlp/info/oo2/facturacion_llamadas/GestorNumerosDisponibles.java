package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Random;
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

	// replace type code with subclasses -> replace conditional with polymorfism
	public String obtenerNumeroLibre() {
		return this.tipoGenerador.obtenerNúmeroLibre(lineas);
	}

	public void cambiarTipoGenerador(GeneradorNúmeros generador) {
		this.tipoGenerador = generador;
	}
}

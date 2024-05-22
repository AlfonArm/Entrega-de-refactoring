package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.SortedSet;

public abstract class GeneradorNúmeros {
	public abstract String obtenerNúmeroLibre(SortedSet<String> lineas);
}

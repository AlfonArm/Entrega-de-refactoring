package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class LlamadaInternacional implements TipoLlamada {

	public double calcularMontoBase(Integer duración) {
		return duración * 150 + (duración * 150 * 0.21) + 50;
	}

}

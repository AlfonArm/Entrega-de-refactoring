package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class LlamadaNacional implements TipoLlamada {

	public double calcularMontoBase(Integer duración) {
		return duración * 3 + (duración * 3 * 0.21);
	}

}

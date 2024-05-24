package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class LlamadaNacional implements TipoLlamada {

	public double calcularMontoBase(Integer duración) {
		int costoPorMinuto = 3;
		double porcentajeImpuestoIva = 0.21;
		return duración * costoPorMinuto + (duración * costoPorMinuto * porcentajeImpuestoIva);
	}

}

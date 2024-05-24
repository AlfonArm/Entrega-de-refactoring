package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class LlamadaInternacional implements TipoLlamada {

	public double calcularMontoBase(Integer duración) {
		int costoPorMinuto = 150;
		double porcentajeImpuestoIva = 0.21;
		int costoFijo = 50;
		return duración * costoPorMinuto + (duración * costoPorMinuto * porcentajeImpuestoIva) + costoFijo;
	}

}

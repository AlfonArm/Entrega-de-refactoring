package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private List<Llamada> llamadas = new ArrayList<Llamada>();
	private GestorNumerosDisponibles guia = new GestorNumerosDisponibles();

	static double descuentoJur = 0.15;
	static double descuentoFis = 0;

	public boolean agregarNumeroTelefono(String str) {
		boolean encontre = guia.getLineas().contains(str);
		if (!encontre) {
			guia.getLineas().add(str);
			encontre= true;
			return encontre;
		}
		else {
			encontre= false;
			return encontre;
		}
	}

	public String obtenerNumeroLibre() {
		return guia.obtenerNumeroLibre();
	}

	public Cliente registrarUsuario(String data, String nombre, String tipo) {
		String tel = this.obtenerNumeroLibre();
		Cliente var = new Cliente (tipo, nombre, tel, data);
		clientes.add(var);
		return var;
	}

	public Llamada registrarLlamada(Cliente origen, Cliente destino, String t, int duracion) {
		Llamada llamada = new Llamada(t, origen.getNumeroTelefono(), destino.getNumeroTelefono(), duracion);
		llamadas.add(llamada);
		origen.addLlamada(llamada);
		return llamada;
	}

	public double calcularMontoTotalLlamadas(Cliente cliente) {
		double c = 0;
		for (Llamada l : cliente.getLlamadas()) {
			c += this.calcularMontoDeUnaLlamada(l, cliente.getTipo());
		}
		return c;
	}
	
	private double calcularMontoDeUnaLlamada (Llamada l, String tipoCliente) {
		return this.calcularMontoBaseLlamada(l) * (1 - this.calcularDescuentoCliente(tipoCliente)); // pequeño cambio lógico de calidad de vida
	}
	
	private double calcularDescuentoCliente (String tipoCliente) {
		if (tipoCliente == "fisica") {
			return descuentoFis;
		} else if(tipoCliente == "juridica") {
			return descuentoJur;
		}
		return 0.0;
	}
	
	private double calcularMontoBaseLlamada (Llamada l) {
		if (l.getTipoDeLlamada() == "nacional") {
			// el precio es de 3 pesos por segundo más IVA sin adicional por establecer la llamada
			return l.getDuracion() * 3 + (l.getDuracion() * 3 * 0.21);
		} else if (l.getTipoDeLlamada() == "internacional") {
			// el precio es de 150 pesos por segundo más IVA más 50 pesos por establecer la llamada
			return l.getDuracion() * 150 + (l.getDuracion() * 150 * 0.21) + 50;
		}
		return 0.0;
	}

	public int cantidadDeUsuarios() {
		return clientes.size();
	}

	public boolean existeUsuario(Cliente persona) {
		return clientes.contains(persona);
	}

	public GestorNumerosDisponibles getGestorNumeros() {
		return this.guia;
	}
}

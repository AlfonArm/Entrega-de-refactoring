package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private List<Llamada> llamadas = new ArrayList<Llamada>();
	private GestorNumerosDisponibles guia = new GestorNumerosDisponibles(new GeneradorNumerosFinal ());

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

	public Cliente registrarPersonaFísica (String dni, String nombre) {
		return this.registrarUsuario(new PersonaFísica (nombre, dni)); 
	}
	
	public Cliente registrarPersonaJurídica (String cuil, String nombre) {
		return this.registrarUsuario(new PersonaJurídica (nombre, cuil)); 
	}
	
	public Cliente registrarUsuario(Persona persona) {
		Cliente var  = null;
		String tel = this.obtenerNumeroLibre();
		var = new Cliente (tel, persona);
		clientes.add(var);
		return var;
	}

	public Llamada registrarLlamada(Cliente origen, Cliente destino, TipoLlamada t, int duracion) {
		Llamada llamada = new Llamada(t, origen.getNumeroTelefono(), destino.getNumeroTelefono(), duracion);
		llamadas.add(llamada);
		origen.addLlamada(llamada);
		return llamada;
	}

	public double calcularMontoTotalLlamadas(Cliente cliente) {
		// acá meter replace temp with query y un stream bien gordo
		double c = 0;
		for (Llamada l : cliente.getLlamadas()) {
			c += this.calcularMontoDeUnaLlamada(l, cliente);
		}
		return c;
	}
	
	private double calcularMontoDeUnaLlamada (Llamada l, Cliente cliente) {
		return (1 - cliente.calcularDescuento ()) * l.calcularMontoBase();
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

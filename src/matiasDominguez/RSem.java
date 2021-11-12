package matiasDominguez;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RSem {
	private ArrayList<REstacionamiento> registroDeEstacionamientos = new ArrayList<REstacionamiento>();
	private ArrayList<RRecarga> registroDeRecargas = new ArrayList<RRecarga>();
	private Map<Celular , Integer> registroDeCreditos = new HashMap<>();
	private Map<Auto , List<RInfraccion>> registroDeInfracciones = new HashMap<>();
	
	public void registrarEstacionamiento(REstacionamiento registro) {
		registroDeEstacionamientos.add(registro);
	}

	public void registrarCompra(RRecarga registro) {
		registroDeRecargas.add(registro);
		
	}
	
	public void registrarInfraccion(Auto auto, RInfraccion infraccion) {
		List<RInfraccion> listaDeInfracciones = new ArrayList<RInfraccion>();
		if (registroDeInfracciones.containsKey(auto)) {
			registroDeInfracciones.get(auto).add(infraccion);
		} 
		else {
			listaDeInfracciones.add(infraccion);
			registroDeInfracciones.put(auto, listaDeInfracciones);
		}
	}
	
	public void registrarCredito(Celular celular, int credito) {
		registroDeCreditos.put(celular, credito);
	}
	
	public ArrayList<REstacionamiento> getRegistroDeEstacionamientos() {
		return registroDeEstacionamientos;
	}
	
}

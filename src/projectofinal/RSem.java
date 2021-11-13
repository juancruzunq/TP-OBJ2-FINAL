package projectofinal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RSem {
	private ArrayList<REstacionamiento> registroDeEstacionamientos = new ArrayList<REstacionamiento>();
	private ArrayList<RRecarga> registroDeRecargas = new ArrayList<RRecarga>();
	private Map<Integer , Integer> registroDeCreditos = new HashMap<>();
	private Map<Auto , List<RInfraccion>> registroDeInfracciones = new HashMap<>();
	private ArrayList<Subscriptor> subscriptores = new ArrayList<Subscriptor>();
	private int numeroDeControl = 0;
	
	
	
	public void registrarEstacionamiento(REstacionamiento registro) {
		registroDeEstacionamientos.add(registro);
		this.notificarEstacionamiento(registro);
	}

	public void registrarCompra(RRecarga registro){
		RRecarga registroActual = registro;
		registroActual.setNumeroDeControl(this.getNumeroDeControl()+1);
		this.setNumeroDeControl(this.getNumeroDeControl()+1);
		registroDeRecargas.add(registro);
		this.notificarCompra(registro);
		
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
	
	
	
	public int getNumeroDeControl() {
		return numeroDeControl;
	}

	public void setNumeroDeControl(int numeroDeControl) {
		this.numeroDeControl = numeroDeControl;
	}

	public ArrayList<REstacionamiento> getRegistroDeEstacionamientos() {
		return registroDeEstacionamientos;
	}

	public Integer obtenerSaldo(Celular celular) {
		Integer numero = celular.getNumero();
		
		return registroDeCreditos.get(numero);
		
	}

	public void setSaldo(Celular celular,Integer monto) {
		Integer numero = celular.getNumero();
		
		registroDeCreditos.put(numero,monto);
	}
	
	private void notificarCompra(RRecarga compra) {
        subscriptores.forEach(sub -> sub.alertarCompra(compra));
    }
	
	private void notificarEstacionamiento(REstacionamiento registro) {
		subscriptores.forEach(sub -> sub.alertarInicioFinEstacionamiento(registro.getHoraInicio(), registro.getHoraFin()));
		
	}
	
	public void Subscribir(Subscriptor subscriptor) {
		subscriptores.add(subscriptor);
	}
	
	public void Desubscribir(Subscriptor subscriptor) {
		subscriptores.remove(subscriptor);
	}
}

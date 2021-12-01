package projectofinal.Sem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import projectofinal.Dispositivos.Celular;
import projectofinal.Dispositivos.RRecarga;
import projectofinal.Estacionamiento.REstacionamiento;
import projectofinal.Estacionamiento.ZonaDeEstacionamiento;
import projectofinal.Reloj.RelojListener;
import projectofinal.Usuarios.Auto;
import projectofinal.Usuarios.Subscriptor;

public class Sem implements RelojListener {
	private ArrayList<ZonaDeEstacionamiento> zonasDeEstacionamiento = new ArrayList<ZonaDeEstacionamiento>();
	private ArrayList<REstacionamiento> registroDeEstacionamientos = new ArrayList<REstacionamiento>();
	private ArrayList<RRecarga> registroDeRecargas = new ArrayList<RRecarga>();
	private Map<Integer , Integer> registroDeCreditos = new HashMap<Integer, Integer>();
	private Map<Auto , List<RInfraccion>> registroDeInfracciones = new HashMap<Auto , List<RInfraccion>>();
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
	
	

	public ArrayList<RRecarga> getRegistroDeRecargas() {
		return registroDeRecargas;
	}

	public void setRegistroDeRecargas(ArrayList<RRecarga> registroDeRecargas) {
		this.registroDeRecargas = registroDeRecargas;
	}

	public ArrayList<REstacionamiento> getRegistroDeEstacionamientos() {
		return registroDeEstacionamientos;
	}

	//cambio?
	public Integer obtenerSaldo(Celular celular) {
		Integer numero = celular.getNumero();
		if (!this.registroDeCreditos.containsKey(numero)) {
			return 0;
		}
		return (int)registroDeCreditos.get(numero);
		
	}

	public void setSaldo(Celular celular,Integer monto) {
		Integer numero = celular.getNumero();
		Integer nuevoMonto;
		if(registroDeCreditos.containsKey(numero)) {
			nuevoMonto = registroDeCreditos.get(numero) + monto;
			registroDeCreditos.put(numero, nuevoMonto);
		}
		else {
			registroDeCreditos.put(numero, monto);
		}
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
	
	@Override
	public void horaActualizada(int hora) {
		if (hora == 2000) {
			this.finalizarJornada();
		}
	}

	private void finalizarJornada() {
		for (ZonaDeEstacionamiento zona : zonasDeEstacionamiento) {
			zona.finalizarEstacionamiento();
		}
	}
}

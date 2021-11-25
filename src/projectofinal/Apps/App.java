package projectofinal.Apps;

import java.util.ArrayList;
import java.util.Date;

import projectofinal.Dispositivos.Celular;
import projectofinal.Estacionamiento.REstacionamiento;
import projectofinal.Estacionamiento.ZonaDeEstacionamiento;
import projectofinal.Reloj.Reloj;
import projectofinal.Sem.RInfraccion;
import projectofinal.Sem.Sem;
import projectofinal.Usuarios.Auto;
import projectofinal.Usuarios.Inspector;

public class App {
		
	private Reloj reloj ;
	
	

	
	public App(Reloj reloj) {
		
		this.reloj = reloj;
	}


	public void infraccionEstacionamientoVigente(Sem sem ,Inspector inspector,Auto auto, ZonaDeEstacionamiento estacionamiento) {
		
		if(!consultaDeEstacionamientoVigente( auto,estacionamiento)) 
		{
			altaDeInfraccion(sem, inspector, auto, estacionamiento);
		}
		
	}


	public boolean consultaDeEstacionamientoVigente(Auto auto, ZonaDeEstacionamiento estacionamiento) {
		boolean autoVigente = false;
		for (REstacionamiento vigente : estacionamientosVigentes(estacionamiento)) {
			if(vigente.getPatente() == auto.getPatente()) {
				return autoVigente = true;
			}
			
		}
		return autoVigente;
	}
	
	
	public void altaDeInfraccion(Sem sem ,Inspector inspector, Auto auto, ZonaDeEstacionamiento estacionamiento) {
		Date fechaActual = inspector.getCelular().getReloj().getFechaActual();
		int horaActual =inspector.getCelular().getReloj().getHoraActual();
		RInfraccion infraccion = new RInfraccion(fechaActual,horaActual,inspector , estacionamiento);
		sem.registrarInfraccion(auto, infraccion);
	}
	
	
	public ArrayList<REstacionamiento> estacionamientosVigentes(ZonaDeEstacionamiento estacionamiento) {
		return estacionamiento.getEstacionamientosVigentes();
	}


	public Reloj getReloj() {
		return reloj;
	}


	public void setReloj(Reloj reloj) {
		this.reloj = reloj;
	}
	
	
	
}


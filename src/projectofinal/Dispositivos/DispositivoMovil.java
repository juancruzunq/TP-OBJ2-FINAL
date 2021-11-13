package projectofinal.Dispositivos;

import java.util.ArrayList;
import java.util.Date;

import projectofinal.Estacionamiento.REstacionamiento;
import projectofinal.Estacionamiento.ZonaDeEstacionamiento;
import projectofinal.Reloj.Reloj;
import projectofinal.Sem.RInfraccion;
import projectofinal.Sem.RSem;
import projectofinal.Usuarios.Auto;
import projectofinal.Usuarios.Inspector;

public class DispositivoMovil {

	private Reloj reloj ;
	
	public DispositivoMovil() {
		
	}

	
	public void consultaDeEstacionamientoVigente(RSem sem ,Inspector inspector,Auto auto, ZonaDeEstacionamiento estacionamiento) {
		
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
	
	
	public void altaDeInfraccion(RSem sem ,Inspector inspector, Auto auto, ZonaDeEstacionamiento estacionamiento) {
		Date fechaActual = reloj.getFechaActual();
		int horaActual =reloj.getHoraActual();
		RInfraccion infraccion = new RInfraccion(fechaActual,horaActual,inspector , estacionamiento);
		sem.registrarInfraccion(auto, infraccion);
	}
	
	
	public ArrayList<REstacionamiento> estacionamientosVigentes(ZonaDeEstacionamiento estacionamiento) {
		return estacionamiento.getEstacionamientosVigentes();
	}
	
}
	
	


package matiasDominguez;

import java.util.ArrayList;
import java.util.Date;

public class AppInspector {

private RSem sem;
	
	
	
	public AppInspector() {
		
	}

	public RSem getSem() {
		return sem;
	}

	public void setSem(RSem sem) {
		this.sem = sem;
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
	
	
	public void AltaDeInfraccion(Inspector inspector, Auto auto, ZonaDeEstacionamiento estacionamiento) {
		Date fechaActual = new Date();
		String horaActual = fechaActual.getHours() + "" + fechaActual.getMinutes();
		RInfraccion infraccion = new RInfraccion(fechaActual,0,inspector , estacionamiento);
		sem.registrarInfraccion(auto, infraccion);
	}
	
	
	public ArrayList<REstacionamiento> estacionamientosVigentes(ZonaDeEstacionamiento estacionamiento) {
		return estacionamiento.getEstacionamientosVigentes();
	}
	
}
	
	


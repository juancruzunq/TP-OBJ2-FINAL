package matiasDominguez;

import java.util.ArrayList;

public class App  {

	

	

	public void inicioEstacionamiento(ZonaDeEstacionamiento zona, RSem sem, String patente, Celular celular) {
		// TODO Auto-generated method stub
		REstacionamientoApp estacionamiento = new REstacionamientoApp(patente,celular.getReloj().getHoraActual() ,0, celular);
		sem.registrarEstacionamiento(estacionamiento);
		zona.agregarVigente(estacionamiento);
	}

	public void finEstacionamiento(ZonaDeEstacionamiento zona  ,RSem sem, Celular celular) {
		// TODO Auto-generated method stub
		Integer numTel = celular.getNumero();
		ArrayList<REstacionamiento> registros = zona.getEstacionamientosVigentes();
		REstacionamiento estacionamiento = (REstacionamiento) registros.stream().filter(r -> r.getCelularNumero().equals(numTel));
		zona.finalizarEstacionamientoVigente(estacionamiento);
		
	}
	
	
	

	
	
	
	
}

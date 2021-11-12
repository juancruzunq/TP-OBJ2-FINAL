package matiasDominguez;

import java.util.ArrayList;
import java.util.stream.Stream;


public class App  {

	

	

	public void inicioEstacionamiento(RSem sem, String patente, Celular celular, int horaActual) {
		// TODO Auto-generated method stub
		REstacionamientoApp estacionamiento = new REstacionamientoApp(patente,horaActual ,0, celular);
		sem.registrarEstacionamiento(estacionamiento);
	}

	public void finEstacionamiento(RSem sem ,Celular celular,int horaFin) {
		// TODO Auto-generated method stub
		Integer numTel = celular.getNumero();
		ArrayList<REstacionamiento> registros = sem.getRegistroDeEstacionamientos();
		String patente = ((REstacionamiento) registros.stream().filter(r -> r.getCelularNumero().equals(numTel))).getPatente();
		
	}
	
	
	

	
	
	
	
}

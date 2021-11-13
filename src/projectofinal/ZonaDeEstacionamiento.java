package projectofinal;

import java.util.ArrayList;

public class ZonaDeEstacionamiento implements RelojListener{
	private Inspector inspector;
	private ArrayList<REstacionamiento> estacionamientosVigentes = new ArrayList<REstacionamiento>();
	private ArrayList<PuntoDeVenta> puntosDeVenta = new ArrayList<PuntoDeVenta>();
	
	public void finalizarEstacionamiento() {
		estacionamientosVigentes.clear();
	}

	@Override
	public void horaActualizada(int hora) {
		for (REstacionamiento estacionamiento : estacionamientosVigentes) {
			if (estacionamiento.getHoraFin() <= hora) {
				eliminarRegistro(estacionamiento);
			}
		}
	}

	public void agregarVigente(REstacionamiento estacionamiento) {
		estacionamientosVigentes.add(estacionamiento);
		
	}
	
	public void agregarPuntoDeVenta(PuntoDeVenta puntoDeVenta) {
		puntosDeVenta.add(puntoDeVenta);
	}

	public ArrayList<REstacionamiento> getEstacionamientosVigentes() {
		return estacionamientosVigentes;
	}
	
	public void finalizarEstacionamientoVigente(REstacionamiento estacionamiento) {
		
		eliminarRegistro(estacionamiento);
	
	}
	
	public void eliminarRegistro(REstacionamiento estacionamiento) {
		estacionamientosVigentes.remove(estacionamiento);
	}
	
	public boolean esEstacionamientoVigente(String patente) {
		 ArrayList<REstacionamiento> estacionamientosVigentes = this.getEstacionamientosVigentes();
		 Boolean estacionamiento = estacionamientosVigentes.stream().anyMatch(r -> r.getPatente().equals(patente));
		 
		 return estacionamiento;
	}
	
	public boolean hayEstacionamientoVigenteApp(int numeroDeCelular) {
		 ArrayList<REstacionamiento> estacionamientosVigentes = this.getEstacionamientosVigentes();
		 Boolean estacionamiento = estacionamientosVigentes.stream().anyMatch(r -> r.getCelularNumero().equals(numeroDeCelular));
		 
		 return estacionamiento;
	}

	public Inspector getInspector() {
		return inspector;
	}

	public void setInspector(Inspector inspector) {
		this.inspector = inspector;
	}

}

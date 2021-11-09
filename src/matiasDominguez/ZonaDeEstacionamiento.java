package matiasDominguez;

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
				estacionamientosVigentes.remove(estacionamiento);
			}
		}
	}

	public void agregarVigente(REstacionamiento estacionamiento) {
		estacionamientosVigentes.add(estacionamiento);
		
	}
	
	public void agregarPuntoDeVenta(PuntoDeVenta puntoDeVenta) {
		puntosDeVenta.add(puntoDeVenta);
	}
	
}

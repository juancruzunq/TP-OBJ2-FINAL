package projectofinal;

import java.util.ArrayList;


public class Sem implements RelojListener{
	private ArrayList<ZonaDeEstacionamiento> zonasDeEstacionamiento = new ArrayList<ZonaDeEstacionamiento>();
	
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
package projectofinal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Sem implements RelojListener{
	private ArrayList<ZonaDeEstacionamiento> zonasDeEstacionamiento = new ArrayList<ZonaDeEstacionamiento>();
	private ArrayList<Subscriptor> subscriptores = new ArrayList<Subscriptor>();
	
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
	
	private void notificar() {
        subscriptores.forEach(sub -> sub.actualizar(this));
    }
	
	public void Subscribir(Subscriptor subscriptor) {
		subscriptores.add(subscriptor);
	}
	
	public void Desubscribir(Subscriptor subscriptor) {
		subscriptores.remove(subscriptor);
	}
}

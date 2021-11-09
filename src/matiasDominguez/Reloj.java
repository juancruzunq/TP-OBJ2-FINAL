package matiasDominguez;

import java.util.ArrayList;
import java.util.Date;

public class Reloj {
	private int horaActual;
	private Date fechaActual;
	private ArrayList<RelojListener> listeners = new ArrayList<RelojListener>();
	
	
	public Reloj(int horaActual, Date fechaActual) {
		super();
		this.horaActual = horaActual;
		this.fechaActual = fechaActual;
	}

	public int getHoraActual() {
		return horaActual;
	}
	
	public Date getFechaActual() {
		return fechaActual;
	}

	public void setHoraActual(int horaActual) {
		this.horaActual = horaActual;
		this.notificarHoraActual();
	}

	private void notificarHoraActual() {
		for (RelojListener listener : this.listeners) {
			listener.horaActualizada(this.getHoraActual());
		}
	}
	
	public void agregarListener(RelojListener listener) {
		listeners.add(listener);
	}
}

package matiasDominguez;

import java.util.ArrayList;
import java.util.Date;

public class Reloj {
	private Integer horaActual;
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
	
	public StringBuffer formatoControlador(Integer hora) {

		String horaString = hora.toString();  
		String index1 =horaString.substring(0, 1);
		String index2 =horaString.substring(2, 3);
		StringBuffer mensaje = new StringBuffer(index1);
		mensaje.append(":");
		mensaje.append(index2);
		return mensaje ;
	}
}

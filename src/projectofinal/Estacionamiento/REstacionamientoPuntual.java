package projectofinal.Estacionamiento;

public class REstacionamientoPuntual extends REstacionamiento {
	private int horasPuntuales;

	public REstacionamientoPuntual(String patente, int horaInicio, int horaFin, int horasPuntuales) {
		super(patente, horaInicio, horaFin);
		this.horasPuntuales = horasPuntuales;
	}

	public int getHorasPuntuales() {
		return horasPuntuales;
	}

	public void setHorasPuntuales(int horasPuntuales) {
		this.horasPuntuales = horasPuntuales;
	}
}

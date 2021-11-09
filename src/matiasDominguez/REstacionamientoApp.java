package matiasDominguez;

public class REstacionamientoApp extends REstacionamiento {
	private Celular celular;

	public REstacionamientoApp(String patente, int horaInicio, int horaFin, Celular celular) {
		super(patente, horaInicio, horaFin);
		this.celular = celular;
	}

	public Celular getCelular() {
		return celular;
	}

	public void setCelular(Celular celular) {
		this.celular = celular;
	}
	
}	

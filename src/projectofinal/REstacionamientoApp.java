package projectofinal;

public class REstacionamientoApp extends REstacionamiento {
	private Celular celular;

	public REstacionamientoApp(String patente, int horaInicio, int horaFin, Celular celular) {
		super(patente, horaInicio, horaFin);
		this.celular = celular;
	}
	
	@Override
	public Integer getCelularNumero() {
		return celular.getNumero();
	}

	public void setCelular(Celular celular) {
		this.celular = celular;
	}
	
}	

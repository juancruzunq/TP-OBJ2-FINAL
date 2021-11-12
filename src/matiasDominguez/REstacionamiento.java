package matiasDominguez;

public class REstacionamiento {
	private String patente;
	private int horaInicio;
	private int horaFin;
	
	public REstacionamiento(String patente, int horaInicio, int horaFin) {
		super();
		this.patente = patente;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}
	
	public String getPatente() {
		return patente;
	}
	public int getHoraInicio() {
		return horaInicio;
	}
	public int getHoraFin() {
		return horaFin;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}
	public void setHoraFin(int horaFin) {
		this.horaFin = horaFin;
	}
	
	
	public Integer getCelularNumero() {
		return 0;
	}
}

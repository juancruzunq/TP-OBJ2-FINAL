package matiasDominguez;

public class Conductor {
	
	
	
	
	private Auto auto;
	private Celular celular;
	
	
	
	
	
	public Conductor(Auto auto, Celular celular) {
		super();
		this.auto = auto;
		this.celular = celular;
	}

	public Auto getAuto() {
		return auto;
	}
	
	public void setAuto(Auto auto) {
		this.auto = auto;
	}
	
	public Celular getCelular() {
		return celular;
	}
	
	public void setCelular(Celular celular) {
		this.celular = celular;
	}
	
	public void celularInicioEstacionamiento(ZonaDeEstacionamiento zona,RSem sem , Auto auto ,Celular celular) {
		celular.appInicioEstacionamiento(zona,sem, auto.getPatente(), celular);
	}
	
	public void celularFinEstacionamiento(ZonaDeEstacionamiento zona,RSem sem , Celular celular) {
		celular.appFinEstacionamiento(zona,sem, celular);
	}
	
	public void puntoDeVentaEstacionamiento(RSem sem ,int horas,PuntoDeVenta puntoVenta) {
		puntoVenta.compraPuntual(sem , this.getAuto(),horas);
	}
}

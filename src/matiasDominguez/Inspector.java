package matiasDominguez;

public class Inspector {

	
	private String nombre;
	private Celular celular;
	private ZonaDeEstacionamiento estacionamiento;
	private DispositivoMovil app = new DispositivoMovil();
	
	
	
	
	
	public Inspector(String nombre, Celular celular, ZonaDeEstacionamiento estacionamiento) {
		super();
		this.nombre = nombre;
		this.celular = celular;
		this.estacionamiento = estacionamiento;
	}

	
	
	public DispositivoMovil getApp() {
		return app;
	}



	public void setApp(DispositivoMovil app) {
		this.app = app;
	}



	public void appConsultaDeEstacionamientoVigente(RSem sem ,Inspector inspector,Auto auto) {
		app.consultaDeEstacionamientoVigente(sem,this,auto, getEstacionamiento());
	}
	
	
	
	
	
	
	public ZonaDeEstacionamiento getEstacionamiento() {
		return estacionamiento;
	}



	public void setEstacionamiento(ZonaDeEstacionamiento estacionamiento) {
		this.estacionamiento = estacionamiento;
	}
}

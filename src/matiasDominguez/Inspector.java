package matiasDominguez;

public class Inspector {

	
	private String nombre;
	private Celular celular;
	private ZonaDeEstacionamiento estacionamiento;
	
	
	
	
	
	public Inspector(String nombre, Celular celular, ZonaDeEstacionamiento estacionamiento) {
		super();
		this.nombre = nombre;
		this.celular = celular;
		this.estacionamiento = estacionamiento;
	}


	
	public void mandarConsulta( Auto auto, ZonaDeEstacionamiento estacionamiento) {
		AppInspector app = new AppInspector();
		app.consultaDeEstacionamientoVigente(auto,estacionamiento);
	}
	
	
	
	public void mandarInfraccion(Inspector this, Auto auto, ZonaDeEstacionamiento estacionamiento) {
		AppInspector app = new AppInspector();
		app.AltaDeInfraccion(this,auto,estacionamiento);
		
	}
	
	
	public ZonaDeEstacionamiento getEstacionamiento() {
		return estacionamiento;
	}



	public void setEstacionamiento(ZonaDeEstacionamiento estacionamiento) {
		this.estacionamiento = estacionamiento;
	}
}

package projectofinal.Usuarios;

import projectofinal.Dispositivos.Celular;
import projectofinal.Dispositivos.DispositivoMovil;
import projectofinal.Estacionamiento.ZonaDeEstacionamiento;
import projectofinal.Sem.Sem;


public class Inspector {

	private String nombre;
	private Celular celular;
	private ZonaDeEstacionamiento estacionamiento;
	private DispositivoMovil app = new DispositivoMovil(null);
	
	
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



	public void appConsultaDeEstacionamientoVigente(Sem sem ,Inspector inspector,Auto auto) {
		app.infraccionEstacionamientoVigente(sem,this,auto, getEstacionamiento());
	}
	
	
	public ZonaDeEstacionamiento getEstacionamiento() {
		return estacionamiento;
	}



	public void setEstacionamiento(ZonaDeEstacionamiento estacionamiento) {
		this.estacionamiento = estacionamiento;
	}
}

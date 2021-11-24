package projectofinal.Usuarios;

import projectofinal.Dispositivos.Celular;
import projectofinal.Estacionamiento.ZonaDeEstacionamiento;
import projectofinal.Sem.Sem;


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

	
	



	public void appConsultaDeEstacionamientoVigente(Sem sem ,Inspector inspector,Auto auto) {
		this.getCelular().getApp().infraccionEstacionamientoVigente(sem,this,auto, getEstacionamiento());
	}
	
	
	public ZonaDeEstacionamiento getEstacionamiento() {
		return estacionamiento;
	}



	public void setEstacionamiento(ZonaDeEstacionamiento estacionamiento) {
		this.estacionamiento = estacionamiento;
	}


	public Celular getCelular() {
		return celular;
	}


	public void setCelular(Celular celular) {
		this.celular = celular;
	}
}

package projectofinal.Dispositivos;

import projectofinal.Apps.App;
import projectofinal.Apps.AppCliente;
import projectofinal.Apps.ModoApp;
import projectofinal.Estacionamiento.ZonaDeEstacionamiento;
import projectofinal.Reloj.Reloj;
import projectofinal.Sem.Sem;

public class Celular {
	private int numero ; 
	private App app ;
	private Reloj reloj ;
	private ZonaDeEstacionamiento gps;


	public Celular( int numero,Reloj reloj) {
		super();
		this.numero = numero;
		this.reloj = reloj;
	}
	
	
	public void instalarApp(App app) {
		this.setApp(app);
	}

	public Reloj getReloj() {
		return reloj;
	}

	public ZonaDeEstacionamiento getGps() {
		return gps;
	}

	public void setGps(ZonaDeEstacionamiento gps) {
		this.gps = gps;
	}

	public void setReloj(Reloj reloj) {
		this.reloj = reloj;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}

	public void appInicioEstacionamiento(Sem sem,String patente) {
		app.inicioEstacionamiento(sem, patente, this);
	}
	
	
	public void appFinEstacionamiento(Sem sem) {
		app.finEstacionamiento(sem ,this);
		
	}

	public void cambiarModo(ModoApp modo) {
		app.cambiarAModo(modo);
		
	}
	
	public Boolean estaEnZonaDeEstacionamiento() {
		return !(this.getGps() == null); 
	}
	
	
	

}

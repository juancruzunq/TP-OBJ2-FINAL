package projectofinal;



public class Celular {
	private Integer numero ; 
	private AppCliente app = new AppCliente();
	private Reloj reloj ;
	private ZonaDeEstacionamiento gps;


	public Celular( int numero,Reloj reloj) {
		super();
		this.numero = numero;
		this.reloj = reloj;
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
	
	public AppCliente getApp() {
		return app;
	}

	public void setApp(AppCliente app) {
		this.app = app;
	}

	public void appInicioEstacionamiento(RSem sem,String patente) {
		app.inicioEstacionamiento(sem, patente, this);
	}
	
	public void appFinEstacionamiento(RSem sem) {
		app.finEstacionamiento(sem ,this);
	}

	public void cambiarModo(ModoApp modo) {
		app.cambiarAModo(modo);
		
	}
	
	public boolean estaEnZonaDeEstacionamiento() {
		return !(this.getGps() == null); 
	}
	
	
	/*HACER SUPER CLASE QUE LAS 2 CLASES HEREN EL RELOJ "*/

}

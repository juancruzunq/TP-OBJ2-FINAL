package matiasDominguez;



public class Celular {
	private Integer numero ; 
	private AppCliente app = new AppCliente();
	private Reloj reloj ;
	private boolean enZonaEstacionamiento = true;


	public Celular( int numero,Reloj reloj) {
		super();
		this.numero = numero;
		this.reloj = reloj;
	}

	public Reloj getReloj() {
		return reloj;
	}
	
	public boolean getEnZonaEstacionamiento() {
		return enZonaEstacionamiento;
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

	public void appInicioEstacionamiento(ZonaDeEstacionamiento zona, RSem sem,String patente,Celular celular) {
		app.inicioEstacionamiento(zona,sem, patente, celular);
	}
	
	public void appFinEstacionamiento(ZonaDeEstacionamiento zona, RSem sem ,Celular celular) {
		app.finEstacionamiento(zona,sem ,celular);
	}
	
	/*HACER SUPER CLASE QUE LAS 2 CLASES HEREN EL RELOJ "*/

}

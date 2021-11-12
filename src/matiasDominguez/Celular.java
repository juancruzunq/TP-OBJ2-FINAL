package matiasDominguez;

import java.util.ArrayList;

public class Celular {
	private int credito ;
	private Integer numero ; 
	private ArrayList <Integer> recargas ;
	private App app = new App();
	private Reloj reloj ;
	

	public ArrayList<Integer> getRecargas() {
		return recargas;
	}

	public void setRecarga(int monto) {
		this.recargas.add(monto);
	}


	public Celular(int credito, int numero,Reloj reloj) {
		super();
		this.credito = credito;
		this.numero = numero;
		this.reloj = reloj;
	}

	public Reloj getReloj() {
		return reloj;
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

	public int getCredito() {
		// TODO Auto-generated method stub
		return credito;
	}

	public void setCredito(int i) {
		// TODO Auto-generated method stub
		this.credito = i ;
	}
	
	
	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}

	public void appInicioEstacionamiento(ZonaDeEstacionamiento zona, RSem sem,String patente,Celular celular) {
		app.inicioEstacionamiento(zona,sem, patente, celular);
	}
	
	public void appFinEstacionamiento(ZonaDeEstacionamiento zona, RSem sem ,Celular celular) {
		app.finEstacionamiento(zona,sem ,celular);
	}

}

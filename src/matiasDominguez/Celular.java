package matiasDominguez;

import java.util.ArrayList;

public class Celular {
	private int credito ;
	private Integer numero ; 
	private ArrayList <Integer> recargas ;
	private App app = new App();
	
	

	public ArrayList<Integer> getRecargas() {
		return recargas;
	}

	public void setRecarga(int monto) {
		this.recargas.add(monto);
	}


	public Celular(int credito, int numero) {
		super();
		this.credito = credito;
		this.numero = numero;
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

	public void appInicioEstacionamiento(RSem sem,String patente,Celular celular,int horaActual) {
		app.inicioEstacionamiento(sem, patente, celular, horaActual);
	}
	
	public void appFinEstacionamiento(RSem sem ,Celular celular,int horaFin) {
		app.finEstacionamiento(sem ,celular,horaFin);
	}

}

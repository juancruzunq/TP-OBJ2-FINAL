package ar.edu.unq.po2.tpfinal;

public class Conductor {
	private Auto auto;
	private SEM sem;
	
	public void estacionarPorCompraPuntual(int horas) {
		sem.registrarEstacionamientoPuntual(this.auto.getPatente(), horas);
		
	}
}

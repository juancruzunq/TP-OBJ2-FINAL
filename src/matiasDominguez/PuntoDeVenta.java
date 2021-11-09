package matiasDominguez;

public class PuntoDeVenta {
	private Reloj reloj;
	private RSem sem;
	private ZonaDeEstacionamiento zona;
	
	public void recargarCelular(Celular celular, int monto) {
		celular.setSaldo(celular.getCredito() + monto);
		registrarRecargaCelular(celular, monto);
	}

	public void compraPuntual(Auto auto, int horas) {
		int horaFin = reloj.getHoraActual() + horas;
		REstacionamiento estacionamiento = new REstacionamientoPuntual(auto.getPatente(), reloj.getHoraActual(), horaFin, horas);
		zona.agregarVigente(estacionamiento);
		sem.registrarEstacionamiento(estacionamiento);
		registrarCompraPuntual(horas);
	}
	
	private void registrarCompraPuntual(int horas) {
		RRecarga registro = new RCompraPuntual(this, reloj.getFechaActual(), reloj.getHoraActual(), horas);
		sem.registrarCompra(registro);
		
	}

	private void registrarRecargaCelular(Celular celular, int monto) {
		RRecarga registro = new RRecargaCelular(this, reloj.getFechaActual(), reloj.getHoraActual(), monto, celular);
		sem.registrarCompra(registro);
	}
}

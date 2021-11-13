package matiasDominguez;


public class PuntoDeVenta {
	private Reloj reloj;
	private ZonaDeEstacionamiento zona;
	
	public void recargarCelular(RSem sem,Celular celular, int monto) {
		sem.setSaldo(celular ,sem.obtenerSaldo(celular) + monto);
		registrarRecargaCelular(null, celular, monto);
	}

	public Integer compraPuntual(RSem sem ,Auto auto, int horas) {
		int horaFin = reloj.getHoraActual() + horas;
		REstacionamiento estacionamiento = new REstacionamientoPuntual(auto.getPatente(), reloj.getHoraActual(), horaFin, horas);
		zona.agregarVigente(estacionamiento);
		sem.registrarEstacionamiento(estacionamiento);
		registrarCompraPuntual(sem, horas);
		
		return this.cobroPuntual(horas);
	}
	
	private Integer cobroPuntual(int horas) {
		// TODO Auto-generated method stub
		
		return horas*40;
	}

	private void registrarCompraPuntual(RSem sem,int horas) {
		RRecarga registro = new RCompraPuntual(this, reloj.getFechaActual(), reloj.getHoraActual(), horas);
		sem.registrarCompra(registro);
		
	}

	private void registrarRecargaCelular(RSem sem ,Celular celular, int monto) {
		RRecarga registro = new RRecargaCelular(this, reloj.getFechaActual(), reloj.getHoraActual(), monto, celular);
		sem.registrarCompra(registro);
		
		
	}
	
	
}

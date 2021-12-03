package projectofinal.Sem;

import projectofinal.Dispositivos.Celular;
import projectofinal.Dispositivos.RRecarga;
import projectofinal.Dispositivos.RRecargaCelular;
import projectofinal.Estacionamiento.REstacionamiento;
import projectofinal.Estacionamiento.REstacionamientoPuntual;
import projectofinal.Estacionamiento.ZonaDeEstacionamiento;
import projectofinal.Reloj.Reloj;
import projectofinal.Usuarios.Auto;

public class PuntoDeVenta {
	private Reloj reloj;
	private ZonaDeEstacionamiento zona;
	
	public PuntoDeVenta(Reloj reloj, ZonaDeEstacionamiento zona) {
		super();
		this.reloj = reloj;
		this.zona = zona;
	}

	public void recargarCelular(Sem sem,Celular celular, int monto) {
		sem.sumarSaldo(celular , monto);
		registrarRecargaCelular(sem, celular, monto);
	}

	public Integer compraPuntual(Sem sem ,Auto auto, int horas) {
		int horaFin = reloj.getHoraActual() + horas;
		REstacionamiento estacionamiento = new REstacionamientoPuntual(auto.getPatente(), reloj.getHoraActual(), horaFin, horas);
		zona.agregarVigente(estacionamiento);
		sem.registrarEstacionamiento(estacionamiento);
		registrarCompraPuntual(sem, horas);
		
		return this.cobroPuntual(horas);
	}
	
	private Integer cobroPuntual(int horas) {
		
		return horas*40;
	}

	private void registrarCompraPuntual(Sem sem,int horas) {
		RRecarga registro = new RCompraPuntual(this, reloj.getFechaActual(), reloj.getHoraActual(), horas);
		sem.registrarCompra(registro);
		
	}

	private void registrarRecargaCelular(Sem sem ,Celular celular, int monto) {
		RRecarga registro = new RRecargaCelular(this, reloj.getFechaActual(), reloj.getHoraActual(), monto, celular);
		sem.registrarCompra(registro);
	}

	public ZonaDeEstacionamiento getZona() {
		return zona;
	}
	
}

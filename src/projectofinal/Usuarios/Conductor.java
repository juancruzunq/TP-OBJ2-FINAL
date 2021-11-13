package projectofinal.Usuarios;

import projectofinal.Apps.ModoApp;
import projectofinal.Dispositivos.Celular;
import projectofinal.Sem.PuntoDeVenta;
import projectofinal.Sem.Sem;


public class Conductor {
	
	private Auto auto;
	private Celular celular;
	
	
	public Conductor(Auto auto, Celular celular) {
		super();
		this.auto = auto;
		this.celular = celular;
	}

	public Auto getAuto() {
		return auto;
	}
	
	public void setAuto(Auto auto) {
		this.auto = auto;
	}
	
	public Celular getCelular() {
		return celular;
	}
	
	public void setCelular(Celular celular) {
		this.celular = celular;
	}
	
	public void celularInicioEstacionamiento(Sem sem) {
		celular.appInicioEstacionamiento(sem, this.getAuto().getPatente());
	}
	
	public void celularFinEstacionamiento(Sem sem) {
		celular.appFinEstacionamiento(sem);
	}
	
	public void puntoDeVentaEstacionamiento(Sem sem ,int horas,PuntoDeVenta puntoVenta) {
		puntoVenta.compraPuntual(sem , this.getAuto(),horas);
	}
	
	public void celularCambiarModo(ModoApp modo) {
		celular.cambiarModo(modo);
	}
	
	public Integer obtenerSaldo(Sem sem) {
		
		return sem.obtenerSaldo(celular);
	}
}

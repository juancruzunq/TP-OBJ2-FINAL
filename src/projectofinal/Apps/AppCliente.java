package projectofinal.Apps;

import java.util.ArrayList;

import projectofinal.Dispositivos.Celular;
import projectofinal.Estacionamiento.REstacionamiento;
import projectofinal.Estacionamiento.REstacionamientoApp;
import projectofinal.Estacionamiento.ZonaDeEstacionamiento;
import projectofinal.Sem.RSem;




public class AppCliente implements MovementSensor {

	private ModoApp modoApp ;
	private ModoMovimiento modoMovimiento;
	private Boolean estaVigente ;
	

	public void inicioEstacionamiento(RSem sem, String patente, Celular celular) {
		ZonaDeEstacionamiento zona = celular.getGps();
		REstacionamientoApp estacionamiento = new REstacionamientoApp(patente,celular.getReloj().getHoraActual() ,0, celular);
		sem.registrarEstacionamiento(estacionamiento);
		zona.agregarVigente(estacionamiento);
		mensajeInicioEstacionamiento(sem,celular);
		this.setEstaVigente(true);
	}

	public void finEstacionamiento(RSem sem, Celular celular) {
		ZonaDeEstacionamiento zona = celular.getGps();
		Integer numTel = celular.getNumero();
		ArrayList<REstacionamiento> registros = zona.getEstacionamientosVigentes();
		REstacionamiento estacionamiento = (REstacionamiento) registros.stream().filter(r -> r.getCelularNumero().equals(numTel));
		zona.finalizarEstacionamientoVigente(estacionamiento);
		sem.setSaldo(celular,(sem.obtenerSaldo(celular) - costoEstacionamiento(estacionamiento)));
		mensajeFinEstacionamiento(estacionamiento,celular);
		this.setEstaVigente(false);
	}
	
	
	private StringBuffer mensajeInicioEstacionamiento(RSem sem , Celular celular) {
		StringBuffer mensaje= new StringBuffer();  
		
		if(sem.obtenerSaldo(celular) < 40) {
			 mensaje.append("Saldo Insuficiente.Estacionamiento no Permitido");
			
		}
		else {
			
			mensaje.append("Hora Inicio Estacionamiento :"); 
			mensaje.append(celular.getReloj().formatoControlador(celular.getReloj().getHoraActual())); 
			mensaje.append("Hora Maxima Fin Estacionamiento :");
			mensaje.append(this.horaMaximaControlador(sem,celular));
		}
		return mensaje;
	}
	
	private StringBuffer mensajeFinEstacionamiento(REstacionamiento estacionamiento, Celular celular) {
		StringBuffer mensaje = new StringBuffer();
		mensaje.append("Hora Inicio Estacionamiento :"); 
		mensaje.append(estacionamiento.getHoraInicio()); 
		mensaje.append("Hora Fin Estacionamiento :");
		mensaje.append(celular.getReloj().getHoraActual());
		mensaje.append("Horas Totales Estacionamiento");
		mensaje.append(estacionamiento.getHoraFin()-estacionamiento.getHoraInicio());
		mensaje.append("Costo Estacionamiento");
		mensaje.append(costoEstacionamiento(estacionamiento));
		return mensaje;
	}
	

	private StringBuffer horaMaximaControlador(RSem sem, Celular celular) {
		StringBuffer mensaje = new StringBuffer();
		Integer credito = sem.obtenerSaldo(celular);
		int tiempoDisponible = (credito / 40);
		Integer horaMaxima = celular.getReloj().getHoraActual() + tiempoDisponible; 
		if(horaMaxima>20) {
			mensaje.append("20:00");
		}
		else {
			StringBuffer horaActual = celular.getReloj().formatoControlador(horaMaxima);
			mensaje.append(horaActual);
		}
		return mensaje;
	}
	
	private Integer costoEstacionamiento(REstacionamiento estacionamiento) {
		
		return (estacionamiento.getHoraFin()-estacionamiento.getHoraInicio())*40;
	}
	
	
	public ModoApp getModoApp() {
		return modoApp;
	}

	public ModoMovimiento getModoMovimiento() {
		return modoMovimiento;
	}

	public void setModoApp(ModoApp modoApp) {
		this.modoApp = modoApp;
	}

	public void setModoMovimiento(ModoMovimiento modoMovimiento) {
		this.modoMovimiento = modoMovimiento;
	}

	@Override
	public void driving(RSem sem, Celular celular) {
		if(modoMovimiento==ModoMovimiento.Walking && this.getEstaVigenteEnMismaZona(celular)) {
			this.setModoMovimiento(ModoMovimiento.Driving);
			if(modoApp==ModoApp.Automatico) {
				this.finEstacionamiento(sem, celular);
				this.alerta("Se detuvo el Estacionamiento Vigente");
			}
			else {
				this.alerta("Posible fin de Estacionamiento");
			}
		}
		
	}

	
	private boolean getEstaVigenteEnMismaZona(Celular celular) {
		return celular.getGps().hayEstacionamientoVigenteApp(celular.getNumero());
	}

	@Override
	public void walking(RSem sem, String patente, Celular celular) {
		if(modoMovimiento==ModoMovimiento.Driving && !this.getEstaVigente() && celular.estaEnZonaDeEstacionamiento()) {
			this.setModoMovimiento(ModoMovimiento.Walking);
			if(modoApp==ModoApp.Automatico) {
				this.inicioEstacionamiento(sem, patente, celular);
				this.alerta("Se inicio un Estacionamiento ");
			}
			else {
				this.alerta("Posible inicio de Estacionamiento");
			}
		}
		
	}

	private String alerta(String string) {
		
		return string;
		
	}
	
	public Boolean getEstaVigente() {
		return estaVigente;
	}

	public void setEstaVigente(Boolean estaVigente) {
		this.estaVigente = estaVigente;
	}

	public void cambiarAModo(ModoApp modo) {
		this.setModoApp(modo);
		
	}
	
}

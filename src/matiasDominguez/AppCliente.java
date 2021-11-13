package matiasDominguez;

import java.util.ArrayList;

public class AppCliente implements MovementSensor,Gps   {

	private ModoApp modoApp ;
	private ModoMovimiento modoMovimiento;
	private Boolean estaVigente ;
	

	
	

	

	public void inicioEstacionamiento(ZonaDeEstacionamiento zona, RSem sem, String patente, Celular celular) {
		// TODO Auto-generated method stub
		
			REstacionamientoApp estacionamiento = new REstacionamientoApp(patente,celular.getReloj().getHoraActual() ,0, celular);
			sem.registrarEstacionamiento(estacionamiento);
			zona.agregarVigente(estacionamiento);
			mensajeInicioEstacionamiento(sem,celular);
			this.setEstaVigente(true);
		
	}

	public void finEstacionamiento(ZonaDeEstacionamiento zona  ,RSem sem, Celular celular) {
		// TODO Auto-generated method stub
		Integer numTel = celular.getNumero();
		ArrayList<REstacionamiento> registros = zona.getEstacionamientosVigentes();
		REstacionamiento estacionamiento = (REstacionamiento) registros.stream().filter(r -> r.getCelularNumero().equals(numTel));
		zona.finalizarEstacionamientoVigente(estacionamiento);
		sem.setSaldo(celular,(sem.obtenerSaldo(celular) - costoEstacionamiento(estacionamiento)));
		mensajeFinEstacionamiento(estacionamiento,zona,celular);
		this.setEstaVigente(false);
	}
	
	
	private StringBuffer mensajeInicioEstacionamiento(RSem sem , Celular celular) {
		StringBuffer mensaje= new StringBuffer();  
		
		if(sem.obtenerSaldo(celular) <40) {
			 mensaje.append("Saldo Insuficiente.Estacionamiento no Permitido");
			
		}
		else {
			
			mensaje.append("Hora Inicio Estacionamiento :"); 
			mensaje.append(celular.getReloj().formatoControlador(celular.getReloj().getHoraActual())); 
			mensaje.append("Hora Maxima Fin Estacionamiento :");
			mensaje.append(this.horaMaximaControlador(sem,celular));
		}
		return mensaje ;
	}
	
	private StringBuffer mensajeFinEstacionamiento(REstacionamiento estacionamiento, ZonaDeEstacionamiento zona, Celular celular) {
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
	
	
	
	public void cambiarModoApp() {
		ModoApp modo= null;
		switch (modoApp) {
		case Automatico:
			modo = ModoApp.Manual;
			
			break;

		default:
			modo = ModoApp.Automatico;
		}
		
		this.modoApp= modo;
	}
	
	public void cambiarModoMovimiento() {
		ModoMovimiento modo= null;
		switch (modoMovimiento) {
		case Driving:
			modo = ModoMovimiento.Walking;
			
			break;

		default:
			modo = ModoMovimiento.Driving;
		}
		
		this.modoMovimiento= modo;
	}

	@Override
	public void driving(ZonaDeEstacionamiento zona  ,RSem sem, Celular celular) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if(modoApp==ModoApp.Automatico && modoMovimiento==ModoMovimiento.Walking && this.getEstaVigente()) {
			cambiarModoMovimiento();
			this.finEstacionamiento(zona, sem, celular);
			this.alerta("Se detuvo el Estacionamiento Vigente");
		}
		
		
	}
	
	

	
	@Override
	public void walking(ZonaDeEstacionamiento zona, RSem sem, String patente, Celular celular) {
		// TODO Auto-generated method stub
		if(modoApp==ModoApp.Automatico && modoMovimiento==ModoMovimiento.Driving && !this.getEstaVigente()) {
			cambiarModoMovimiento();
			this.inicioEstacionamiento(zona, sem, patente, celular);
			this.alerta("Se inicio un  Estacionamiento ");
		}
		
		
	}

	private String alerta(String string) {
		// TODO Auto-generated method stub
		
		return string;
		
	}

	@Override
	public void enZonaDeEstacionamiento() {
		// TODO Auto-generated method stub
	
	}
	
	public Boolean getEstaVigente() {
		return estaVigente;
	}

	public void setEstaVigente(Boolean estaVigente) {
		this.estaVigente = estaVigente;
	}

	

	
	
	
	
}

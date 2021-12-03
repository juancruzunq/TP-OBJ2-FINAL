package projectofinal.Apps;


import java.util.ArrayList;
import projectofinal.Dispositivos.Celular;
import projectofinal.Estacionamiento.REstacionamiento;
import projectofinal.Estacionamiento.REstacionamientoApp;
import projectofinal.Estacionamiento.ZonaDeEstacionamiento;
import projectofinal.Reloj.Reloj;
import projectofinal.Sem.Sem;
import projectofinal.Usuarios.Auto;
import projectofinal.Usuarios.Inspector;


public class AppCliente extends App implements  MovementSensor {

	private ModoApp modoApp ;
	private ModoMovimiento modoMovimiento;
	private Boolean estaVigente ;
	

	public void inicioEstacionamiento(Sem sem, String patente, Celular celular) {
		ZonaDeEstacionamiento zona = celular.getGps();
		REstacionamientoApp estacionamiento = new REstacionamientoApp(patente,celular.getReloj().getHoraActual() ,this.horaMaximaControlador(sem, celular), celular);
		sem.registrarEstacionamiento(estacionamiento);
		zona.agregarVigente(estacionamiento);
		mensajeInicioEstacionamiento(sem,celular);
		this.setEstaVigente(true);
	}
	
	
	public void finEstacionamiento(Sem sem, Celular celular) {
		ZonaDeEstacionamiento zona = celular.getGps();
		Integer numTel = celular.getNumero();
		ArrayList<REstacionamiento> registros = zona.getEstacionamientosVigentes();
		REstacionamiento estacionamiento =  registros.stream().filter(r -> r.getCelularNumero().equals(numTel)).findFirst().get();
		zona.finalizarEstacionamientoVigente(estacionamiento);
		sem.setSaldo(celular,(sem.obtenerSaldo(celular) - costoEstacionamiento(estacionamiento)));
		mensajeFinEstacionamiento(estacionamiento,celular);
		this.setEstaVigente(false);
	}
	
	
	
	
	
	private String mensajeInicioEstacionamiento(Sem sem , Celular celular) {
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
		return mensaje.toString();
	}
	
	private String mensajeFinEstacionamiento(REstacionamiento estacionamiento, Celular celular) {
		StringBuffer mensaje = new StringBuffer();
		mensaje.append("Hora Inicio Estacionamiento :"); 
		mensaje.append(estacionamiento.getHoraInicio()); 
		mensaje.append("Hora Fin Estacionamiento :");
		mensaje.append(celular.getReloj().getHoraActual());
		mensaje.append("Horas Totales Estacionamiento");
		mensaje.append(estacionamiento.getHoraFin()-estacionamiento.getHoraInicio());
		mensaje.append("Costo Estacionamiento");
		mensaje.append(costoEstacionamiento(estacionamiento));
		return mensaje.toString();
	}
	

	private Integer horaMaximaControlador(Sem sem, Celular celular) {
		Integer credito = sem.obtenerSaldo(celular);
		int tiempoDisponible = (credito / 40) * 100;
		Integer horaMaxima = celular.getReloj().getHoraActual() + tiempoDisponible; 
		if(horaMaxima>2000) {
			horaMaxima = 2000;
		}
		return horaMaxima;
	}
	
	private Integer costoEstacionamiento(REstacionamiento estacionamiento) {
		
		return (estacionamiento.getHoraFin() - estacionamiento.getHoraInicio()) / 100 *40;
	}
	
	
	public ModoApp getModoApp() {
		return modoApp;
	}

	public void setModoApp(ModoApp modoApp) {
		this.modoApp = modoApp;
	}

	public void setModoMovimiento(ModoMovimiento modoMovimiento) {
		this.modoMovimiento = modoMovimiento;
	}

	@Override
	public void driving(Sem sem, Celular celular) {
		this.cambiarModoMovimientoA(new Driving(this), sem, celular, null);
			
	}
	
	@Override
	public void walking(Sem sem, String patente, Celular celular) {
		this.cambiarModoMovimientoA(new Walking(this), sem, celular, patente);
			
	}

	
	private void cambiarModoMovimientoA(ModoMovimiento modo, Sem sem, Celular celular, String patente) {
		this.setModoMovimiento(modo);
		this.modoMovimiento.posibleInicioOFinEstacionamiento(sem, celular, patente);
	}


	public Boolean getEstaVigenteEnMismaZona(Celular celular) {
		return celular.getGps().hayEstacionamientoVigenteApp(celular.getNumero());
	}

	public String alerta(String string) {
		
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

	public  AppCliente(Reloj reloj,ModoApp modoApp, ModoMovimiento modoMovimiento, Boolean estaVigente) {
		this.modoApp = modoApp;
		this.modoMovimiento = modoMovimiento;
		this.estaVigente = estaVigente;
	}
	
	
	
	@Override
	public void infraccionEstacionamientoVigente(Sem sem ,Inspector inspector,Auto auto, ZonaDeEstacionamiento estacionamiento) {
		this.alerta("Usuario denegado sin permiso de admin");
		
	}

	
	@Override
	public boolean consultaDeEstacionamientoVigente(Auto auto, ZonaDeEstacionamiento estacionamiento) {
		this.alerta("Usuario denegado sin permiso de admin");
		return false;
	}
	
	@Override
	public ArrayList<REstacionamiento> estacionamientosVigentes(ZonaDeEstacionamiento estacionamiento) {
		this.alerta("Usuario denegado sin permiso de admin");
		return new ArrayList<REstacionamiento>();
	}

	
}

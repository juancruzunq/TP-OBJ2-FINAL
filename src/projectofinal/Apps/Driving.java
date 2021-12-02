package projectofinal.Apps;

import projectofinal.Dispositivos.Celular;
import projectofinal.Sem.Sem;

public class Driving extends ModoMovimiento {

	public Driving(AppCliente app) {
		super(app);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void posibleInicioEstacionamiento(Sem sem, Celular celular, String patente) {
		
		
	}

	@Override
	public void posibleFinEstacionamiento(Sem sem, Celular celular) {
		if(this.getApp().getEstaVigenteEnMismaZona(celular)) {
			this.getApp().getModoApp().ejecutarFinalizacion(sem, celular, this.getApp());
		}
		
	}



}

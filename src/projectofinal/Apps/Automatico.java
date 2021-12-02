package projectofinal.Apps;

import projectofinal.Dispositivos.Celular;
import projectofinal.Sem.Sem;

public class Automatico implements ModoApp {

	@Override
	public void ejecutarIniciacion(Sem sem, Celular celular, String patente, AppCliente app) {
		app.inicioEstacionamiento(sem,patente,celular);
		app.alerta("Se inicio un estacionamiento");
		
	}

	@Override
	public void ejecutarFinalizacion(Sem sem, Celular celular, AppCliente app) {
		app.finEstacionamiento(sem,celular);
		app.alerta("Se finalizo un estacionamiento");
		
	}

}

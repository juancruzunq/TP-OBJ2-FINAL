package projectofinal.Apps;

import projectofinal.Dispositivos.Celular;
import projectofinal.Sem.Sem;

public abstract class ModoMovimiento {
	private AppCliente app;
	
	public ModoMovimiento(AppCliente app) {
		this.app = app;
	}
		
	public abstract void posibleInicioEstacionamiento(Sem sem, Celular celular, String patente);
	
	public abstract void posibleFinEstacionamiento(Sem sem, Celular celular);

	public AppCliente getApp() {
		return app;
	}

	
	
}
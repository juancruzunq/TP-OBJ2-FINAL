package projectofinal.Apps;

import projectofinal.Dispositivos.Celular;
import projectofinal.Sem.Sem;

public abstract class ModoMovimiento {
	private AppCliente app;
	
	public ModoMovimiento(AppCliente app) {
		this.app = app;
	}


	public AppCliente getApp() {
		return app;
	}

	protected abstract void posibleInicioOFinEstacionamiento(Sem sem, Celular celular, String patente);

	
	
}
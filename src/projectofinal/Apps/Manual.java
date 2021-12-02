package projectofinal.Apps;

import projectofinal.Dispositivos.Celular;
import projectofinal.Sem.Sem;

public class Manual implements ModoApp{

	@Override
	public void ejecutarIniciacion(Sem sem, Celular celular, String patente, AppCliente app) {
		app.alerta("Posible inicio");
		
	}

	@Override
	public void ejecutarFinalizacion(Sem sem, Celular celular, AppCliente app) {
		app.alerta("Posible finalizacion");
		
	}

}

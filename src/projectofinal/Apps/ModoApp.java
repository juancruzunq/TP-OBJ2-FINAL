package projectofinal.Apps;

import projectofinal.Dispositivos.Celular;
import projectofinal.Sem.Sem;

public interface ModoApp {

	
	public void ejecutarIniciacion(Sem sem ,Celular celular, String patente,AppCliente app);

	public void ejecutarFinalizacion(Sem sem, Celular celular,AppCliente app);
}


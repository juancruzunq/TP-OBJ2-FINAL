package projectofinal.Apps;

import projectofinal.Dispositivos.Celular;
import projectofinal.Sem.Sem;


public interface MovementSensor {
	
	
	public void walking(Sem sem, String patente, Celular celular);



	public void driving(Sem sem, Celular celular);
}

package projectofinal.Apps;

import projectofinal.Dispositivos.Celular;
import projectofinal.Sem.Sem;

public class Walking extends ModoMovimiento{

	public Walking(AppCliente app) {
		super(app);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void posibleInicioOFinEstacionamiento(Sem sem, Celular celular, String patente) {
		if(!this.getApp().getEstaVigente() && celular.estaEnZonaDeEstacionamiento()) {
			this.getApp().getModoApp().ejecutarIniciacion(sem, celular, patente, this.getApp());
		}
		
	}

}

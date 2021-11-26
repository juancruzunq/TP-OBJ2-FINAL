package projectofinal.Apps;

import projectofinal.Dispositivos.Celular;
import projectofinal.Sem.Sem;

public enum ModoApp {

	MANUAL {
		@Override
		public void ejecutarIniciacion(Sem sem,Celular celular,String patente ,AppCliente app) {
			app.alerta("Posible inicio");
		}

		@Override
		public void ejecutarFinalizacion(Sem sem,Celular celular,AppCliente app) {
			app.alerta("Posible finalizacion");
		}
	}, 
	
	AUTOMATICO {
		
		
		@Override
		public void ejecutarIniciacion(Sem sem ,Celular celular, String patente,AppCliente app) {
			app.inicioEstacionamiento(sem,patente,celular);
			app.alerta("Se inicio un estacionamiento");
		}

		@Override
		public void ejecutarFinalizacion(Sem sem, Celular celular,AppCliente app) {
			app.finEstacionamiento(sem,celular);
			app.alerta("Se finalizo un estacionamiento");
		}
	};

	public abstract void ejecutarIniciacion(Sem sem ,Celular celular, String patente,AppCliente app);

	public abstract void ejecutarFinalizacion(Sem sem, Celular celular,AppCliente app);
}


package projectofinal.Apps;

import projectofinal.Dispositivos.Celular;
import projectofinal.Sem.Sem;

public enum ModoApp {
	
	
	MANUAL {
		@Override
		void ejecutarIniciacion(Sem sem,Celular celular,String patente ,AppCliente app) {
			app.alerta("Posible inicio");
		}

		@Override
		void ejecutarFinalizacion(Sem sem,Celular celular,AppCliente app) {
			app.alerta("Posible finalizacion");
		}
	}, AUTOMATICO {
		
		
		@Override
		void ejecutarIniciacion(Sem sem ,Celular celular, String patente,AppCliente app) {
			app.inicioEstacionamiento(sem,patente,celular);
			app.alerta("Se inicio un estacionamiento");
		}

		@Override
		void ejecutarFinalizacion(Sem sem, Celular celular,AppCliente app) {
			app.finEstacionamiento(sem,celular);
			app.alerta("Se finalizo un estacionamiento");
		}
	};

	abstract void ejecutarIniciacion(Sem sem ,Celular celular, String patente,AppCliente app);

	abstract void ejecutarFinalizacion(Sem sem, Celular celular,AppCliente app);
}
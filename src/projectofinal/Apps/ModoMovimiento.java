package projectofinal.Apps;

import projectofinal.Dispositivos.Celular;
import projectofinal.Sem.Sem;

public enum ModoMovimiento {
	
	Driving {
		
		@Override
		void cambiarAWalking(AppCliente app, Sem sem, String patente, Celular celular) {
			if(!app.getEstaVigente() && celular.estaEnZonaDeEstacionamiento()) {
				app.setModoMovimiento(ModoMovimiento.Walking);
				app.getModoApp().ejecutarIniciacion(sem, celular, patente, app);
			}
		}

		@Override
		void cambiarADriving(AppCliente app, Sem sem, Celular celular) {
			
		}
	}, 
	
	Walking {
		
		@Override
		void cambiarAWalking(AppCliente app, Sem sem, String patente, Celular celular) {
			
		}

		@Override
		void cambiarADriving(AppCliente app, Sem sem, Celular celular) {
			if(app.getEstaVigenteEnMismaZona(celular)) {
				app.setModoMovimiento(ModoMovimiento.Driving);
				app.getModoApp().ejecutarFinalizacion(sem, celular, app);
			}
		}
	};

	
	abstract void cambiarAWalking(AppCliente app, Sem sem, String patente, Celular celular);

	abstract void cambiarADriving(AppCliente app, Sem sem, Celular celular);
}
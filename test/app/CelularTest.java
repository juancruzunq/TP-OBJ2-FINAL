package app;



import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projectofinal.Apps.AppCliente;
import projectofinal.Apps.ModoApp;
import projectofinal.Apps.ModoMovimiento;
import projectofinal.Dispositivos.Celular;
import projectofinal.Estacionamiento.ZonaDeEstacionamiento;
import projectofinal.Reloj.Reloj;
import projectofinal.Sem.PuntoDeVenta;
import projectofinal.Sem.Sem;
import projectofinal.Usuarios.Conductor;


public class CelularTest {
	
	//SE TESTEA DE LA CLASE CELULAR LOS METHODS GET Y EL SET DE INSTALAR APP . LOS METHODS QUE DELEGAN EN APP , SE TESTEARAN EN AppTest //
	
	private Integer numero ; 
	private AppCliente app ;
	private Reloj reloj ;
	private ZonaDeEstacionamiento gps;
	private Celular celular ;
	private Sem sem ;
	private PuntoDeVenta puntoDeVenta ;
	private Conductor conductor;
	
	
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() throws Exception {
		numero = 1131263742;
		reloj = new Reloj(2000, new Date(25, 11, 2021));
		app = new AppCliente(reloj, ModoApp.MANUAL, ModoMovimiento.Walking, true);
		celular = new Celular(numero, reloj);
		celular.instalarApp(app);
		gps = new ZonaDeEstacionamiento();
		celular.setGps(gps);
		sem = new Sem();
		puntoDeVenta = new PuntoDeVenta(reloj, gps);
		conductor = new Conductor(null, celular);
	}
	
	
	@Test
	public void test_Cambiar_Modo() {
		
		assertTrue(ModoApp.MANUAL==app.getModoApp());
		celular.cambiarModo(ModoApp.AUTOMATICO);
		assertEquals(ModoApp.AUTOMATICO,app.getModoApp());
		
	}
	
	@Test
	public void test_metodos_gets() {
		assertEquals(true,celular.estaEnZonaDeEstacionamiento());
		assertTrue(numero==celular.getNumero());
		assertEquals(app.getClass(),celular.getApp().getClass());
		assertEquals(gps.getClass(),celular.getGps().getClass());
		assertTrue(celular.getReloj().getHoraActual()==2000);
	}
	
	
	@Test
	public void test() {
		puntoDeVenta.recargarCelular(sem, celular, 100);
		assertEquals(conductor.obtenerSaldo(sem), 100);
	}
	
}

package app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projectofinal.Apps.AppCliente;
import projectofinal.Apps.Automatico;
import projectofinal.Apps.Driving;
import projectofinal.Apps.Manual;
import projectofinal.Apps.ModoApp;
import projectofinal.Apps.Walking;
import projectofinal.Dispositivos.Celular;
import projectofinal.Estacionamiento.ZonaDeEstacionamiento;
import projectofinal.Reloj.Reloj;
import projectofinal.Sem.PuntoDeVenta;
import projectofinal.Sem.Sem;
import projectofinal.Usuarios.Auto;
import projectofinal.Usuarios.Conductor;

public class AppClienteTest {
	private AppCliente app; //SUT
	private Integer numero; //DOC ---
	private Reloj reloj;
	private ZonaDeEstacionamiento zona;
	private Celular celular;
	private Sem sem;
	private PuntoDeVenta puntoDeVenta;
	private Conductor conductor;
	private Auto auto;
	private ModoApp modoManual;
	private ModoApp modoAutomatico;
	
	@BeforeEach //SetUp
	public void setUp() throws Exception {
		numero = 1131263742;
		modoManual = mock(Manual.class);
		modoAutomatico = mock(Automatico.class);
		reloj = mock(Reloj.class);
		app = new AppCliente(reloj, modoManual, new Walking(app), false);
		celular = mock(Celular.class);
		sem = mock(Sem.class);
		zona = mock(ZonaDeEstacionamiento.class);
		puntoDeVenta = mock(PuntoDeVenta.class);
		conductor = mock(Conductor.class);
		auto = mock(Auto.class);
	}
	
	@Test
	public void posibleInicioTest() {
		//Exercise
		when(conductor.getAuto()).thenReturn(auto);
		when(auto.getPatente()).thenReturn("1");
		when(celular.getGps()).thenReturn(zona);
		when(celular.estaEnZonaDeEstacionamiento()).thenReturn(true);
		app.cambiarAModo(modoAutomatico);
		app.driving(sem, celular);
		app.walking(sem, "1", celular);
		//Assert
		verify(modoAutomatico).ejecutarIniciacion(sem, celular, "1", app);
	}
	
	@Test
	public void posibleFinalizacionTest() {
		//Exercise
		when(conductor.getAuto()).thenReturn(auto);
		when(auto.getPatente()).thenReturn("1");
		when(celular.getGps()).thenReturn(zona);
		when(celular.estaEnZonaDeEstacionamiento()).thenReturn(true);
		when(zona.hayEstacionamientoVigenteApp(celular.getNumero())).thenReturn(true);
		app.cambiarAModo(modoAutomatico);
		app.driving(sem, celular);
		//Assert
		verify(modoAutomatico).ejecutarFinalizacion(sem, celular, app);
	}
	
	@Test 
	public void usoDeMensajesAdminEnCliente() {
		//Assert
		assertFalse(app.consultaDeEstacionamientoVigente(auto, zona));
		assertEquals(app.estacionamientosVigentes(zona).size(), 0);
		
	}
}

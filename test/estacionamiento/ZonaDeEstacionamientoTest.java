package estacionamiento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projectofinal.Apps.App;
import projectofinal.Apps.AppCliente;
import projectofinal.Apps.Manual;
import projectofinal.Apps.ModoApp;
import projectofinal.Apps.ModoMovimiento;
import projectofinal.Apps.Walking;
import projectofinal.Dispositivos.Celular;
import projectofinal.Estacionamiento.REstacionamiento;
import projectofinal.Estacionamiento.ZonaDeEstacionamiento;
import projectofinal.Reloj.Reloj;
import projectofinal.Sem.PuntoDeVenta;
import projectofinal.Sem.Sem;
import projectofinal.Usuarios.Auto;
import projectofinal.Usuarios.Conductor;
import projectofinal.Usuarios.Inspector;



public class ZonaDeEstacionamientoTest {
	
		private Inspector inspector;
		private Celular celular;
		private App app;
		private PuntoDeVenta puntoDeVenta1;
		private PuntoDeVenta puntoDeVenta2;
		private Auto auto;
		private Auto auto1;
		private Reloj reloj;
		private Integer numero;
		private ZonaDeEstacionamiento gps;
		private Conductor conductor;
		private Celular celularCliente;
		private AppCliente appCliente;
		private Integer numeroCliente;
		private REstacionamiento carga;
		private REstacionamiento carga1;
		private Sem sem;
		
		
	
	
	
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() throws Exception {
		
		
		sem = new Sem();
		app = new App();
	    gps = new ZonaDeEstacionamiento();
	    gps.setInspector(inspector);
	    auto = new Auto("HTY 310");
	    auto1 = new Auto ("TDK 220");
		numero = 1140263842;
		reloj = new Reloj(1400, new Date(2, 12, 2021));
		celular = new Celular(numero,reloj);
		celular.setGps(gps);
		celular.setApp(app);
		inspector = new Inspector("Jorge", celular, gps);
		
		appCliente = new AppCliente(reloj, new Manual(), new Walking(appCliente),false);
		numeroCliente =1140229842;
		celularCliente = new Celular(1140229842,reloj);
		celularCliente.instalarApp(appCliente);
		celularCliente.setGps(gps);
		conductor = new Conductor(auto,celularCliente);
		
		 carga = new REstacionamiento(auto.getPatente(), 1400, 1600);
		 carga1 = new REstacionamiento(auto1.getPatente(), 1600, 1800);
	}
	
	
	
	
	@Test 
	public void finalizarEstacionamiento() {
		
		 
		 
		 gps.agregarVigente(carga);
		 gps.agregarVigente(carga1);
		 
		 assertEquals(2,gps.getEstacionamientosVigentes().size());
		 
		 gps.finalizarEstacionamiento();
		 
		 assertTrue(gps.getEstacionamientosVigentes().size() == 0);
		 
	}
	
	
	@Test
	public void agregarPuntoDeVenta() {
		
		gps.agregarPuntoDeVenta(puntoDeVenta1);
		gps.agregarPuntoDeVenta(puntoDeVenta2);
		
		assertEquals(2,gps.getPuntosDeVenta().size());
	}
	
	
	@Test 
	public void esEstacionamientoVigente() {
		
		
		 
		gps.agregarVigente(carga);
		gps.agregarVigente(carga1); 
		
		assertEquals(true,gps.esEstacionamientoVigente(auto.getPatente()));
	}
	
	
	@Test
	public void estacionamientoVigenteApp() {
		
		conductor.celularInicioEstacionamiento(sem);
		assertEquals(true,gps.hayEstacionamientoVigenteApp(1140229842));
	}
	
	
	// falla?
	@Test 
	public void horaActualizada() {
		
		
		
		gps.agregarVigente(carga);
		gps.agregarVigente(carga1); 
		
		gps.horaActualizada(2000);
		
		assertEquals(1,gps.getEstacionamientosVigentes().size());
		
		
	}
}

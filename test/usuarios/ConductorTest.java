package usuarios;

import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import projectofinal.Apps.AppCliente;
import projectofinal.Apps.Automatico;
import projectofinal.Apps.Manual;
import projectofinal.Apps.Walking;
import projectofinal.Dispositivos.Celular;
import projectofinal.Estacionamiento.ZonaDeEstacionamiento;
import projectofinal.Reloj.Reloj;
import projectofinal.Sem.PuntoDeVenta;
import projectofinal.Sem.Sem;
import projectofinal.Usuarios.Auto;
import projectofinal.Usuarios.Conductor;


public class ConductorTest {
	
	private Auto auto;
	private String patente;
	private Celular celular;
	private Integer numero;
	private AppCliente app;
	private Reloj reloj;
	private ZonaDeEstacionamiento gps;
	private Sem sem ;
	private PuntoDeVenta puntoDeVenta ;
	private Conductor conductor;
	
	
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() throws Exception {
		
		numero = 1137264742;
		patente = "JLF 720";
		
		auto = new Auto(patente);
		reloj = new Reloj(1600, new Date(30, 11, 2021));
		app = new AppCliente(reloj, new Manual(), new Walking(app), false);
		celular = new Celular(numero, reloj);
		celular.instalarApp(app);
		gps = new ZonaDeEstacionamiento();
		celular.setGps(gps);
		sem = new Sem();
		puntoDeVenta = new PuntoDeVenta(reloj, gps);
		conductor = new Conductor(auto, celular);
			
	}
	
	@Test
	public void test_metodos_getYSet() {
		
		Auto auto2 = new Auto("HOL 380");
		Celular celular2 = new Celular(1137764790,reloj);
		celular2.instalarApp(app);
		celular2.setGps(gps);
		
		
		assertEquals(auto.getClass(),conductor.getAuto().getClass());
		assertEquals(celular.getClass(),conductor.getCelular().getClass());
		assertTrue(patente == conductor.getAuto().getPatente());
		assertTrue(numero == conductor.getCelular().getNumero());
		
		conductor.setAuto(auto2);
		conductor.setCelular(celular2);
		
		assertEquals("HOL 380",conductor.getAuto().getPatente());
		assertTrue(1137764790 == conductor.getCelular().getNumero());
	}
	
	
	@Test
	public void cambiarModo() {
		//Exercise
		conductor.celularCambiarModo(new Automatico());
		//Assert
		assertEquals(new Automatico().getClass(),conductor.getCelular().getApp().getModoApp().getClass());
		
	}
	
	
	@Test
	public void puntoDeVentaEstacionamiento() {
		//Exercise
		conductor.puntoDeVentaEstacionamiento(sem, 5, puntoDeVenta);
		//Assert
		assertTrue(gps.getEstacionamientosVigentes().size()== 1);
		assertTrue(sem.getRegistroDeEstacionamientos().size() == 1);
		assertTrue(sem.getNumeroDeControl() == 1);
		assertTrue(sem.getRegistroDeRecargas().size() == 1);
		
	} 
	
	
	@Test 
	public void obtenerSaldo() {
		puntoDeVenta.recargarCelular(sem, celular, 100);
		conductor.obtenerSaldo(sem);
		
		assertEquals(100,sem.obtenerSaldo(celular));
		
	}
	
	@Test 
	public void inicioEstacionamiento() {
		
		conductor.celularInicioEstacionamiento(sem);
		
		assertEquals(1,sem.getRegistroDeEstacionamientos().size());
		assertEquals(true,app.getEstaVigente());
		assertEquals(1,gps.getEstacionamientosVigentes().size());
		
	}
	
	
	@Test
	public void finEstacionamiento() {
		puntoDeVenta.recargarCelular(sem, celular, 500);
		conductor.celularInicioEstacionamiento(sem);
		
		assertEquals(1,sem.getRegistroDeEstacionamientos().size());
		assertEquals(true,app.getEstaVigente());
		assertEquals(1,gps.getEstacionamientosVigentes().size());
		
		conductor.celularFinEstacionamiento(sem);
		
		assertEquals(0,gps.getEstacionamientosVigentes().size());
		assertEquals(false,app.getEstaVigente());
		//assertEquals(300,sem.obtenerSaldo(celular));
		
	}
	

}















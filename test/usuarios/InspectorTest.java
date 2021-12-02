package usuarios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projectofinal.Apps.App;
import projectofinal.Dispositivos.Celular;
import projectofinal.Estacionamiento.ZonaDeEstacionamiento;
import projectofinal.Reloj.Reloj;
import projectofinal.Sem.PuntoDeVenta;
import projectofinal.Sem.Sem;
import projectofinal.Usuarios.Auto;
import projectofinal.Usuarios.Inspector;

public class InspectorTest {
	
	private String nombre;
	private Celular celular;
	private ZonaDeEstacionamiento gps;
	private Integer numero;
	private App appInspector;
	private Reloj reloj;
	private Sem sem;
	private PuntoDeVenta puntoDeVenta;
	private Inspector inspector;
	private Auto auto;
	
	
	
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() throws Exception {
		
		numero = 1137267089;
		reloj = new Reloj(1600, new Date(1, 12, 2021));
		appInspector = new App();
		celular = new Celular(numero, reloj);
		celular.instalarApp(appInspector);
		gps = new ZonaDeEstacionamiento();
		inspector = new Inspector(nombre,celular,gps);
		gps.setInspector(inspector);
		
		sem = new Sem();
		puntoDeVenta = new PuntoDeVenta(reloj, gps);
		
		auto = new Auto("JHC 420");
		
		
	}
	
	
	@Test
	
	
	
	public void metodos_setYget() {
		
		Integer num2 = 1140301012;
		Reloj reloj = new Reloj(1400, new Date(1, 12, 2021));
		Celular celular2 = new Celular(num2,reloj);
		ZonaDeEstacionamiento gps2 = new ZonaDeEstacionamiento();
		
		assertEquals(inspector,gps.getInspector());
		assertEquals(gps,inspector.getEstacionamiento());
		assertTrue(numero == inspector.getCelular().getNumero());
		
		inspector.setCelular(celular2);
		inspector.setEstacionamiento(gps2);
		gps2.setInspector(inspector);
		
		
		assertEquals(gps2,inspector.getEstacionamiento());
		assertTrue(num2 == inspector.getCelular().getNumero());
		assertEquals(inspector,gps2.getInspector());
	}
	
	
	@Test
	public void consultaEstacionamientoVigente() {
		
		
		inspector.appConsultaDeEstacionamientoVigente(sem, inspector, auto);
		assertEquals(1,sem.getRegistroDeInfracciones().size());
		inspector.appConsultaDeEstacionamientoVigente(sem, inspector, auto);
		assertEquals(1,sem.getRegistroDeInfracciones().size());
		assertEquals(2,sem.getRegistroDeInfracciones().get(auto).size());
		
	}
	
}

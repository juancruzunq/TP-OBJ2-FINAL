package app;



import static org.junit.Assert.assertTrue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projectofinal.Estacionamiento.REstacionamiento;
import projectofinal.Estacionamiento.ZonaDeEstacionamiento;
import projectofinal.Reloj.Reloj;
import projectofinal.Reloj.RelojListener;
import projectofinal.Sem.Sem;

public class RelojTest {

	private Reloj reloj;
	private Date date;
	private Sem sem;
	private RelojListener listener1;
	private RelojListener listener2;
	private ZonaDeEstacionamiento zona1;
	private ZonaDeEstacionamiento zona2;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() {
		zona1 = new ZonaDeEstacionamiento();
		zona2 = new ZonaDeEstacionamiento();
		ArrayList<ZonaDeEstacionamiento> zonas = new ArrayList<ZonaDeEstacionamiento>();
		zonas.add(zona1);
		zonas.add(zona2);
		date = new Date(1998,01,04);
		reloj = new Reloj(1900, date);
		sem   = new Sem();
		sem.setZonasDeEstacionamiento(zonas);
		
			
	}
	
	@Test
	
	public void test_hora_actual() {
		assertEquals(1900, reloj.getHoraActual());
		assertNotEquals(1200, reloj.getHoraActual());
	}
	
	@SuppressWarnings("deprecation")
	
	@Test
	
	public void test_fecha_actual() {
		assertEquals(01, reloj.getFechaActual().getMonth());
		assertEquals(1998, reloj.getFechaActual().getYear());
		assertTrue(04 == reloj.getFechaActual().getDate());
	}
	@Test
	public void test_add_listener() {
		assertEquals(0, reloj.getListener().size());
		reloj.agregarListener(listener1);
		assertEquals(1, reloj.getListener().size());
		reloj.agregarListener(listener2);
		assertEquals(2, reloj.getListener().size());
		assertNotEquals(5, reloj.getListener().size());
		
	}
	@Test
	public void test_formato_controller() {
		assertEquals("19:00",reloj.formatoControlador(reloj.getHoraActual()));
		assertNotEquals("11:00",reloj.formatoControlador(reloj.getHoraActual()));
		
	}
	
	@Test
	
	public void test_cambiar_hora() {
		reloj.setHoraActual(1000);
		assertEquals(1000, reloj.getHoraActual());
		
	}
	
	@Test 
	public void semListenerTest() {
		for (int i = 0 ; i<sem.getZonasDeEstacionamiento().size() ; i++) {
			sem.getZonasDeEstacionamiento().get(i).agregarVigente(new REstacionamiento("1", 1400, 1600));
		}
		reloj.agregarListener(sem);
		reloj.setHoraActual(2000);
		int sumaDeEstacionamientos = 0;
		for (int i = 0 ; i<sem.getZonasDeEstacionamiento().size() ; i++) {
			sumaDeEstacionamientos =+ sem.getZonasDeEstacionamiento().get(i).getEstacionamientosVigentes().size();
		}
		
		assertEquals(sumaDeEstacionamientos, 0);
	}
	
	
}

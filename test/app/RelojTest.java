package app;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projectofinal.Reloj.Reloj;
import projectofinal.Reloj.RelojListener;

public class RelojTest {

	private Reloj reloj;
	private Date date;
	private RelojListener listener1;
	private RelojListener listener2;
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() {
		date = new Date(1998,01,04);
		reloj = new Reloj(1900, date);
		
			
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
	
	
	
}

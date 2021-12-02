package estacionamiento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projectofinal.Dispositivos.Celular;
import projectofinal.Estacionamiento.REstacionamientoApp;

public class REstacionamientoAppTest {
	
	private REstacionamientoApp estacionamiento ;
	private Celular celular ;
	private Celular celular2 ;
	
	
	
	@BeforeEach
	public void setUp() {
		celular = new Celular(1131263742,null);
		estacionamiento = new REstacionamientoApp("KGW435", 1400,1500,celular);
		celular2 = new Celular(1542345677,null);
	}
	
	@Test
	public void test_methods_get() {
		assertTrue(1131263742==estacionamiento.getCelularNumero());
		assertEquals(1400,estacionamiento.getHoraInicio());
		assertEquals(1500,estacionamiento.getHoraFin());
		assertTrue("KGW435"==estacionamiento.getPatente());
		assertNotEquals("FAIL", estacionamiento.getPatente());
	}
	
	@Test
	public void test_methods_set() {
		assertTrue(1131263742==estacionamiento.getCelularNumero());
		estacionamiento.setCelular(celular2);
		assertTrue(1542345677==estacionamiento.getCelularNumero());
		
	}
}

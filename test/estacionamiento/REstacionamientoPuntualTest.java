package estacionamiento;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projectofinal.Estacionamiento.REstacionamientoPuntual;

public class REstacionamientoPuntualTest {
	
	private REstacionamientoPuntual estacionamiento ;
	
	@BeforeEach
	public void setUp() {
		
		estacionamiento = new REstacionamientoPuntual("ALL111",1100,1500,4);
	}
	
	@Test
	public void test_methods_get() {
		assertEquals(4,estacionamiento.getHorasPuntuales());
		assertEquals("ALL111",estacionamiento.getPatente());
		assertEquals(1100,estacionamiento.getHoraInicio());
		assertEquals(1500,estacionamiento.getHoraFin());
	}
	@Test
	public void test_methods_set() {
		assertEquals(4,estacionamiento.getHorasPuntuales());
		estacionamiento.setHorasPuntuales(1);
		assertEquals(1,estacionamiento.getHorasPuntuales());
		
	}
}

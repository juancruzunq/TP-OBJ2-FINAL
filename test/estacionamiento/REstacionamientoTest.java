package estacionamiento;



import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projectofinal.Estacionamiento.REstacionamiento;

public class REstacionamientoTest {
	
	private REstacionamiento estacionamiento ;
	
	
	@BeforeEach
	public void setUp() {
		estacionamiento = new REstacionamiento("KGW435",14000,1700);
	}
	
	
	@Test
	public void test_methods_get() {
		
		assertEquals("KGW435", estacionamiento.getPatente());
		assertTrue(14000==estacionamiento.getHoraInicio());
		assertNotEquals(2300,estacionamiento.getHoraFin());
	}
	
	@Test
	
	public void test_methods_set() {
		estacionamiento.setPatente("PLF455");
		estacionamiento.setHoraInicio(1500);
		estacionamiento.setHoraFin(1600);
		assertEquals("PLF455", estacionamiento.getPatente());
		assertEquals(1500, estacionamiento.getHoraInicio());
		assertEquals(1600, estacionamiento.getHoraFin());
	}
	
}

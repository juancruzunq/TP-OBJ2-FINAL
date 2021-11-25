package app;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projectofinal.Apps.App;
import projectofinal.Reloj.Reloj;




public class AppTest {
	
	private App app ;
	private Reloj reloj ;
	private Date date ;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	
	public void setUp() throws Exception {
		date = new Date(25,11,2021);
		reloj = new Reloj(2000, null);
		app = new App(reloj);
	}
	
	
	@Test
	private void testRelojApp() {
		
		assertEquals(2000,app.getReloj().getHoraActual());
		assertTrue(app.getReloj().getFechaActual()==date);
		System.out.print("Hola");
	}
	
	
	
	
	
	
	
}

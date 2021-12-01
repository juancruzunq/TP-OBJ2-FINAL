package usuarios;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import projectofinal.Usuarios.Auto;

public class AutoTest {

	
	private String patente;
	private Auto auto;
	
	
	@BeforeEach
	public void setUp() throws Exception {
		
		patente = "CJE 710";
		auto = new Auto(patente);
	
	
	}
	
	
	@Test 
	public void getYSet(){
		
		assertEquals("CJE 710",auto.getPatente());
		auto.setPatente("HJD 540");
		assertEquals("HJD 540",auto.getPatente());
	}
	
	
	
}

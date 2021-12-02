package dispositivos;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projectofinal.Dispositivos.RRecarga;
import projectofinal.Dispositivos.RRecargaCelular;
import projectofinal.Sem.PuntoDeVenta;

public class RRecargaTest {
	private RRecarga carga ;
	private PuntoDeVenta puntoDeventa ;
	private PuntoDeVenta puntoDeventa2 ;
	private Date fecha ;
	private Date fecha2 ;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() {
		fecha = new Date(1998, 01,04);
		puntoDeventa = new PuntoDeVenta(null, null);
		carga = new RRecarga(puntoDeventa, fecha, 1500);
		fecha2 = new Date(2000, 5, 5);
		puntoDeventa2 = new PuntoDeVenta(null, null);
	}
	
	
	@Test
	public void test_methods_get() {
		
		assertEquals(fecha, carga.getFecha());
		assertEquals(1500, carga.getHora());
		assertEquals(0, carga.getNumeroDeControl());
		assertTrue( puntoDeventa.getClass()==carga.getPuntoDeVenta().getClass());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void test_methods_set() {
		assertEquals(0, carga.getNumeroDeControl());
		carga.setNumeroDeControl(5);
		assertEquals(5, carga.getNumeroDeControl());
		carga.setFecha(fecha2);
		assertTrue(fecha2==carga.getFecha());
		assertTrue(fecha2.getMonth()==carga.getFecha().getMonth());
		carga.setHora(1100);
		assertEquals(1100, carga.getHora());
		assertNotEquals(1900, carga.getHora());
		carga.setPuntoDeVenta(null);
		assertTrue(carga.getPuntoDeVenta()==null);;
	}
}

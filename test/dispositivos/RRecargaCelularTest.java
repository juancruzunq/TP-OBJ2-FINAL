package dispositivos;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projectofinal.Dispositivos.Celular;
import projectofinal.Dispositivos.RRecargaCelular;
import projectofinal.Sem.PuntoDeVenta;

public class RRecargaCelularTest {
	private RRecargaCelular carga;
	private PuntoDeVenta puntoDeVenta;
	private Date fecha ;
	private Celular celular ;
	private Celular celular2 ;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() {
		celular = new Celular(1131263745,null);
		celular2 = new Celular(1166778822,null);
		fecha = new Date(2021,9,01);
		puntoDeVenta = new PuntoDeVenta(null, null);
		carga = new RRecargaCelular(puntoDeVenta, fecha,1500,350,celular);
	}
	
	@Test
	public void test_methods_gets() {
		assertEquals(350 ,carga.getMonto());
		assertEquals(celular.getClass(),carga.getCelular().getClass());
		
	}
	
	@Test
	public void test_methods_set() {
		assertEquals(350 ,carga.getMonto());
		assertEquals(1131263745,carga.getCelular().getNumero());
		carga.setCelular(celular2);
		carga.setMonto(9999);
		assertTrue(1166778822==carga.getCelular().getNumero());
		assertTrue(9999==carga.getMonto());
	}
}

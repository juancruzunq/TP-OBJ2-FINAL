package TestproyectoFinal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import projectofinal.Apps.AppCliente;
import projectofinal.Apps.ModoApp;
import projectofinal.Apps.ModoMovimiento;
import projectofinal.Dispositivos.Celular;
import projectofinal.Dispositivos.DispositivoMovil;
import projectofinal.Dispositivos.RRecarga;
import projectofinal.Dispositivos.RRecargaCelular;
import projectofinal.Estacionamiento.REstacionamiento;
import projectofinal.Estacionamiento.REstacionamientoApp;
import projectofinal.Estacionamiento.REstacionamientoPuntual;
import projectofinal.Estacionamiento.ZonaDeEstacionamiento;
import projectofinal.Reloj.Reloj;
import projectofinal.Reloj.RelojListener;
import projectofinal.Sem.PuntoDeVenta;
import projectofinal.Sem.RCompraPuntual;
import projectofinal.Sem.RInfraccion;
import projectofinal.Sem.Sem;
import projectofinal.Usuarios.Auto;
import projectofinal.Usuarios.Conductor;
import projectofinal.Usuarios.Inspector;
import projectofinal.Usuarios.Subscriptor;

public class Methods_Get_Set {
	
	AppCliente appCliente;
	Sem sem;
	Inspector inspector;
	Auto auto;
	Conductor conductor;
	DispositivoMovil dispositivoMovil;
	Celular celular;
	ZonaDeEstacionamiento zonaEstacionamiento;
	Reloj reloj;
	PuntoDeVenta puntoDeVenta;
	Date fecha;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() throws Exception {
		this.fecha = new Date(1998, 04,1);
		this.appCliente = new AppCliente(ModoApp.Manual, ModoMovimiento.Walking, true);
		this.sem = new Sem();
		this.reloj = new Reloj(2000,fecha);
		this.celular = new Celular(1131263742, reloj);
		this.zonaEstacionamiento = new ZonaDeEstacionamiento();
		this.inspector = new Inspector("Juan Carlos", celular, zonaEstacionamiento);
		this.auto = new Auto("KGW855");
		this.conductor = new Conductor(auto, celular);
		this.dispositivoMovil = new DispositivoMovil(reloj) ;
		this.puntoDeVenta = new PuntoDeVenta();
		fecha = new Date(1998, 04,1);
		appCliente = new AppCliente(ModoApp.MANUAL, ModoMovimiento.Walking, true);
		sem = new Sem();
		reloj = new Reloj(2000,fecha);
		celular = new Celular(1131263742, reloj);
		zonaEstacionamiento = new ZonaDeEstacionamiento();
		inspector = new Inspector("Juan Carlos", celular, zonaEstacionamiento);
		auto = new Auto("KGW855");
		conductor = new Conductor(auto, celular);
		dispositivoMovil = new DispositivoMovil(reloj) ;
		puntoDeVenta = new PuntoDeVenta();
		
	}
	
	
	@Test
	public void test_Gets() {
		
		assertEquals(this.appCliente.getModoApp(),ModoApp.Manual);
		assertEquals(appCliente.getModoApp(),ModoApp.MANUAL);
		assertEquals(appCliente.getModoMovimiento(),ModoMovimiento.Walking);
		assertEquals(true,appCliente.getEstaVigente());
		assertEquals(1131263742,celular.getNumero());
	}
	
	
	
	
	
}

package projectofinal.Sem;

import java.util.Date;

import projectofinal.Estacionamiento.ZonaDeEstacionamiento;
import projectofinal.Usuarios.Inspector;

public class RInfraccion {
	private Date fecha;
	private int hora;
	private Inspector inspector;
	private ZonaDeEstacionamiento zona;
	
	public RInfraccion(Date fecha, int hora, Inspector inspector, ZonaDeEstacionamiento zona) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.inspector = inspector;
		this.zona = zona;
	}

	public Date getFecha() {
		return fecha;
	}

	public int getHora() {
		return hora;
	}

	public Inspector getInspector() {
		return inspector;
	}

	public ZonaDeEstacionamiento getZona() {
		return zona;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public void setInspector(Inspector inspector) {
		this.inspector = inspector;
	}

	public void setZona(ZonaDeEstacionamiento zona) {
		this.zona = zona;
	}
	
}

package matiasDominguez;

import java.util.Date;

public abstract class RRecarga {
	private int numeroDeControl;
	private PuntoDeVenta puntoDeVenta;
	private Date fecha;
	private int hora;
	
	public RRecarga(PuntoDeVenta puntoDeVenta, Date fecha, int hora) {
		super();
		this.puntoDeVenta = puntoDeVenta;
		this.fecha = fecha;
		this.hora = hora;
	}
	

	public PuntoDeVenta getPuntoDeVenta() {
		return puntoDeVenta;
	}

	public Date getFecha() {
		return fecha;
	}

	public int getHora() {
		return hora;
	}

	public void setPuntoDeVenta(PuntoDeVenta puntoDeVenta) {
		this.puntoDeVenta = puntoDeVenta;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getNumeroDeControl() {
		return numeroDeControl;
	}

	public void setNumeroDeControl(int numeroDeControl) {
		this.numeroDeControl = numeroDeControl;
	}
	
	

}
package projectofinal.Dispositivos;

import java.util.Date;

import projectofinal.Sem.PuntoDeVenta;

public class RRecargaCelular extends RRecarga{
	private int monto;
	private Celular celular;
	
	public RRecargaCelular(PuntoDeVenta puntoDeVenta, Date fecha, int hora, int monto,
			Celular celular) {
		super(puntoDeVenta, fecha, hora);
		this.monto = monto;
		this.celular = celular;
	}

	public int getMonto() {
		return monto;
	}

	public Celular getCelular() {
		return celular;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}

	public void setCelular(Celular celular) {
		this.celular = celular;
	}
}

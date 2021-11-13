package projectofinal;

import java.util.Date;

public class RCompraPuntual extends RRecarga {
	private int cantidadDeHoras;

	public RCompraPuntual(PuntoDeVenta puntoDeVenta, Date fecha, int hora, int cantidadDeHoras) {
		super(puntoDeVenta, fecha, hora);
		this.cantidadDeHoras = cantidadDeHoras;
	}

	public int getCantidadDeHoras() {
		return cantidadDeHoras;
	}

	public void setCantidadDeHoras(int cantidadDeHoras) {
		this.cantidadDeHoras = cantidadDeHoras;
	}

}

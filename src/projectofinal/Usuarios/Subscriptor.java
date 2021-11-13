package projectofinal.Usuarios;

import projectofinal.Dispositivos.RRecarga;

public interface Subscriptor {
	public void alertarCompra(RRecarga recarga);
	public void alertarInicioFinEstacionamiento(int horaInicio, int horaFin);
}

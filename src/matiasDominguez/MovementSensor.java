package matiasDominguez;

public interface MovementSensor {
	
	
	public void walking(ZonaDeEstacionamiento zona, RSem sem, String patente, Celular celular);



	public void driving(ZonaDeEstacionamiento zona, RSem sem, Celular celular);
}

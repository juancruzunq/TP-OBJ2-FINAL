package matiasDominguez;

public class Conductor {
	
	
	
	
	private Auto auto;
	private Celular celular;
	
	
	
	
	
	public Conductor(Auto auto, Celular celular) {
		super();
		this.auto = auto;
		this.celular = celular;
	}

	public Auto getAuto() {
		return auto;
	}
	
	public void setAuto(Auto auto) {
		this.auto = auto;
	}
	
	public Celular getCelular() {
		return celular;
	}
	
	public void setCelular(Celular celular) {
		this.celular = celular;
	}
}

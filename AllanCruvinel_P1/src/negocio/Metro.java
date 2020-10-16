package negocio;

public class Metro implements IUnidadeMetrica {

	private double metro;
	private double pe;
	
	
	
	public Metro(double pe) {
		super();
		this.pe = pe;
	}


	@Override
	public void converter() {
		this.metro = pe/3.28084;
		
	}


	public double getMetro() {
		converter();
		return metro;
	}
	
	
	
	
	
	

}

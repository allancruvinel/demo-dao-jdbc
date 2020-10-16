package negocio;

public class Pe implements IUnidadeMetrica {

	private double metro;
	private double pe;
	
	
	
	public Pe(double metro) {
		super();
		this.metro = metro;
	}


	@Override
	public void converter() {
		this.pe = metro*3.28084;
		
	}


	public double getPe() {
		converter();
		return pe;
	}
	
	
	
	
	
	

}

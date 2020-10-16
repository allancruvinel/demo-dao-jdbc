package negocio;

public class Libra implements IUnidadeMetrica {

	private double kilo;
	private double libra;
	
	
	
	public Libra(double kilo) {
		super();
		this.kilo = kilo;
	}


	@Override
	public void converter() {
		this.libra = kilo*2.2046;
		
	}


	public double getLibra() {
		converter();
		return libra;
	}
	
	
	
	
	
	

}

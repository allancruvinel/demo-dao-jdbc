package negocio;

public class Quilograma implements IUnidadeMetrica {

	private double kilo;
	private double libra;
	
	
	
	public Quilograma(double libra) {
		super();
		this.libra = libra;
	}


	@Override
	public void converter() {
		this.kilo = libra/2.2046;
		
	}


	public double getKilo() {
		converter();
		return kilo;
	}
	
	
	
	
	
	

}

package negocio;

public class Media implements IMedia {
	
	private float media;

	public Media() {}
	@Override
	public void calcularMedia(float p1, float p2) {
		this.media = (p1+p2)/2;
		
	}

	@Override
	public void calcularMedia(float p1, float p2, float tp) {
		this.media = (p1+p2+tp)/3;
	}
	public float getMedia() {
		return media;
	}
	
	

}

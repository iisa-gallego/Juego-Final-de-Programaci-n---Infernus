import processing.core.PApplet;
import processing.core.PImage;

public class ArmaCentauro extends Villano {
	PImage flecha;
	protected boolean estado0, estado1;

	public ArmaCentauro(int x, int y,PApplet app) {
		super(x, y);
		flecha = app.loadImage("Flechas.png");
		this.estado0 = true;
		this.estado1 = false;
	}

	@Override
	public void pintar(PApplet app) {
		app.image(flecha, x, y);
	}
	
	@Override
	public void mover() {
		x-=5;
		if(x<=-50) {
			x=1000;
		}
		if(x<=550) {
			y+=(int) (Math.random()*2);
		}
		if(y>=650) {
			y=0;
		}
		
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}

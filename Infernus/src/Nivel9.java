import processing.core.PApplet;
import processing.core.PImage;

public class Nivel9 {
	public int x;
	public int y;
	PImage escenario;

	public Nivel9(int x, int y, PApplet app) {// constructor
		this.x = x;
		this.y = y;
		escenario = app.loadImage("9.png");
	}
	
	public void pintar(PApplet app) { // app cuenta como objeto de PApplet
		app.image(escenario, x, y);
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}

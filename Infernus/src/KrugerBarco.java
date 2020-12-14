import processing.core.PApplet;
import processing.core.PImage;

public class KrugerBarco {
	public int x;
	public int y;
	public int dist;
	PImage kruguerB;

	public KrugerBarco(int x, int y, PApplet app) {// constructor
		this.x = 100;
		this.y = 350;
		this.dist=50;
		kruguerB = app.loadImage("KrugerBarco.png");
	}
	
	public void pintar(PApplet app) { // app cuenta como objeto de PApplet
		app.imageMode(app.CENTER);
		app.image(kruguerB, x, y);
		app.imageMode(app.CORNER);
	}
	
	public void mover(PApplet app) {//mover con las teclas
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int dist() {
		return dist;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
}

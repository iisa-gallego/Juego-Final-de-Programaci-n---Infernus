import processing.core.PApplet;
import processing.core.PImage;

public class Kruger {

	public int x;
	public int y;
	PImage kruger;

	public Kruger(int x, int y, PApplet app) {// constructor
		this.x = 10;
		this.y = 350;
		kruger = app.loadImage("Kruguer.png");
		
	}
	
	public void pintar(PApplet app) { // app cuenta como objeto de PApplet
		app.image(kruger, x, y);
	}
	
	public void reset () {
		this.x = 10;
		this.y = 350;
	}
	
	public void mover(PApplet app) {//mover con las teclas
		switch (app.key) {
		case 'd':
			this.x+=30;
			break;
		case 'a':
			this.x-=30;
			break;
		case 's':
			this.y+=30;
			break;
		case 'w':
			this.y-=30;
			break;
		}
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public PImage getKruger() {
		return kruger;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
}
	

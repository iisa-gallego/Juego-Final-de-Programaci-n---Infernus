import processing.core.PApplet;
import processing.core.PImage;

public class Kruger {

	public int x;
	public int y;
	PImage kruguer;

	public Kruger(int x, int y, PApplet app) {// constructor
		this.x = 40;
		this.y = 350;
		kruguer = app.loadImage("Kruguer.png");
		
	}
	
	public void pintar(PApplet app) { // app cuenta como objeto de PApplet
		app.imageMode(app.CENTER);
		app.image(kruguer, x, y);
		app.imageMode(app.CORNER);
	}
	
	public void reset () {
		this.x = 40;
		this.y = 350;
	}
	
	public void resbalar() {//ESTE MÉTODO ES PARA EL NIVEL 7
	
	}
	
	public void mover(PApplet app) {//mover con las teclas
		switch (app.key) {
		case 'd':
			this.x+=30;
			if (x>1060) {
				x=1051;
			}
			break;
		case 'a':
			this.x-=30;
			if (x<9) {
				x=10;
			}
			break;
		case 's':
			this.y+=30;
			if (y>630) {
				y=629;
			}
			break;
		case 'w':
			this.y-=30;
			if (y<70) {
				y=71;
			}
			break;
		}
		
		
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public PImage getKruguer() {
		return kruguer;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
}
	

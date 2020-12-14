import processing.core.PApplet;
import processing.core.PImage;

public class Recolectable {
	
	public int x;
	public int y;


	PImage plata;
	PImage oro;

	public Recolectable (int x, int y,PApplet app) {
		this.x = x;
		this.y = y;
		
		plata = app.loadImage("DracmaPlata.png");
		oro = app.loadImage("DracmaOro.png");
	}
//DRACMAS
	public void pintar1(PApplet app) {//Dracmas de plata del nivel 1
		app.imageMode(app.CENTER);
		app.image(plata, x, y);
		app.imageMode(app.CORNER);
	}
	
	public void pintar2(PApplet app) {//Dracmas de plata del nivel 2
		app.imageMode(app.CENTER);
		app.image(plata, x, y);
		app.imageMode(app.CORNER);
	}
	
	public void pintar3(PApplet app) {//Dracmas oro del nivel 3
		app.imageMode(app.CENTER);
		app.image(oro, x, y);
		app.imageMode(app.CORNER);
	}
	
	public void pintar4(PApplet app) {//Dracmas oro del nivel 3
		app.imageMode(app.CENTER);
		app.image(oro, x, y);
		app.imageMode(app.CORNER);
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	
//CHISPAS
	
}

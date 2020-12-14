import processing.core.PApplet;
import processing.core.PImage;

public class Llave {

	public int x;
	public int y;

	PImage llaveR;

	public Llave (int x, int y,PApplet app) {
		this.x = 350;
		this.y = 500;

		llaveR = app.loadImage("LlaveRecolectar.png");
	}
	
		public void pintar(PApplet app) {//Llave recolectar en el nivel 4
			app.imageMode(app.CENTER);
			app.image(llaveR, x, y);
			app.imageMode(app.CORNER);
		}
		
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
		
		public void setX(int x) {
			this.x = x;
		}
		
		public void setY(int y) {
			this.y = y;
		}
}

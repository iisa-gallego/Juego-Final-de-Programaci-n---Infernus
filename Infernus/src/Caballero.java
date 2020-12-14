import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Caballero extends Villano {
	PImage caballero;
	protected boolean estado0, estado1;
	
	public Caballero(int x, int y, PApplet app) {
		super(x, y);
		caballero = app.loadImage("Caballero.png");
		this.estado0 = true;
		this.estado1 = false;
	}

	public void pintar(PApplet app) {
		app.image(caballero, x, y);
	}
		
	public void mover() {
		if (estado0) {
			estado1 = false;
			y += 3;
			if (y >= 570) {
				estado1 = true;
			}
		}
		if (estado1) {
			estado0 = false;
			y -= 5;
			if (y <= 20) {
				estado0 = true;
			}
		}
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}

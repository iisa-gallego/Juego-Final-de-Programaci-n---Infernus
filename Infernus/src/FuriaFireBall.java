import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class FuriaFireBall {

	public int x;
	public int y;
	public int vel;
	public int dir;
	PApplet app;
	PImage fireball;

	public FuriaFireBall(int x, int y, PApplet app, int dir) {
		// TODO Auto-generated constructor stub
		this.app = app;
		this.x = x;
		this.y = y;
		this.dir = dir;
		vel = 4;
		fireball = app.loadImage("BolitaFuego.png");
	}
	
	public void pintar() { // app cuenta como objeto de PApplet
		app.imageMode(app.CENTER);
		app.image(fireball, x, y);
		app.imageMode(app.CORNER);
	}
	
	public void mover() {//mover con las teclas
		if (dir == 1) {
			this.y += vel;			
		} else {
			this.x -= vel;
		}
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
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class FuriaInfernal {

	public int x;
	public int y;
	public int dist;
	public int vel;
	PApplet app;
	PImage Furia;
	ArrayList<FuriaFireBall> fireballs;

	public FuriaInfernal(int x, int y, PApplet app) {
		// TODO Auto-generated constructor stub
		this.app = app;
		this.x = x;
		this.y = y;
		this.dist=50;
		vel = 5;
		fireballs = new ArrayList<FuriaFireBall>();
		Furia = app.loadImage("Furia.png");
		
	}
	
	public void pintar() { // app cuenta como objeto de PApplet
		
		
		for (int i = 0; i < fireballs.size(); i++) {
			fireballs.get(i).pintar();
			fireballs.get(i).mover();
		}
		generarEnmigos();
		eliminarEnemigos();
		app.imageMode(app.CENTER);
		app.image(Furia, x, y);
		app.imageMode(app.CORNER);
	}
	
	public void mover() {//mover con las teclas
		this.x += vel;
		if(this.x < 25 || this.x > this.app.width - this.app.width*0.15) {
			this.vel *= -1;
		}
	}
	
	public void generarEnmigos() {
		if (app.frameCount%120 == 0) {
			fireballs.add(new FuriaFireBall(x, y, app,1));
		}
	}
	
	public void eliminarEnemigos() {
		for (int i = 0; i < fireballs.size(); i++) {
			if (fireballs.get(i).getY() > app.height) {
				fireballs.remove(i);
			}
		}
	}
	
	public boolean validar(int x, int y) {
		for (int i = 0; i < fireballs.size() ; i++) {
			FuriaFireBall o = fireballs.get(i);
			if (PApplet.dist(o.getX(), o.getY(), x, y) < 25) {
				fireballs.remove(i);
				return true;
			}
		}
		return false;
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

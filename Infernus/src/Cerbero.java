import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Cerbero extends Villano {
	PImage cerbero;
	protected boolean estado0, estado1;
	ArrayList<FuriaFireBall> fireballs;
	PApplet app;
	
	public Cerbero(int x, int y,PApplet app) {
		super(x, y);
		cerbero = app.loadImage("Cerbero.png");
		this.estado0 = true;
		this.estado1 = false;
		this.app = app;
		fireballs = new ArrayList<FuriaFireBall>();
	}

	@Override
	public void pintar(PApplet app) {
		app.image(cerbero, x, y);
		for (int i = 0; i < fireballs.size(); i++) {
			fireballs.get(i).pintar();
			fireballs.get(i).mover();
		}
		generarEnmigos();
		eliminarEnemigos();
		
	}
	public void mover() {
		if (estado0) {
			estado1 = false;
			y += 5;
			if (y >= 550) {
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
	
	public void generarEnmigos() {
		if (app.frameCount%120 == 0) {
			fireballs.add(new FuriaFireBall(x, y, app,2));
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
}

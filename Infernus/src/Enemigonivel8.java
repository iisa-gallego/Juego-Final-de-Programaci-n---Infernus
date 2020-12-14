import processing.core.PApplet;
import processing.core.PImage;

public class Enemigonivel8 extends Villano {
	protected boolean estado0, estado1;

	PImage espada;
	PImage cabeza, fuego, moneda, veneno, hacha;

	int xespada, yespada, xcabeza, ycabeza, xfuego, yfuego, xmoneda, ymoneda, xveneno, yveneno, xhacha, yhacha;

	public Enemigonivel8(int x, int y, PApplet app) {
		super(x, y);

		espada = app.loadImage("espada.png");
		cabeza = app.loadImage("cabeza.png");
		fuego = app.loadImage("fuego8.png");
		moneda = app.loadImage("monedafalsa.png");
		veneno = app.loadImage("Veneno.png");
		hacha = app.loadImage("Hacha.png");
		this.estado0 = true;
		this.estado1 = false;

	}

	public void enemis(PApplet app) {
		app.image(espada, xespada, yespada);
		app.image(espada, xcabeza, ycabeza);
		app.image(espada, xfuego, yfuego);
		app.image(espada, xmoneda, ymoneda);
		app.image(espada, xveneno, yveneno);
		app.image(espada, xhacha, yhacha);

	}
	
	public void pintarespada(PApplet app) {
		
		app.imageMode(app.CENTER);
		app.image(espada, x, y);
		app.imageMode(app.CORNER);

	}
	
	public void pintarcabeza(PApplet app) {
		app.image(cabeza, xcabeza, ycabeza);
		
		app.imageMode(app.CENTER);
		app.image(cabeza, x, y);
		app.imageMode(app.CORNER);

	}
	
	

	public void pintarfuego(PApplet app) {
		app.image(fuego, xfuego, yfuego);

		app.imageMode(app.CENTER);
		app.image(fuego, x, y);
		app.imageMode(app.CORNER);
	}

	public void pintarmoneda(PApplet app) {
		app.image(moneda, xmoneda, ymoneda);
		
		app.imageMode(app.CENTER);
		app.image(moneda, x, y);
		app.imageMode(app.CORNER);

	}

	public void pintarveneno(PApplet app) {
		app.image(veneno, xveneno, yveneno);
		
		app.imageMode(app.CENTER);
		app.image(veneno, x, y);
		app.imageMode(app.CORNER);

	}

	public void pintarhacha(PApplet app) {
		app.image(hacha, x, y);
		
		app.imageMode(app.CENTER);
		app.image(hacha, x, y);
		app.imageMode(app.CORNER);

	}

	public void moverespada() {
		if (estado0) {
			estado1 = false;
			y += 3;
			if (y >= 720) {
				estado1 = true;
			}
		}
		if (estado1) {
			estado0 = false;
			y = -50;
			if (y <= 40) {
				estado0 = true;
			}
		}
	}
	
	public void movercabeza() {
		if (estado0) {
			estado1 = false;
			y += 3;
			if (y >= 720) {
				estado1 = true;
			}
		}
		if (estado1) {
			estado0 = false;
			y = -50;
			if (y <= 40) {
				estado0 = true;
			}
		}
	}
	
	public void moverfuego() {
		if (estado0) {
			estado1 = false;
			y += 3;
			if (y >= 720) {
				estado1 = true;
			}
		}
		if (estado1) {
			estado0 = false;
			y = -50;
			if (y <= 40) {
				estado0 = true;
			}
		}
	}

	public void moverveneno() {
		if (estado0) {
			estado1 = false;
			y += 3;
			if (y >= 720) {
				estado1 = true;
			}
		}
		if (estado1) {
			estado0 = false;
			y = -50;
			if (y <= 40) {
				estado0 = true;
			}
		}
	}
	
	public void moverhacha() {
		if (estado0) {
			estado1 = false;
			y += 3;
			if (y >= 720) {
				estado1 = true;
			}
		}
		if (estado1) {
			estado0 = false;
			y = -50;
			if (y <= 40) {
				estado0 = true;
			}
		}
	}

	public boolean choque(int kx, int ky, PApplet app) {
		
		if( PApplet.dist(kx, ky, x, y) < 30) {
		return true;	
		}  return false; 
		
	}

	@Override
	public void pintar(PApplet app) {
		// TODO Auto-generated method stub
		
	}
}


import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Principal extends PApplet {

	public static void main(String[] args) {
		PApplet.main("Principal");
	}

//INSTANCIAS
	Kruger kruger;		KrugerBarco krugerB;		KrugerBarco sel; // el selector
	
	Recolectable oro;	Recolectable plata;
	
	Nivel1 uno; 	Nivel2 dos;		 Nivel3 tres; 
	Nivel4 cuatro;	Nivel5 cinco;	 Nivel6 seis;
	Nivel7 siete;	Nivel8 ocho; 	 Nivel9 nueve;
	
	
	Cerbero cerbero;
	FuriaInfernal furia;
	Enemigonivel8 espada;
	Enemigonivel8 hacha;
	
	
	Llave llave;
	
//ARREGLOS
	ArrayList<Villano> misCaballeros;
	ArrayList<Villano> misRemolinos;
	ArrayList<Villano> misFlechas;
	ArrayList<Recolectable> misDracmasPlata;
	ArrayList<Recolectable> misDracmasPlata2;
	ArrayList<Recolectable> misDracmasOro;
	ArrayList<Recolectable> misDracmasOro2;
	
	PImage Vida;
	
//IMAGENSITAS
	PImage inicial;
	PImage cargar;
	PImage advertencia;
	PImage instrucciones;
	PImage text;
	
	int tInvulnerabilida = 0;

	boolean inicio; 	boolean cargando; 
	int reloj;// Para que dure cierto tiempo la imagen de cargando
	int nVidas;
	boolean recogioLlave=false;
	boolean vulnerabilidad = true;
	
//BOLEAN PARA PASAR DE UN NIVEL AL OTRO
	int pantalla; 
	int xDescender, yDescender, xInstrucciones, yInstrucciones;
	int puntaje;	int puntaje2;
	
	
	@Override
	public void settings() {
		size(1200, 700);
	}

	public void setup() {
		puntaje = 0;
		nVidas = 5;
		//Coordenas del cuadro descender
		xDescender=615;
		yDescender=415;
		//Coordenas del cuadro instrucciones
		xInstrucciones=615;
		yInstrucciones=491;
		
		kruger = new Kruger(0, 0, this); // Declarar la instancia
		krugerB = new KrugerBarco (0,0, this);
		
		furia = new FuriaInfernal(450, 70, this); // Declarar la instancia
		espada = new Enemigonivel8(250, 300, this);
		hacha = new Enemigonivel8(500, 0, this);
		sel = null;
	
		plata = new Recolectable (0 ,0, this);
		oro = new Recolectable (0,0,this);
		
		// Villano nivel 1
		misCaballeros = new ArrayList<Villano>();
		misCaballeros.add(new Caballero(350, 0, this));
		misCaballeros.add(new Caballero(650, 530, this));
		misCaballeros.add(new Caballero(950, 0, this));
		//Villano nivel 2
		misRemolinos = new ArrayList<Villano>();
		misRemolinos.add(new MounstruoAire(1000, 50, this));
		misRemolinos.add(new MounstruoAire(1000, 250, this));
		misRemolinos.add(new MounstruoAire(1000, 500, this));
		misRemolinos.add(new MounstruoAire(1700, 150, this));
		misRemolinos.add(new MounstruoAire(1700, 400, this));
		//Villano nivel 2
		misFlechas = new ArrayList<Villano>();
		misFlechas.add(new ArmaCentauro(1000, 50, this));
		misFlechas.add(new ArmaCentauro(1000, 300, this));
		misFlechas.add(new ArmaCentauro(1000, 550, this));
		//Villano nivel 3
		
		cerbero = new Cerbero(925,0,this);
		
		//RECOLECTABLE DE DRACMAS
		misDracmasPlata = new ArrayList<Recolectable>();
		misDracmasPlata.add(new Recolectable(370, 50, this));		misDracmasPlata.add(new Recolectable(700, 650, this));
		
		misDracmasPlata2 = new ArrayList<Recolectable>();
		misDracmasPlata2.add(new Recolectable(100, 100, this));	misDracmasPlata2.add(new Recolectable(700, 350, this));
		
		misDracmasOro = new ArrayList<Recolectable>();
		misDracmasOro.add(new Recolectable(100, 600, this));	misDracmasOro.add(new Recolectable(800, 600, this));
		misDracmasOro.add(new Recolectable(700, 550, this));	misDracmasOro.add(new Recolectable(200, 450, this));
		misDracmasOro.add(new Recolectable(400, 600, this));
	
		misDracmasOro2 = new ArrayList<Recolectable>();
		misDracmasOro2.add(new Recolectable(280, 250, this));
		misDracmasOro2.add(new Recolectable(730, 480, this));
		
		llave = new Llave(0,0,this);
		
		
		//Tiempo de imagen cargando
		reloj = 0;

		//imagenes diferentes a los niveles
		inicial = loadImage("Inicio.png");
		cargar = loadImage("Cargando.png");
		advertencia = loadImage("Cuidado.png");
		instrucciones = loadImage("Instrucciones.png");
		text = loadImage("TextoDracma.png");

//LAS PANTALLAS
		inicio = true;
		uno = new Nivel1(0, 0, this);
		dos = new Nivel2(0, 0, this);
		tres = new Nivel3(0,0, this);
		cuatro = new Nivel4(0,0, this);
		cinco = new Nivel5(0,0, this);
		seis = new Nivel6(0, 0, this);
		siete = new Nivel7(0, 0, this);
		ocho = new Nivel8(0, 0, this);
		nueve = new Nivel9(0, 0, this);
		
		Vida = loadImage("Vida.png");
		
		//pantalla = 9;

	}

	public void draw() {	
	
//PANTALLA DE INICIO
		switch (pantalla) {
		case 0:
			image(inicial, 0, 0);
			if (dist(mouseX, mouseY, 745, 415) < 40) {// Para que marque cuando estoy sobre el botón de play
				strokeWeight(5);	stroke(255);	noFill();	rect(615, 415, 253, 56, 15);
			}
			if (dist(mouseX, mouseY, 745, 520) < 40) {// Para que marque cuando estoy sobre el botón de instrucciones
				strokeWeight(5);	stroke(255);	noFill();	rect(xInstrucciones, yInstrucciones, 253, 56, 15);
				}break;
//PANTALLA DE CARGANDO
		case 1:
			image(cargar, 0, 0);
			reloj++;
			if (reloj == 100) {// que cambia al nivel 1
				reloj = 99;
				pantalla = 2;
			}break;
//NIVEL 1	
		case 2:
			uno.pintar(this);
			kruger.pintar(this);
			
			textSize(20);
			text(":" + puntaje, 1105, 70);
			
			for (int i = 0; i < misCaballeros.size(); i++) {
				misCaballeros.get(i).pintar(this); // Llamo el pintar de cada clase que tenga un comportamiento
				misCaballeros.get(i).mover();

				if (dist(kruger.getX(), kruger.getY(), misCaballeros.get(i).getX(),misCaballeros.get(i).getY()) < 100) {//Mensaje de cuidado
					image(advertencia, -10, 350);
				}

				if (dist(kruger.getX(), kruger.getY(), misCaballeros.get(i).getX(),misCaballeros.get(i).getY()) < 60) {//El choque y se devuelve
					nVidas -= 1;
					kruger.setX(10);
				}
			}
					
			for (int i = 0; i < misDracmasPlata.size(); i++) {//Dracmas de plata 
				misDracmasPlata.get(i).pintar1(this); // Llamo el pintar de cada clase que tenga un comportamiento
				
				if (dist(kruger.getX(), kruger.getY(),misDracmasPlata.get(i).getX(),misDracmasPlata.get(i).getY()) < 30) {	
					misDracmasPlata.remove(i);//Recoger dracma
					puntaje += 1;//sumar dracma
				}
			}
			
			if (kruger.getX()>1050 && puntaje==2) {
				pantalla=3;
				kruger.reset();
			}
	
			break;
//NIVEL 2
		case 3:
			dos.pintar(this);
			kruger.pintar(this);
			
			textSize(20);
			text(":" + puntaje, 1105, 70);
			
			for (int i = 0; i < misRemolinos.size(); i++) {
				misRemolinos.get(i).pintar(this); // Llamo el pintar de cada clase que tenga un comportamiento
				misRemolinos.get(i).mover();

				if (dist(kruger.getX(), kruger.getY(), misRemolinos.get(i).getX(),misRemolinos.get(i).getY()) < 100) {//Mensaje de cuidado
					image(advertencia, -10, 350);
				}
				
				if (dist(kruger.getX(), kruger.getY(), misRemolinos.get(i).getX(),misRemolinos.get(i).getY()) < 50) {//El choque y se devuelve
					if (vulnerabilidad) {
						nVidas -= 1;
						vulnerabilidad = false;
					}
					
					kruger.setX(10);
				}
			}
		
			for (int i = 0; i < misDracmasPlata2.size(); i++) {//Dracmas de plata 
				misDracmasPlata2.get(i).pintar2(this); // Llamo el pintar de cada clase que tenga un comportamiento
				
				if (dist(kruger.getX(), kruger.getY(),misDracmasPlata2.get(i).getX(),misDracmasPlata2.get(i).getY()) < 20) {	
					misDracmasPlata2.remove(i);//Recoger dracma
					puntaje += 1;//sumar dracma
				}
			}
			if (kruger.getX()>1050 && puntaje==4) {//INSERTAR QUE DEBE PASAR PARA SEGUIR AL OTRO NIVEL
				pantalla=4;
				kruger.reset();
			}
			break;
//NIVEL3
		case 4:
			tres.pintar(this);
			kruger.pintar(this);
			cerbero.pintar(this);
			cerbero.mover();
			if(cerbero.validar(kruger.getX(), kruger.getY())) {
				nVidas -= 1;
				kruger.reset();
			}			
			
			textSize(20);
			text(":" + puntaje, 1105, 70);
			text(":" + puntaje2, 1150, 70);
			
			
			for (int i = 0; i < misDracmasOro.size(); i++) {//Dracmas de plata 
				misDracmasOro.get(i).pintar3(this); // Llamo el pintar de cada clase que tenga un comportamiento
				
				if (dist(kruger.getX(), kruger.getY(),misDracmasOro.get(i).getX(),misDracmasOro.get(i).getY()) < 20) {	
					misDracmasOro.remove(i);//Recoger dracma
					puntaje2 += 1;//sumar dracma
				}
			}
			
			if (kruger.getX()>1050 && puntaje2==5) {//INSERTAR QUE DEBE PASAR PARA SEGUIR AL OTRO NIVEL
				pantalla=5;
				kruger.reset();
			}
			
			break;
//NIVEL4
		case 5:
			if (recogioLlave==true) {
				llave.setX(1100);
				llave.setY(600);
			}
					
			cuatro.pintar(this);
			llave.pintar(this);
			kruger.pintar(this);
			furia.pintar();
			furia.mover();
			if(furia.validar(kruger.getX(), kruger.getY())) {
				nVidas -= 1;
				kruger.reset();
			}
			
			textSize(20);
			text(":" + puntaje, 1105, 70);
			text(":" + puntaje2, 1150, 70);
			
			if (dist(kruger.getX(), kruger.getY(),llave.getX(), llave.getY()) < 50) {//Recolectar la llave	
				recogioLlave=true;
			}
			
			if (kruger.getX()>1050 && recogioLlave) {//INSERTAR QUE DEBE PASAR PARA SEGUIR AL OTRO NIVEL
				pantalla=6;
				kruger.reset();
			}	
			break;
//NIVEL5
		case 6:
			cinco.pintar(this);
			krugerB.pintar(this);
			
			
			textSize(20);
			text(":" + puntaje, 1105, 70);
			text(":" + puntaje2, 1150, 70);
			
			if (krugerB.getY()<=350) {//INSERTAR QUE DEBE PASAR PARA SEGUIR AL OTRO NIVEL
				krugerB.setY(350);
			}	
			
			if (krugerB.getX()>950) {//INSERTAR QUE DEBE PASAR PARA SEGUIR AL OTRO NIVEL
				pantalla=7;
				kruger.reset();
			}	
			break;
//NIVEL6
		case 7:
			seis.pintar(this);
			kruger.pintar(this);
			
			textSize(20);
			text(":" + puntaje, 1105, 70);
			text(":" + puntaje2, 1150, 70);
			
			if (kruger.getX()>1050) {//INSERTAR QUE DEBE PASAR PARA SEGUIR AL OTRO NIVEL
				pantalla=8;
				kruger.reset();
			}	
			break;
//NIVEL7
		case 8:
			siete.pintar(this);
			kruger.pintar(this);	
			
			textSize(20);
			text(":" + puntaje, 1105, 70);
			text(":" + puntaje2, 1150, 70);
			
			for (int i = 0; i < misFlechas.size(); i++) {
				misFlechas.get(i).pintar(this); // Llamo el pintar de cada clase que tenga un comportamiento
				misFlechas.get(i).mover();

				if (dist(kruger.getX(), kruger.getY(), misFlechas.get(i).getX(),misFlechas.get(i).getY()) < 100) {//Mensaje de cuidado
					image(advertencia, -10, 350);
				}
				
				if (dist(kruger.getX(), kruger.getY(), misFlechas.get(i).getX(),misFlechas.get(i).getY()) < 50) {//El choque y se devuelve
					kruger.setX(10);
				}
			}
			if (kruger.getX()>1050) {//INSERTAR QUE DEBE PASAR PARA SEGUIR AL OTRO NIVEL
				pantalla=9;
				kruger.reset();
			}		
			break;
//NIVEL8
		case 9:
			ocho.pintar(this);
			kruger.pintar(this);
			espada.pintarespada(this);
			espada.moverespada();
			
			hacha.pintarhacha(this);
			hacha.moverhacha();
			
			if(espada.choque(kruger.getX(), kruger.getY(), this)) {
				nVidas -= 1;
				kruger.reset();
			}
				
			textSize(20);
			text(":" + puntaje, 1105, 70);
			text(":" + puntaje2, 1150, 70);
			
			
			
			for (int i = 0; i < misDracmasOro2.size(); i++) {//Dracmas de plata 
				misDracmasOro2.get(i).pintar3(this); // Llamo el pintar de cada clase que tenga un comportamiento
				
				if (dist(kruger.getX(), kruger.getY(),misDracmasOro2.get(i).getX(),misDracmasOro2.get(i).getY()) < 20) {	
					misDracmasOro2.remove(i);//Recoger dracma
					puntaje2 += 1;//sumar dracma
				}
			}
			
			if (kruger.getX()>1050 && puntaje2==7) {//INSERTAR QUE DEBE PASAR PARA SEGUIR AL OTRO NIVEL
				pantalla=10;
				kruger.reset();
			}	
			break;
//NIVEL9
		case 10:
			nueve.pintar(this);
			kruger.pintar(this);
			
			textSize(20);
			text(":" + puntaje, 1105, 70);
			text(":" + puntaje2, 1150, 70);
			
			break;
//PANTALLA DE INSTRUCCIONES
		case 11:
			image(instrucciones, 0, 0);
			if(dist(mouseX, mouseY, 50, 30)<30) {
				stroke(100);
				strokeWeight(2);
				noFill();
				rect(35, 25, 65, 28);
				if(dist(mouseX, mouseY, 50, 30)<10) {
					pantalla=0;
				}
			}
			break;
		default:
			break;
		}
		if(pantalla >1) {
		for (int i = 0; i < nVidas; i++) {
			image(Vida, 1100 + (20*i), 500);
		}
		}
		if (!vulnerabilidad) {
			tInvulnerabilida ++;
			if (tInvulnerabilida == 100) {
				vulnerabilidad = true;
				tInvulnerabilida = 0;
			}
		}
	}

	public void mousePressed() {
		if (dist(mouseX, mouseY, 745, 415) < 50) {// botón descender/jugar
			pantalla = 1;
		}
		if (dist(mouseX, mouseY, 745, 520) < 50) {// botón instrucciones
			pantalla = 11;
		}
		
	
		if (dist(mouseX, mouseY, krugerB.getX(), krugerB.getY())<krugerB.dist()) {
			sel = krugerB;
		}
	}

	@Override
	public void mouseDragged() {
	if(sel!=null) {
		sel.setX(mouseX);
		sel.setY(mouseY);
		}
	}
	
	@Override
	public void mouseReleased() {
	sel = null;
	}
	
	public void keyPressed() {
		kruger.mover(this);
	}

}
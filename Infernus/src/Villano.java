import processing.core.PApplet;

public abstract class Villano {

	protected int x,y;
	
	
	public Villano() {
		this.x = (int) (Math.random()*200); 
		this.y = (int) (Math.random()*600);
	}
	public Villano (int x, int y) {
		this.x=x;
		this.y=y;
		}
	public abstract void pintar(PApplet app);
	
	public void mover() {
		x++;
		y++;	
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}

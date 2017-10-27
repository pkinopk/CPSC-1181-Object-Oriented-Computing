import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Disc {

	private final int WIDTH = 80;
	private final int HEIGHT = 80;

	private Color color;
	private int x;
	private int y;
	private int dx;
	private int dy;

	public Disc(Color c, int x, int y) {

		this.color = c;
		this.x = x;
		this.y = y;
		this.dx = 1;
		this.dy = 1;
	}

	public void draw(Graphics2D g2) {
		Ellipse2D.Double disc = new Ellipse2D.Double(x, y, WIDTH, HEIGHT);
		g2.setColor(color);
		g2.fill(disc);
		g2.setColor(Color.black);
		g2.draw(disc);
	}

	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
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

	public void invertDx() {
		dx *= -1;
	}

	public void invertDy() {
		dy *= -1;
	}

	public void increaseX() {
		x += dx;
	}

	public void increaseY() {
		y += dy;
	}

	public int getDx() {
		return dx;
	}

	public int getDy() {
		return dy;
	}

}
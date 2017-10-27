import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class RainDrop {

	private final int WIDTH = 20;
	private final int HEIGHT = 20;

	private Color color;
	private int xPos;
	private int yPos;

	public RainDrop(Color c, int x, int y) {

		this.color = c;
		this.xPos = x;
		this.yPos = y;
	}

	public void draw(Graphics2D g2) {

		Ellipse2D.Double drop = new Ellipse2D.Double(xPos, yPos + HEIGHT / 2,
				WIDTH, HEIGHT);
		g2.setColor(color);
		g2.fill(drop);

		g2.fillPolygon(new int[] { xPos, xPos + (WIDTH / 2), xPos + WIDTH },
				new int[] { yPos + HEIGHT, yPos, yPos + HEIGHT }, 3);
		g2.fillPolygon(new int[] { 30, 40, 50 }, new int[] { 70, 80, 90 }, 3);

	}

	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}

}
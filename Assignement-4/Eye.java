import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Eye {

	private Color color;
	private int size;

	public Eye(Color c, int s) {
		this.color = c;
		this.size = s;
	}

	public void draw(int x, int y, Graphics2D g2) {
		Ellipse2D.Double eye1 = new Ellipse2D.Double(x, y, size, size);
		g2.setColor(color);
		g2.fill(eye1);

		Ellipse2D.Double eye2 = new Ellipse2D.Double(x + 75, y, size, size);
		g2.setColor(color);
		g2.fill(eye2);

	}

}

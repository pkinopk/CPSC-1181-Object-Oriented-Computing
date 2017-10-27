import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class DiscComponent extends JComponent {

	private Disc r = new Disc(Color.yellow, 0, 0);

	private int posX = 0;
	private int posY = 0;

	private Graphics2D g2;
	private Color color;

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		Color color = Color.yellow;
		r.draw(g2);
		bounce();

	}

	public void bounce() {
		r.increaseX();
		r.increaseY();

		if (r.getX() + r.getWidth() > this.getWidth() || r.getX() < 0) {
			r.invertDx();
		}
		if (r.getY() + r.getHeight() > this.getHeight() || r.getY() < 0) {
			r.invertDy();
		}

		repaint();
	}
}

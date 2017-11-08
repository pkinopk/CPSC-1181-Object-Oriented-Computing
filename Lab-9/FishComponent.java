import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class FishComponent extends JComponent {
	private JLabel display;
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 300;
	Fish fish = new Fish();

	@Override
	public void paintComponent(Graphics g) {

		fish.draw(this, g);
		requestFocusInWindow();
		// r.draw(g2);
		// Graphics2D g2 = (Graphics2D) g;
		// g2.draw(box1);
		// g2.draw(box2);
		// g2.setColor(Color.yellow);
	}

	public void moveFishBy(int dx, int dy) {
		Point p1 = fish.current;
		Point p2 = new Point(p1.x + dx, p1.y + dy);
		fish.setPosition(p2);
		repaint();
	}

	public Point getFishPos() {
		return fish.getPosition();
	}

	public int getFrameWidth() {
		return FRAME_WIDTH;
	}

	public int getFrameHeight() {
		return FRAME_HEIGHT;
	}

}

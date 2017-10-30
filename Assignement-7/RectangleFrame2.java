import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.KeyStroke;

/**
 * This frame contains a moving rectangle.
 */
public class RectangleFrame2 extends JFrame {
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 600;

	private RectangleComponent2 scene;

	class MousePressListener implements MouseListener {
		int size = scene.getBoxSize();

		public void mousePressed(MouseEvent event) {

		}

		// Do-nothing methods
		public void mouseReleased(MouseEvent event) {
			int x = event.getX();
			int y = event.getY();
			int closest = getClosestPoint(x, y);

			if (closest == 1) {
				scene.moveRectangleTo(x, y);
			}
			if (closest == 2) {
				scene.moveRectangleTo(x - size, y);
			}
			if (closest == 3) {
				scene.moveRectangleTo(x, y - size);
			}
			if (closest == 4) {
				scene.moveRectangleTo(x - size, y - size);
			}
		}

		public void mouseClicked(MouseEvent event) {
		}

		public void mouseEntered(MouseEvent event) {
		}

		public void mouseExited(MouseEvent event) {
		}
	}

	class KeyStrokeListener implements KeyListener {
		public void keyPressed(KeyEvent event) {
			String key = KeyStroke.getKeyStrokeForEvent(event).toString()
					.replace("pressed ", "");
			if (key.equals("DOWN") && checkBoundaries(2)) {
				scene.moveRectangleBy(0, 1);
			} else if (key.equals("UP") && checkBoundaries(1)) {
				scene.moveRectangleBy(0, -1);
			} else if (key.equals("LEFT") && checkBoundaries(4)) {
				scene.moveRectangleBy(-1, 0);
			} else if (key.equals("RIGHT") && checkBoundaries(3)) {
				scene.moveRectangleBy(1, 0);
			}
		}

		public void keyTyped(KeyEvent event) {
		}

		public void keyReleased(KeyEvent event) {
		}
	}

	public RectangleFrame2() {
		scene = new RectangleComponent2();
		add(scene);

		MouseListener listener = new MousePressListener();
		scene.addMouseListener(listener);

		scene.addKeyListener(new KeyStrokeListener());
		scene.setFocusable(true);

		setSize(FRAME_WIDTH, FRAME_HEIGHT);

	}

	public int getClosestPoint(int x, int y) {
		int oldX = scene.getBoxX();
		int oldY = scene.getBoxY();
		int size = scene.getBoxSize();
		double closest;
		int closestPoint = 1;

		Point p0 = new Point(x, y); // where it was clicked

		Point p1 = new Point(oldX, oldY); // top left
		Point p2 = new Point(oldX + size, oldY); // top right
		Point p3 = new Point(oldX, oldY + size); // bottom left
		Point p4 = new Point(oldX + size, oldY + size); // bottom right

		closest = p0.distance(p1);
		if (p0.distance(p2) < closest) {
			closest = p0.distance(p2);
			closestPoint = 2;
		}
		if (p0.distance(p3) < closest) {
			closest = p0.distance(p3);
			closestPoint = 3;
		}
		if (p0.distance(p4) < closest) {
			closest = p0.distance(p4);
			closestPoint = 4;
		}
		return closestPoint;
	}

	public boolean checkBoundaries(int direction) {
		// direction values: 1-UP; 2-DOWN; 3-RIGHT; 4-LEFT.
		int w = scene.getWidth();
		int h = scene.getHeight();
		int x = scene.getBoxX();
		int y = scene.getBoxY();
		int size = scene.getBoxSize();

		if (direction == 1) {
			if (y > 0) {
				return true;
			}
		}

		if (direction == 2) {
			if (y + size + 1 < h) {
				return true;
			}
		}

		if (direction == 3) {
			if (x + size + 1 < w) {
				return true;
			}
		}

		if (direction == 4) {
			if (x > 0) {
				return true;
			}
		}

		return false;
	}
}

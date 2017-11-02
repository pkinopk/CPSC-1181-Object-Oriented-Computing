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
public class CubeFrame extends JFrame {
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 600;
	private static final int UP = 1;
	private static final int DOWN = 2;
	private static final int RIGHT = 3;
	private static final int LEFT = 4;
	private int x;
	private int y;
	private int closest;
	private CubeComponent scene;

	public CubeFrame() {
		scene = new CubeComponent();
		add(scene);

		MouseListener listener = new MousePressListener();
		scene.addMouseListener(listener);

		scene.addKeyListener(new KeyStrokeListener());
		scene.setFocusable(true);

		setSize(FRAME_WIDTH, FRAME_HEIGHT);

	}

	class MousePressListener implements MouseListener {
		int size = scene.getRectanglesSize();

		public void mousePressed(MouseEvent event) {
			x = event.getX();
			y = event.getY();
			closest = getClosestPoint(x, y);
		}

		public void mouseReleased(MouseEvent event) {
			int shift = scene.getShift();
			x = event.getX();
			y = event.getY();

			if (closest == 1) {
				scene.moveCubeTo(x - shift, y);
			} else if (closest == 2) {
				scene.moveCubeTo(x - shift - size, y);
			} else if (closest == 3) {
				scene.moveCubeTo(x - shift, y - size);
			} else if (closest == 4) {
				scene.moveCubeTo(x - shift - size, y - size);
			} else if (closest == 5) {
				scene.moveCubeTo(x, y + shift - size);
			} else if (closest == 6) {
				scene.moveCubeTo(x - size, y + shift - size);
			} else if (closest == 7) {
				scene.moveCubeTo(x, y + shift - size - size);
			} else if (closest == 8)
				scene.moveCubeTo(x - size, y + shift - size - size);

		}

		// Do-nothing methods
		public void mouseClicked(MouseEvent event) {
		}

		public void mouseEntered(MouseEvent event) {
		}

		public void mouseExited(MouseEvent event) {
		}
	}

	class KeyStrokeListener implements KeyListener {
		public void keyPressed(KeyEvent event) {
			String key = KeyStroke.getKeyStrokeForEvent(event).toString().replace("pressed ", "");
			if (key.equals("DOWN") && checkBoundaries(2)) {
				scene.moveCubeBy(0, 1);
			} else if (key.equals("UP") && checkBoundaries(1)) {
				scene.moveCubeBy(0, -1);
			} else if (key.equals("LEFT") && checkBoundaries(4)) {
				scene.moveCubeBy(-1, 0);
			} else if (key.equals("RIGHT") && checkBoundaries(3)) {
				scene.moveCubeBy(1, 0);
			}
		}

		// Do-nothing methods
		public void keyTyped(KeyEvent event) {
		}

		public void keyReleased(KeyEvent event) {
		}
	}

	/**
	 * Gets the closest point in relation to where it was clicked
	 * 
	 * @param x
	 *            X position
	 * @param y
	 *            Y position
	 * @return int representing the closest point
	 */
	public int getClosestPoint(int x, int y) {
		int shift = scene.getShift();
		int oldX = scene.getBoxX();
		int oldY = scene.getBoxY();
		int size = scene.getRectanglesSize();
		double closest;
		int closestPoint = 0;

		Point p0 = new Point(x, y); // where it was clicked

		// first rectangle
		Point[] cube = new Point[8];
		cube[0] = new Point(oldX, oldY); // top left
		cube[1] = new Point(oldX + size, oldY); // top right
		cube[2] = new Point(oldX, oldY + size); // bottom left
		cube[3] = new Point(oldX + size, oldY + size); // bottom right
		// second rectangle
		cube[4] = new Point(oldX, oldY + shift); // top left
		cube[5] = new Point(oldX + shift, oldY + shift); // top right
		cube[6] = new Point(oldX, oldY + size + shift); // bottom left
		cube[7] = new Point(oldX + shift, oldY + size + shift); // bottom right

		closest = p0.distance(cube[0]);
		for (int i = 1; i < 8; i++) {
			if (p0.distance(cube[i]) < closest) {
				closest = p0.distance(cube[i]);
				closestPoint = i;
			}
		}
		return closestPoint + 1;

	}

	/**
	 * Check if the cube can be moved without going outside the frame
	 * 
	 * @param direction
	 *            the direction which the cube is being moved
	 * @return true if the cube can be moved without going outside the frame, false
	 *         otherwise
	 */
	public boolean checkBoundaries(int direction) {
		int w = scene.getWidth();
		int h = scene.getHeight();
		int x = scene.getBoxX();
		int y = scene.getBoxY();
		int size = scene.getRectanglesSize();
		int shift = scene.getShift();

		if (direction == UP && y > 0)
			return true;
		else if (direction == DOWN && y + size + 1 + shift < h)
			return true;
		else if (direction == RIGHT && x + size + 1 < w)
			return true;
		else if (direction == LEFT && x - shift > 0)
			return true;
		else
			return false;
	}
}

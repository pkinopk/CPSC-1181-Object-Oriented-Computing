import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JComponent;

/**
 * This component displays a rectangle that can be moved.
 */
public class RectangleComponent2 extends JComponent {
	private static final int BOX_X = 100;
	private static final int BOX_Y = 100;
	private static final int BOX_SIZE = 100;

	private Rectangle box;

	public RectangleComponent2() {
		// The rectangle that the paintComponent method draws
		box = new Rectangle(BOX_X, BOX_Y, BOX_SIZE, BOX_SIZE);
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.draw(box);
	}

	/**
	 * Moves the rectangle to the given location.
	 * 
	 * @param x
	 *            the x-position of the new location
	 * @param y
	 *            the y-position of the new location
	 */
	public void moveRectangleTo(int x, int y) {
		box.setLocation(x, y);
		repaint();
	}

	public Point getBoxLocation() {
		return box.getLocation();
	}

	public int getBoxX() {
		return (int) box.getX();
	}

	public int getBoxY() {
		return (int) box.getY();
	}

	public int getBoxSize() {
		return BOX_SIZE;
	}

	/**
	 * Moves the rectangle by a given amount.
	 * 
	 * @param dx
	 *            the amount to move in the x-direction
	 * @param dy
	 *            the amount to move in the y-direction
	 */
	public void moveRectangleBy(int dx, int dy) {
		box.translate(dx, dy);
		repaint();
	}
}

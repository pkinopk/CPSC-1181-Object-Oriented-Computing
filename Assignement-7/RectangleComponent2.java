import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;

import javax.swing.JComponent;

/**
 * This component displays a rectangle that can be moved.
 */
public class RectangleComponent2 extends JComponent {
	private static final int BOX_X = 100;
	private static final int BOX_Y = 100;
	private static final int BOX_SIZE = 100;
	private static final int SHIFT = 50;

	private Rectangle box1;
	private Rectangle box2;
	private Polygon[] lines;
	Graphics2D g2; // TODO remove

	public RectangleComponent2() {
		// The rectangle that the paintComponent method draws
		box1 = new Rectangle(BOX_X + SHIFT, BOX_Y, BOX_SIZE, BOX_SIZE);
		box2 = new Rectangle(BOX_X, BOX_Y + SHIFT, BOX_SIZE, BOX_SIZE);
		lines = new Polygon[4];
		lines[0] = new Polygon();
		lines[0].addPoint(BOX_X + SHIFT, BOX_Y);
		lines[0].addPoint(BOX_X, BOX_Y + SHIFT);
		lines[1] = new Polygon();
		lines[1].addPoint(BOX_X + SHIFT + BOX_SIZE, BOX_Y);
		lines[1].addPoint(BOX_X + BOX_SIZE, BOX_Y + SHIFT);
		lines[2] = new Polygon();
		lines[2].addPoint(BOX_X + SHIFT, BOX_Y + BOX_SIZE);
		lines[2].addPoint(BOX_X, BOX_Y + SHIFT + BOX_SIZE);
		lines[3] = new Polygon();
		lines[3].addPoint(BOX_X + SHIFT + BOX_SIZE, BOX_Y + BOX_SIZE);
		lines[3].addPoint(BOX_X + BOX_SIZE, BOX_Y + SHIFT + BOX_SIZE);

	}

	public void paintComponent(Graphics g) {
		g2 = (Graphics2D) g;
		g2.draw(box1);
		g2.draw(box2);
		for (int i = 0; i < lines.length; i++) {
			g2.draw(lines[i]);
		}

		// drawLines(100, 100);
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
		box1.setLocation(x + SHIFT, y);
		box2.setLocation(x, y + SHIFT);
		// TODO update the lines position
		repaint();
	}

	public void drawLines(int x, int y) {
		g2.drawLine(x + SHIFT, y, x, y + SHIFT);
		g2.drawLine(x + SHIFT + BOX_SIZE, y, BOX_X + BOX_SIZE, y + SHIFT);
		g2.drawLine(x + SHIFT, y + BOX_SIZE, x, y + SHIFT + BOX_SIZE);
		g2.drawLine(x + SHIFT + BOX_SIZE, y + BOX_SIZE, BOX_X + BOX_SIZE, y
				+ SHIFT + BOX_SIZE);
	}

	public Point getBoxLocation() {
		return box1.getLocation();
	}

	public int getBoxX() {
		return (int) box1.getX();
	}

	public int getBoxY() {
		return (int) box1.getY();
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
		box1.translate(dx, dy);
		box2.translate(dx, dy);
		repaint();
	}

	public int getShift() {
		return SHIFT;
	}
}

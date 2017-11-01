import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;

import javax.swing.JComponent;

//TODO update all javadoc comments

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

	/**
	 * 
	 */
	public RectangleComponent2() {
		// The rectangle that the paintComponent method draws
		box1 = new Rectangle(BOX_X + SHIFT, BOX_Y, BOX_SIZE, BOX_SIZE);
		box2 = new Rectangle(BOX_X, BOX_Y + SHIFT, BOX_SIZE, BOX_SIZE);

		lines = new Polygon[4];
		lines[0] = new Polygon(new int[] { BOX_X + SHIFT, BOX_X }, new int[] { BOX_Y, BOX_Y + SHIFT }, 2);
		lines[1] = new Polygon(new int[] { BOX_X + SHIFT + BOX_SIZE, BOX_X + BOX_SIZE }, new int[] { BOX_Y, BOX_Y + SHIFT }, 2);
		lines[2] = new Polygon(new int[] { BOX_X + SHIFT, BOX_X }, new int[] { BOX_Y + BOX_SIZE, BOX_Y + SHIFT + BOX_SIZE }, 2);
		lines[3] = new Polygon(new int[] { BOX_X + SHIFT + BOX_SIZE, BOX_X + BOX_SIZE }, new int[] { BOX_Y + BOX_SIZE, BOX_Y + SHIFT + BOX_SIZE }, 2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.draw(box1);
		g2.draw(box2);
		for (int i = 0; i < lines.length; i++) {
			g2.draw(lines[i]);
		}
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
		lines[0] = new Polygon(new int[] { x + SHIFT, x }, new int[] { y, y + SHIFT }, 2);
		lines[1] = new Polygon(new int[] { x + SHIFT + BOX_SIZE, x + BOX_SIZE }, new int[] { y, y + SHIFT }, 2);
		lines[2] = new Polygon(new int[] { x + SHIFT, x }, new int[] { y + BOX_SIZE, y + SHIFT + BOX_SIZE }, 2);
		lines[3] = new Polygon(new int[] { x + SHIFT + BOX_SIZE, x + BOX_SIZE }, new int[] { y + BOX_SIZE, y + SHIFT + BOX_SIZE }, 2);
		repaint();
	}

	/**
	 * @return
	 */
	public int getBoxX() {
		return (int) box1.getX();
	}

	/**
	 * @return
	 */
	public int getBoxY() {
		return (int) box1.getY();
	}

	/**
	 * @return
	 */
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
		for (int i = 0; i < 4; i++) {
			lines[i].translate(dx, dy);
		}
		repaint();
	}

	/**
	 * @return
	 */
	public int getShift() {
		return SHIFT;
	}
}

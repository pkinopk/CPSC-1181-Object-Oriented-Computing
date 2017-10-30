import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

/**
 * This frame contains a moving rectangle.
 */
public class RectangleFrame2 extends JFrame {
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 600;

	private RectangleComponent2 scene;

	class MousePressListener implements MouseListener {
		public void mousePressed(MouseEvent event) {
			int x = event.getX();
			int y = event.getY();
			getClosestPoint(x, y);
			scene.moveRectangleTo(x, y);
		}

		// Do-nothing methods
		public void mouseReleased(MouseEvent event) {
		}

		public void mouseClicked(MouseEvent event) {
		}

		public void mouseEntered(MouseEvent event) {
		}

		public void mouseExited(MouseEvent event) {
		}
	}

	public RectangleFrame2() {
		scene = new RectangleComponent2();
		add(scene);

		MouseListener listener = new MousePressListener();
		scene.addMouseListener(listener);

		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	public int getClosestPoint(int x, int y) {
		int oldX = scene.getX();
		int oldY = scene.getY();
		int size = scene.getBoxSize();
		double closest;
		int closestPoint = 1;

		Point p0 = new Point(x, y); // where it was clicked

		Point p1 = new Point(oldX, oldY);
		Point p2 = new Point(oldX + size, oldY);
		Point p3 = new Point(oldX, oldY + size);
		Point p4 = new Point(oldX + size, oldY + size);

		System.out.println("Distance to P1: " + p1.distance(p0));
		System.out.println("Distance to P2: " + p2.distance(p0));
		System.out.println("Distance to P3: " + p3.distance(p0));
		System.out.println("Distance to P4: " + p4.distance(p0));
		System.out.println();

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
}

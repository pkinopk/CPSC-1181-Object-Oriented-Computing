import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class Rose extends Flower {

	private final static int N_PETALS = 3;

	public Rose() {
		super(N_PETALS, FlowerComponent.getRandomColor(), FlowerComponent.getRandomInt(FlowerViewer.FRAME_WIDTH - 180),
				FlowerComponent.getRandomInt(FlowerViewer.FRAME_HEIGHT - 180), 40, 40);
	}

	@Override
	public void draw(Graphics2D g2) {
		int x = getXUpLeft();
		int y = getYUpLeft();
		int s = 20;

		AffineTransform old = g2.getTransform(); // save position
		g2.translate(x, y);
		g2.setColor(Color.GREEN);
		g2.fillRect(s - 1, s / 2, 4, 2 * s);
		g2.setColor(Color.BLACK);
		g2.drawRect(s - 1, s / 2, 4, 2 * s);

		g2.setColor(super.getColor()); // petals
		g2.fillOval(s / 2, 0, s, s);
		g2.setColor(Color.BLACK);
		g2.drawOval(s / 2, 0, s, s);
		g2.setColor(super.getColor()); // petals
		g2.fillOval(0, s / 2, s, s);
		g2.setColor(Color.BLACK);
		g2.drawOval(0, s / 2, s, s);
		g2.setColor(super.getColor()); // petals
		g2.fillOval(s, s / 2, s, s);
		g2.setColor(Color.BLACK);
		g2.drawOval(s, s / 2, s, s);
		g2.setTransform(old); // restore position

	}

}

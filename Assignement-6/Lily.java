import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class Lily extends Flower {

	private final static int N_PETALS = 16;

	public Lily() {
		super(N_PETALS, FlowerComponent.getRandomColor(), FlowerComponent.getRandomInt(FlowerViewer.FRAME_WIDTH - 1),
				FlowerComponent.getRandomInt(FlowerViewer.FRAME_HEIGHT - 180), 40, 40);
	}

	@Override
	public void draw(Graphics2D g2) {
		int x = getXUpLeft();
		int y = getYUpLeft();

		AffineTransform old = g2.getTransform(); // save position
		g2.setColor(super.getColor()); // petals
		g2.translate(x + getFlowerWidth(), y + getFlowerHeight());
		for (int i = 0; i < N_PETALS; i++) {
			g2.setColor(super.getColor()); // petals
			g2.fillOval(0, 0, 10, 40);
			g2.setColor(Color.BLACK);
			g2.drawOval(0, 0, 10, 40);
			g2.rotate(Math.toRadians(360 / N_PETALS));

		}
		g2.setColor(Color.YELLOW); // pistil
		g2.fillOval(-10, -10, 20, 20);
		g2.setColor(Color.BLACK);
		g2.drawOval(-10, -10, 20, 20);
		g2.setTransform(old); // restore position

	}
}

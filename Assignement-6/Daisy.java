import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class Daisy extends Flower {

	private final static int N_PETALS = 5;
	private final static int PETAL_SIZE = 40;

	public Daisy() {
		super(N_PETALS, FlowerComponent.getRandomColor(), FlowerComponent.getRandomInt(FlowerViewer.FRAME_WIDTH - 180),
				FlowerComponent.getRandomInt(FlowerViewer.FRAME_HEIGHT - 180), 95, 95);
	}

	@Override
	public void draw(Graphics2D g2) {
		int x = getXUpLeft();
		int y = getYUpLeft();

		AffineTransform old = g2.getTransform(); // save position
		g2.translate(x + 50, y + 50);

		g2.setColor(super.getColor()); // petals
		g2.fillOval(0, 0, PETAL_SIZE, PETAL_SIZE);
		for (int i = 0; i < N_PETALS; i++) {
			g2.setColor(super.getColor());
			g2.fillOval(0, 0, PETAL_SIZE, PETAL_SIZE);
			g2.setColor(Color.BLACK);
			g2.drawOval(0, 0, PETAL_SIZE, PETAL_SIZE);
			g2.rotate(Math.toRadians(360 / N_PETALS));

		}
		g2.setColor(Color.YELLOW); // pistil
		g2.fillOval(-13, -13, 26, 26);
		g2.setColor(Color.BLACK);
		g2.drawOval(-13, -13, 26, 26);
		// g2.draw(rect);

		// System.out.println(rect.getBounds().intersects(rect.getBounds()));
		g2.setTransform(old); // restore position
		// System.out.println(rect.getBounds());

		// rect.getBounds().intersects(rect.getBounds())

	}

}
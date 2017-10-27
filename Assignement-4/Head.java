import java.awt.Color;
import java.awt.Graphics2D;

public class Head {

	private int width;
	private int height;
	private int x;
	private int y;
	private int mount;
	private int nose;
	private Color hair;

	public Head(int x, int y, int m, int n, Color h, int width, int height) {
		this.x = x;
		this.y = y;
		this.mount = m;
		this.nose = n;
		this.hair = h;
		this.width = width;
		this.height = height;
	}

	public void draw(Graphics2D g2) {

		Color skinColor = new Color(234, 192, 134);

		g2.setColor(skinColor);
		g2.fillOval(x, y, width, height);
		// head

		// nose
		g2.setColor(Color.BLACK);
		g2.drawLine((x + width / 2), y + 90, (x + width / 2), y + nose);

		// mount
		g2.setColor(Color.BLACK);
		g2.drawArc(x + 60, y + 150, mount, 40, 0, -180);

		// hair
		g2.setColor(hair);
		g2.fillRoundRect(x + 25, y, 150, 40, 10, 10);
	}

}

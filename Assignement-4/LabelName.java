import java.awt.Graphics2D;

public class LabelName {

	private String string;

	public LabelName(String s) {
		this.string = s;
	}

	public void draw(int x, int y, Graphics2D g2) {

		g2.drawString(string, x, y);

	}

}

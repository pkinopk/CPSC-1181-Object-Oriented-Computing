import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class HeadComponent extends JComponent {
	private final int POS = 30;

	@Override
	public void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		Color eyeColorYoung = new Color(161, 202, 241);
		Eye eYoung = new Eye(eyeColorYoung, 25);
		Head h1 = new Head(POS, POS, 80, 130, Color.black, 200, 250);
		h1.draw(g2);
		eYoung.draw(POS + 50, POS + 50, g2);
		LabelName l1 = new LabelName("Now");
		l1.draw(POS + 150, POS + 260, g2);

		int x = POS + FrameViewer.FRAME_WIDTH / 2;
		int y = POS + FrameViewer.FRAME_HEIGHT / 2;
		Color eyeColorOld = new Color(161, 202, 180);
		Eye eOld = new Eye(eyeColorOld, 25);
		Head h2 = new Head(x, y, 80, 150, Color.GRAY, 200, 250);
		h2.draw(g2);
		eOld.draw(x + 50, y + 50, g2);
		LabelName l2 = new LabelName("20 yrs. later");
		l2.draw(x + 150, y + 260, g2);

	}
}

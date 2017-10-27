import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class RainDropsComponent extends JComponent {

	int n = getNumber();

	@Override
	public void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		for (int i = 0; i < n; i++) {
			Color color = new Color(0, getRandomInt(255), 255);
			RainDrop r = new RainDrop(color, getRandomInt(RainDropsViewer.FRAME_WIDTH - 50),
					getRandomInt(RainDropsViewer.FRAME_HEIGHT - 50));

			r.draw(g2);
		}
	}

	public static int getRandomInt(int range) {

		Random rnd = new Random();
		int i = rnd.nextInt(range + 1);
		return i;
	}

	public static int getNumber() {

		String inputValue = JOptionPane.showInputDialog(null, "Enter a number: ", "How many?", 3);
		int intValue;
		try {
			intValue = Integer.parseInt(inputValue);
			if (intValue >= Integer.MIN_VALUE && intValue <= Integer.MAX_VALUE)
				return intValue;
			else
				intValue = 0;
		} catch (NumberFormatException e) {
			intValue = 0;
		}
		return intValue;
	}
}

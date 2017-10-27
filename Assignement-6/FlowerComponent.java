import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class FlowerComponent extends JComponent {

	ArrayList<Flower> arr = new ArrayList<Flower>();
	int n = getNumberFromUser();

	@Override
	public void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		Flower f = null;
		Rectangle rArr;
		Rectangle r;

		for (int i = 0; i < n; i++) {
			int flowerNum = getRandomInt(3);

			if (flowerNum == 1) {
				f = new Daisy();
			} else if (flowerNum == 2) {
				f = new Lily();
			} else
				f = new Rose();

			if (arr.size() == 0) {
				arr.add(f);
			} else {
				for (int j = 0; j < arr.size(); j++) {

					rArr = arr.get(j).getBoundingRectangle();
					r = f.getBoundingRectangle();
					if (!r.intersects(rArr)) {
						arr.add(f);
						j = arr.size();
					}

				}
			}

		}

		for (int i = 0; i < n; i++) {
			Flower d = arr.get(i);
			d.draw(g2);
		}

	}

	public static Color getRandomColor() {

		Random rnd = new Random();
		Color c = new Color(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
		return c;
	}

	public static int getRandomInt(int max) {

		Random rnd = new Random();
		int i = rnd.nextInt(max) + 1;
		return i;
	}

	public static int getNumberFromUser() {

		String inputValue = JOptionPane.showInputDialog(null, "Enter a number of flowers: ", "How many?", 3);
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

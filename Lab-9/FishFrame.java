import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 * This frame contains a panel that displays buttons for a calculator and a
 * panel with a text fields to specify the result of calculation. The operator
 * buttons don't do anything--see Worked Example 1 for a working calculator.
 */
public class FishFrame extends JFrame {
	private JLabel display;

	private static final int FRAME_WIDTH = 600;
	private static final int FRAME_HEIGHT = 400;
	private static final int UP = 1;
	private static final int DOWN = 2;
	private static final int RIGHT = 3;
	private static final int LEFT = 4;
	private FishComponent fishComponent;

	public FishFrame() {
		fishComponent = new FishComponent();
		add(fishComponent);

		fishComponent.addKeyListener(new KeyStrokeListener());
		fishComponent.setFocusable(true);
		// display = new JLabel("0");
		// add(display, BorderLayout.NORTH);
		createButtonPanel();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	/**
	 * Creates the button panel.
	 */
	private void createButtonPanel() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2, 2));

		JButton buttonUP = new JButton("UP");
		buttonUP.addActionListener(e -> fishComponent.moveFishBy(0, -1));
		buttonPanel.add(buttonUP);
		JButton buttonRIGHT = new JButton("RIGHT");
		buttonRIGHT.addActionListener(e -> fishComponent.moveFishBy(1, 0));
		buttonPanel.add(buttonRIGHT);
		JButton buttonDOWN = new JButton("DOWN");
		buttonDOWN.addActionListener(e -> fishComponent.moveFishBy(0, 1));
		buttonPanel.add(buttonDOWN);
		JButton buttonLEFT = new JButton("LEFT");
		buttonLEFT.addActionListener(e -> fishComponent.moveFishBy(-1, 0));
		buttonPanel.add(buttonLEFT);

		add(buttonPanel, BorderLayout.NORTH);
	}

	class KeyStrokeListener implements KeyListener {
		public void keyPressed(KeyEvent event) {
			String key = KeyStroke.getKeyStrokeForEvent(event).toString().replace("pressed ", "");
			if (key.equals("DOWN") && checkBoundaries(DOWN)) {
				fishComponent.moveFishBy(0, 1);
			} else if (key.equals("UP") && checkBoundaries(UP)) {
				fishComponent.moveFishBy(0, -1);
			} else if (key.equals("LEFT") && checkBoundaries(LEFT)) {
				fishComponent.moveFishBy(-1, 0);
			} else if (key.equals("RIGHT") && checkBoundaries(RIGHT)) {
				fishComponent.moveFishBy(1, 0);
			}
		}

		// Do-nothing methods
		public void keyTyped(KeyEvent event) {
		}

		public void keyReleased(KeyEvent event) {
		}
	}

	public boolean checkBoundaries(int direction) {
		int w = fishComponent.getWidth();
		int h = fishComponent.getHeight();
		// int x = fishComponent.getBoxX();
		// int y = fishComponent.getBoxY();
		Point p = fishComponent.getFishPos();
		// int size = fishComponent.getRectanglesSize();
		// int shift = fishComponent.getShift();

		if (direction == UP && p.y > 0)
			return true;
		else if (direction == DOWN && p.y + fishComponent.getFrameWidth() + 1 < h)
			return true;
		else if (direction == RIGHT && p.x + fishComponent.getFrameHeight() + 1 < w)
			return true;
		else if (direction == LEFT && p.x > 0)
			return true;
		else
			return false;
	}

	class DigitButtonListener implements ActionListener {
		private String digit;

		/**
		 * Constructs a listener whose actionPerformed method adds a digit to
		 * the display.
		 * 
		 * @param aDigit
		 *            the digit to add
		 */
		public DigitButtonListener(String aDigit) {
			digit = aDigit;
		}

		public void actionPerformed(ActionEvent event) {
			display.setText(display.getText() + digit);
		}
	}

	/**
	 * Makes a button representing a digit of a calculator.
	 * 
	 * @param digit
	 *            the digit of the calculator
	 * @return the button of the calculator
	 */
	public JButton makeDigitButton(String digit) {
		JButton button = new JButton(digit);

		ActionListener listener = new DigitButtonListener(digit);
		button.addActionListener(listener);
		return button;
	}

	/**
	 * Makes a button representing an operator of a calculator.
	 * 
	 * @param op
	 *            the operator of the calculator
	 * @return the button of the calcalator
	 */
	public JButton makeOperatorButton(String op) {
		JButton button = new JButton(op);
		return button;
	}
}

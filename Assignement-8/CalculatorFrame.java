import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorFrame extends JFrame {
	private static final int FRAME_WIDTH = 450;
	private static final int FRAME_HEIGHT = 100;

	private JTextField dataEntry;
	private JButton calculate;
	private JLabel resultLabel;

	public CalculatorFrame() {
		resultLabel = new JLabel("");
		createTextField();
		createButton();
		createPanel();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	private void createTextField() {

		final int FIELD_WIDTH = 10;
		dataEntry = new JTextField(FIELD_WIDTH);
	}

	class CalculateExpression implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			String s = dataEntry.getText();
			Scanner in = new Scanner(s);
			int firstInt;
			String operator;
			int secondInt;
			String rest;

			try {
				firstInt = in.nextInt();
				try {
					operator = in.next();

					try {
						secondInt = in.nextInt();
						try {
							calculate(firstInt, operator, secondInt);
						} catch (Exception e) {
						}
					} catch (InputMismatchException e) {
						resultLabel.setText("Second operand is not an Integer");
					} catch (NoSuchElementException e) {
						resultLabel.setText("Missing second operand");
					}
				} catch (NoSuchElementException e) {
					resultLabel.setText("Missing operator");
				}
			} catch (InputMismatchException e) {
				resultLabel.setText("First operand is not an Integer");
			} catch (NoSuchElementException e) {
				resultLabel.setText("Missing first operand");
			}
		}
	}

	private void calculate(int firstInt, String s, int secondInt) {
		switch (s) {
		case "+":
			resultLabel.setText("Result: " + Integer.toString(firstInt + secondInt));
			break;
		case "-":
			resultLabel.setText("Result: " + Integer.toString(firstInt - secondInt));
			break;
		case "*":
			resultLabel.setText("Result: " + Integer.toString(firstInt * secondInt));
			break;
		case "/":
			try {
				int result = firstInt / secondInt;
				resultLabel.setText("Result: " + result);
			} catch (ArithmeticException e) {
				resultLabel.setText("/ by zero");
			}
			break;
		case "%":
			resultLabel.setText("Result: " + Integer.toString(firstInt % secondInt));
			break;
		case "^":
			resultLabel.setText("Result: " + (int) Math.pow(firstInt, secondInt));
			break;
		default:
			break;
		}
	}

	private void createButton() {
		calculate = new JButton("Calculate");
		ActionListener listener = new CalculateExpression();
		calculate.addActionListener(listener);
	}

	private void createPanel() {
		JPanel panel = new JPanel();
		panel.add(dataEntry);
		panel.add(calculate);
		panel.add(resultLabel);
		add(panel);
	}
}
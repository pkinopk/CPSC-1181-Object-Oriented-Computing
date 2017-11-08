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
	private static final double DEFAULT_RATE = 5;
	private static final double INITIAL_BALANCE = 1000;

	private JTextField rateField;
	private JButton calculate;
	private JLabel resultLabel;
	private double balance;

	private int firstInt;

	public CalculatorFrame() {
		balance = INITIAL_BALANCE;
		resultLabel = new JLabel("Result");
		createTextField();
		createButton();
		createPanel();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	private void createTextField() {

		final int FIELD_WIDTH = 10;
		rateField = new JTextField(FIELD_WIDTH);
	}

	class CalculateExpression implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			String s = rateField.getText();
			System.out.println(s);
			Scanner in = new Scanner(s);
			int firstInt = 0;
			String operator = "!";
			int secondInt = 0;
			String rest;

			try {
				firstInt = in.nextInt();
				try {
					operator = in.next();

					try {
						secondInt = in.nextInt();
						try {
							rest = in.next();
							throw new InputMismatchException("More than just 2 operands and an operator");
						} catch (Exception e) { // TODO NOT WORKING
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
			calculate(firstInt, operator, secondInt);

			// TODO REST
			// try {
			// rest = in.next();
			// } catch (NoSuchElementException e) {
			// System.out.println("FIX operand is not an Integer: " + e);
			// }

			// double interest = balance * rate / 100;
			// balance = balance + interest;
			// resultLabel.setText("Balance: " + balance);
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
		case "!":
			resultLabel.setText("Missing operator");
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
		panel.add(rateField);
		panel.add(calculate);
		panel.add(resultLabel);
		add(panel);
	}
}

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
			Scanner in = new Scanner(s);
			int firstInt = 0;
			String operator = "";
			int secondInt = 0;
			String rest;

			try {
				firstInt = in.nextInt();
			} catch (InputMismatchException e) {
				resultLabel.setText("First operand is not an Integer");
			} catch (NoSuchElementException e) {
				resultLabel.setText("Missing first operand");
			}

			try {
				operator = in.next();
			} catch (NoSuchElementException e) {
				resultLabel.setText("Missing operator");
			}

			try {
				secondInt = in.nextInt();
			} catch (InputMismatchException e) {
				resultLabel.setText("Second operand is not an Integer");
			} catch (NoSuchElementException e) {
				resultLabel.setText("Missing second operand");
			}

			switch (operator) {
			case "+":
				resultLabel.setText("Result: " + Integer.toString(firstInt + secondInt));
				break;
			case "-":
				resultLabel.setText("Result: " + Integer.toString(firstInt - secondInt));
				break;
			case "*":
				resultLabel.setText("Result: " + Integer.toString(firstInt * secondInt));
				break;
			case "/": // TODO division by 0???
				int result = firstInt / secondInt;
				resultLabel.setText("Result: " + result);
				break;
			case "%":
				resultLabel.setText("Result: " + Integer.toString(firstInt % secondInt));
				break;
			case "^":
				resultLabel.setText("Result: " + (int) Math.pow(firstInt, secondInt));
				break;
			default:
				resultLabel.setText("Illegal operator " + '"' + operator + '"');
				break;
			}

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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ControllerFrame extends JFrame {
	private JTextField input;
	private PasswordFrame game;

	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 150;

	public ControllerFrame() {
		game = new PasswordFrame();
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setTitle("Guess the password");
		game.setLocationRelativeTo(null);
		game.setVisible(true);

		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(2, 3));

		input = new JTextField("");
		input.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		add(input, BorderLayout.NORTH);

		JButton setPlayer = new JButton("SET PLAYER");
		setPlayer.addActionListener(new buttonSetPlayerListener());
		buttons.add(setPlayer);

		JButton setTurnPlayer = new JButton("SET TURN PLAYER");
		setTurnPlayer.addActionListener(new buttonSetTurnListener());
		buttons.add(setTurnPlayer);

		JButton zeroCorrect = new JButton("ZERO CORRECT");
		JButton oneCorrect = new JButton("ONE CORRECT");
		JButton twoCorrect = new JButton("TWO CORRECT");
		JButton threeCorrect = new JButton("THREE CORRECT");

		buttons.add(zeroCorrect);
		buttons.add(oneCorrect);
		buttons.add(twoCorrect);
		buttons.add(threeCorrect);
		add(buttons, BorderLayout.CENTER);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);

	}

	class buttonSetPlayerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			int player = Integer.parseInt(input.getText());
			game.setiAmPlayer(player);
			game.setMsg("You are player: " + player, Color.BLACK);
		}
	}

	class buttonSetTurnListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			int player = Integer.parseInt(input.getText());
			game.setTurn(player);
			if (game.getiAmPlayer() == player) {
				game.setMsg("Your turn to play", Color.BLUE);
			} else
				game.setMsg("Your opponent's turn to play", Color.BLUE);
		}
	}

}

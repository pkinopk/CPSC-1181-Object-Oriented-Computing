import javax.swing.JFrame;

public class RainDropsViewer {

	public static final int FRAME_WIDTH = 800;
	public static final int FRAME_HEIGHT = 600;

	public static void main(String[] args) {
		JFrame frame = new JFrame();

		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("RainDrops");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		RainDropsComponent c = new RainDropsComponent();
		frame.add(c);

		frame.setVisible(true);
	}
}

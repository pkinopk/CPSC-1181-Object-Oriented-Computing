import javax.swing.JFrame;

public class FlowerViewer {

	public static final int FRAME_WIDTH = 800;
	public static final int FRAME_HEIGHT = 600;
	public static JFrame frame = new JFrame();

	public static void main(String[] args) {

		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("Flowers");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		FlowerComponent f = new FlowerComponent();
		frame.add(f);

		frame.setVisible(true);
	}

}

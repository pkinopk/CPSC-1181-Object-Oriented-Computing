
import javax.swing.JFrame;

public class FrameViewer {

	public static final int FRAME_WIDTH = 1024;
	public static final int FRAME_HEIGHT = 800;

	public static void main(String[] args) {
		JFrame frame = new JFrame();

		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("Head");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		HeadComponent h = new HeadComponent();
		frame.add(h);

		frame.setVisible(true);
	}

}

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Resources {

	/**
	 * Creates a socket with the GAME_PORT and opens its input and output
	 * streams called fromServer and toServer.
	 */
	private void openConnection(String serverHost) {
		try {
			this.socket = new Socket(serverHost, PORT);
			this.fromServer = new DataInputStream(socket.getInputStream());
			this.toServer = new DataOutputStream(socket.getOutputStream());
		} catch (SecurityException e) {
			System.err.print("a security manager exists: ");
			System.err.println("its checkConnect doesn't allow the connection");
			System.err.println("without a SERVER, I'm toast ... no point going on so bye, bye");
		} catch (UnknownHostException e) {
			System.err.println("the IP address of the host could not be found...cannot go on, bye");
		} catch (IOException e) {
			System.err.println("cannot seem to be able to connect to the server \"" + serverHost + "\"");
			System.err.println("without a SERVER, I'm toast ... no point going on so bye, bye");
		}

	} // openConnection

	/**
	 * Helper function to report messages to the resultsArea -- resultsArea is
	 * instance variable.
	 */
	private void report(String s) {
		resultsArea.append(s + "\n");
	}

	/**
	 * Report that that's it, that no input is allowed onto the rField and
	 * remove the actionListener to prevent any more computations. Another
	 * possibility would have been to do rField.setEnabled(false) which turns
	 * the message to gray but I wanted to illustrate removing an action
	 * listener.
	 */
	private void freeze() {
		rField.setText("NO MORE COMPUTATIONS POSSIBLE");
		// rField.setEnabled(false);
		rField.setEditable(false);
		rField.removeActionListener(calcAreaListener);
		if (DEBUGGING)
			threadMessage("finished the 'freeze method's code");
	} // freeze

}

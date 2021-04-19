package platformer;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class GameClient {
	
	protected Socket socket;
	
	// Figure out what format the data should be in
	
	public GameClient(String IP, int port) {
		try {
			socket = new Socket(IP, port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

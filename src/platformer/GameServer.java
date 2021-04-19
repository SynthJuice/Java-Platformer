package platformer;

import java.io.IOException;
import java.net.ServerSocket;

public class GameServer {

	private ServerSocket serverSocket;
	
	private Map map;
	
	public GameServer(int port, Map map) {
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.map = map;
	}
	
	public void update() {
		
	}
	
}

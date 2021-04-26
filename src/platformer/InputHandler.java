package platformer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {

	public static boolean[] WASD = new boolean[4];
	
	public static boolean ESC = false;
	
	@Override
	public void keyTyped(KeyEvent e) { }

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			WASD[0] = true;
			break;
		case KeyEvent.VK_A:
			WASD[1] = true;
			break;
		case KeyEvent.VK_S:
			WASD[2] = true;
			break;
		case KeyEvent.VK_D:
			WASD[3] = true;
			break;
		case KeyEvent.VK_ESCAPE:
			ESC = true;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			WASD[0] = false;
			break;
		case KeyEvent.VK_A:
			WASD[1] = false;
			break;
		case KeyEvent.VK_S:
			WASD[2] = false;
			break;
		case KeyEvent.VK_D:
			WASD[3] = false;
			break;
		case KeyEvent.VK_ESCAPE:
			ESC = false;
			break;
		}
	}

}

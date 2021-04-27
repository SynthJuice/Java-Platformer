package platformer;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Texture {
	
	protected BufferedImage image;
	
	public Texture(BufferedImage image) {
		this.image = image;
	}
	
	public void update(Graphics g, int x, int y, int scale) {
		g.drawImage(image, x, y, Platformer.UNIT_SIZE * scale, Platformer.UNIT_SIZE * scale, null);
	}
	
	public int getWidth() {
		return image.getWidth();
	}
	
	public int getHeight() {
		return image.getHeight();
	}

}

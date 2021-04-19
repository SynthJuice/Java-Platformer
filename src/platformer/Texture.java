package platformer;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Texture {
	
	protected BufferedImage image;
	
	public Texture(BufferedImage image) {
		this.image = image;
	}
	
	public void update(Graphics g, int x, int y, int unitSize, int scale) {
		g.drawImage(image, x * unitSize * scale, y * unitSize * scale, unitSize * scale, unitSize * scale, null);
	}

}

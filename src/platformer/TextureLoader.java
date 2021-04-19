package platformer;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TextureLoader {
	
	public static Texture loadTexture(String path) {
		File file = new File(path);
		if (file.exists()) {
			try {
				return new Texture(ImageIO.read(new File(path)));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static Texture loadSubTexture(String path, int x, int y, int unitSize) {
		File file = new File(path);
		if (file.exists()) {
			try {
				return new Texture(ImageIO.read(new File(path)).getSubimage(x, y, unitSize, unitSize));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static Texture loadAnimation(String path, int subWidth, int delay) {
		File file = new File(path);
		if (file.exists()) {
			try {
				return new Animation(ImageIO.read(new File(path)), subWidth, delay);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}

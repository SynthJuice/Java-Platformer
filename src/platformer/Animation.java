package platformer;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Animation extends Texture {
	
	protected int imageCount, delay;
	protected BufferedImage[] images;
	protected int timer = 0, index = 0;
	
	public Animation(BufferedImage image, int subWidth, int delay) {
		super(image);
		this.imageCount = image.getWidth() / subWidth;
		this.delay = delay;
		this.images = new BufferedImage[imageCount];
		for (int i = 0; i < imageCount; i++) {
			images[i] = image.getSubimage(i * subWidth, 0, subWidth, image.getHeight());
		}
		Platformer.animationList.add(this);
	}
	
	public void tick() {
		timer++;
		if (timer == delay) {
			timer = 0;
			index++;
			if (index == imageCount) {
				index = 0;
			}
		}
	}
	
	public void update(Graphics g, int x, int y, int unitSize, int scale) {
		g.drawImage(images[index], x * unitSize * scale, y * unitSize * scale, unitSize * scale, unitSize * scale, null);
	}

}

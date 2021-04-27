package platformer;

import java.awt.Graphics;

public class ObjectiveEntity extends Entity {

	public ObjectiveEntity(float x, float y, Texture texture, Map map) {
		super(x, y, texture.getWidth(), texture.getHeight(), texture, map);
		velX = 0.5f;
	}

	@Override
	public void update(Graphics g, int scale) {
		texture.update(g, (int) x, (int) y, scale);
	}

}

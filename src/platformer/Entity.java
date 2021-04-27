package platformer;

import java.awt.Graphics;

public abstract class Entity {
	
	protected float x, y, velX, velY;
	protected int width, height;
	public Texture texture;
	protected Map map;
	
	public Entity(float x, float y, int width, int height, Texture texture, Map map) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.texture = texture;
		this.map = map;
	}
	
	public void tick(Graphics g, int scale) {
		x += velX;
		y += velY;
		
		update(g, scale);
	}
	
	public abstract void update(Graphics g, int scale);

}

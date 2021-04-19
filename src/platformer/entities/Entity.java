package platformer.entities;

import java.awt.Graphics;

public class Entity {

	protected float x, y, velX, velY;
	protected int width, height;
	
	public Entity(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void update(Graphics g, int scale) {
		
	}
	
}

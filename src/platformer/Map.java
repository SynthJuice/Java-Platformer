package platformer;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Map {
	
	private int width, height, scale;
	private char[][] mapArray, backgroundArray;
	
	private ArrayList<Entity> entityList;
	
	public Map(int width, int height, int scale) {
		this.width = width;
		this.height = height;
		this.scale = scale;
		this.mapArray = new char[width][height];
		this.backgroundArray = new char[width][height];
		this.entityList = new ArrayList<Entity>();
	}
	
	public Map(char[][] mapArray, char[][] backgroundArray, int scale) {
		this.width = mapArray.length;
		this.height = mapArray[0].length;
		this.scale = scale;
		this.mapArray = mapArray;
		this.backgroundArray = backgroundArray;
		this.entityList = new ArrayList<Entity>();
		
		entityList.add(new ObjectiveEntity(200, 200, TextureLoader.loadSubTexture("res/textures/spritesheet.png", 16, 96, Platformer.UNIT_SIZE), this));
		
		System.out.println("MAP : " + width + " x " + height);
		System.out.println();
		print();
	}
	
	public Map(char[][] mapArray, char[][] backgroundArray, ArrayList<Entity> entityList, int scale) {
		this.width = mapArray.length;
		this.height = mapArray[0].length;
		this.scale = scale;
		this.mapArray = mapArray;
		this.backgroundArray = backgroundArray;
		this.entityList = entityList;
		
		System.out.println("MAP : " + width + " x " + height);
		System.out.println();
		print();
	}
	
	public void update(Graphics g, int scale) {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				TileType tile = TileType.getTileType(backgroundArray[x][y]);
				if (tile != null) {
					tile.texture.update(g, x * Platformer.UNIT_SIZE * Platformer.SCALE, y * Platformer.UNIT_SIZE * scale, scale);
				}
			}
		}
		
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				TileType tile = TileType.getTileType(mapArray[x][y]);
				if (tile != null) {
					tile.texture.update(g, x * Platformer.UNIT_SIZE * Platformer.SCALE, y * Platformer.UNIT_SIZE * scale, scale);
				}
			}
		}
		
		for (Entity entity : entityList) {
			entity.tick(g, scale);
		}
	}
	
	public void print() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				System.out.print(mapArray[x][y]);
			}
			System.out.println();
		}
	}
	
	public void printBackground() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				System.out.print(backgroundArray[x][y]);
			}
			System.out.println();
		}
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public char getCharAtEntityPos(float x, float y) {
		float fX = x / (Platformer.UNIT_SIZE * scale);
		float fY = y / (Platformer.UNIT_SIZE * scale);
		int tileX = (int) fX;
		int tileY = (int) fY;
		if (fX > width || fX < 0 || fY > height || fY < 0) {
			return '0';
		}
		System.out.println(fX + " x " + fY + " : ");
		System.out.print(tileX + " x " + tileY + " : ");
		return mapArray[tileX][tileY];
	}
	
	public Rectangle getTileBoundsAtEntityPos(float x, float y) {
		float fX = x / (Platformer.UNIT_SIZE * scale);
		float fY = y / (Platformer.UNIT_SIZE * scale);
		if (fX > width || fX < 0 || fY > height || fY < 0) {
			return null;
		}
		return new Rectangle((int) fX, (int) fY, Platformer.UNIT_SIZE * scale, Platformer.UNIT_SIZE * scale);
	}

}

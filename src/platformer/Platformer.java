package platformer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Platformer extends Canvas implements Runnable {
	
	private static final long serialVersionUID = -380315508131536919L;
	
	public static int SCALE = 4, UNIT_SIZE = 16;
	public static float TICK_RATE = 64, GRAVITY = 9.82f;
	public static String NAME = "Platformer", VERSION = "0.1", TITLE = NAME + " V" + VERSION;

	private Map map;
	private Dimension panelSize;
	
	private JFrame frame;
	
	private boolean running = false;
	private Thread thread;
	
	public static ArrayList<Animation> animationList; // This could probably be done better, by not loading the texture in tile TileType class
	
	
	public Platformer() {
		try {
			map = new Map(MapLoader.loadMap("res/maps/map0.platmap"), SCALE);
		} catch (IOException e) {
			e.printStackTrace();
		}
		panelSize = new Dimension(map.getWidth() * UNIT_SIZE * SCALE, map.getHeight() * UNIT_SIZE * SCALE);
		
		animationList = new ArrayList<Animation>();
		
		setBackground(Color.black);
		setPreferredSize(panelSize);
		
		this.addKeyListener(new InputHandler());
		
		frame = new JFrame(TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	private int fps = 0;
	
	@Override
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double ns = 1000000000 / TICK_RATE;
		double delta = 0;
		long timer = System.currentTimeMillis();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				fps++;
				update();
				delta--;
			}

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frame.setTitle(TITLE + "      FPS : " + fps);
				fps = 0;
			}
		}
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void update() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, panelSize.width, panelSize.height);
		
		for (Animation animation : animationList) {
			animation.tick();
		}
		
		map.update(g, UNIT_SIZE, SCALE);
		
		// The server should be updated after all the other things have been updated.
		// In the future, to minimize delay, the update function should be split into render and tick, so the server doesn't have to wait for the screen to be drawn
		
		g.dispose();
		bs.show();
	}
	
}

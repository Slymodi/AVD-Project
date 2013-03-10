package game;

import entity.mob.type.player.Player;
import game.level.Level;
import game.level.RandomLevel;
import graphics.Screen;
import input.Keyboard;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int width = 300;
	public static int height = width / 16 * 9;

	
	public static int scale = 3;
	public static String title = "NEEDS A NAME ";

	private Thread thread;
	private JFrame frame;
	private Keyboard key;
	private boolean running = false;
	private Level level;
	private Screen screen;
	public Player player;

	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	private final int MAPSIZE = 128;
	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		screen = new Screen(width, height);
		frame = new JFrame();
		key = new Keyboard();
		level = new RandomLevel(MAPSIZE,MAPSIZE);
		player = new Player(key);
		addKeyListener(key);
	}

	public synchronized void Start() {
		running = true;
		thread = new Thread(this, "Game");
		thread.start();
		// System.out.println("continue working");
	}

	public synchronized void Stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void run() {

		long lastTime = System.nanoTime();
		long Timer = System.currentTimeMillis();

		final double ns = 1000000000.0 / 60.0;
		double delta = 0.0;
		int frames = 0;
		int updates = 0;
		requestFocus();
		
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}

			render();
			frames++;

			if (System.currentTimeMillis() - Timer > 1000) {
				Timer += 1000;
				System.out.println(updates + " ups " + frames + " fps");
				frame.setTitle(title + "   |   " + updates + " ups " + frames + " fps");
				updates = 0;
				frames = 0;

			}
			// System.out.println("running " + "lol");
		}
		Stop();
	}

	public void update() {
		//key.update(player);
		player.update();
	}

	public void render() {
		// System.out.println("rendering!");
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		screen.clear();
		int XScroll = player.x - screen.width / 2, YScroll = player.y - screen.height /2;
		level.render(YScroll, XScroll, screen);
		player.render(screen);
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}

		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.white);
		g.setFont(new Font("Verdana",0,50));
		// g.setColor(Color.BLACK);
		 //g.fillRect(0, 0, getWidth(), getHeight());


		g.dispose();
		bs.show();

	}

	public static void main(String[] args) {
		// System.out.println("lol it works");
		// new Launcher(0);
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle(title);
		//game.frame.setUndecorated(true);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);

		game.Start();
	}
}
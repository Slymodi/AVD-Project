package graphics;

import java.util.Random;

@SuppressWarnings("unused")
public class Sprite {

	//static Random random = new Random();
	//int spriteasd =random.nextInt(6);
	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	public static Sprite grass = new Sprite(16,0, 0, SpriteSheet.tiles);
	public static Sprite rock = new Sprite(16,1,0,SpriteSheet.tiles);
	public static Sprite mineral = new Sprite(16,2,0,SpriteSheet.tiles);
	public static Sprite wood = new Sprite(16,3,0,SpriteSheet.tiles);
	public static Sprite dirt = new Sprite(16,4,0,SpriteSheet.tiles);
	public static Sprite water = new Sprite(16,5,0,SpriteSheet.tiles);
	public static Sprite dwater = new Sprite(16,6,0,SpriteSheet.tiles);
	public static Sprite VoidSprite = new Sprite(16,0);
	
	public static Sprite playerfs =new Sprite(16,0,13,SpriteSheet.tiles);
	public static Sprite playerfl =new Sprite(16,0,14,SpriteSheet.tiles);
	public static Sprite playerfr =new Sprite(16,0,15,SpriteSheet.tiles);
	public static Sprite playerls =new Sprite(16,3,13,SpriteSheet.tiles);
	public static Sprite playerlm =new Sprite(16,3,14,SpriteSheet.tiles);
	public static Sprite playerlm2 =new Sprite(16,3,15,SpriteSheet.tiles);

	public static Sprite playerrs =new Sprite(16,2,13,SpriteSheet.tiles);
	public static Sprite playerrm =new Sprite(16,2,14,SpriteSheet.tiles);
	public static Sprite playerrm2 =new Sprite(16,2,15,SpriteSheet.tiles);

	public static Sprite playerbs =new Sprite(16,1,13,SpriteSheet.tiles);
	public static Sprite playerbl =new Sprite(16,1,14,SpriteSheet.tiles);
	public static Sprite playerbr =new Sprite(16,1,15,SpriteSheet.tiles);
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * SIZE;
		this.y = y * SIZE;
		this.sheet = sheet;
		load();
	}

	public Sprite(int size, int color) {
		SIZE = size;
		pixels = new int[SIZE*SIZE];
		setColor(color);
	}
	private void setColor(int color) {
		for (int i = 0;i<SIZE*SIZE;i++) {
			pixels[i] = color;
		}
		
	}

	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * 256];
			}
		}
	}
}

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
	public static Sprite concrete = new Sprite(16,7,0,SpriteSheet.tiles);
	public static Sprite omanhole = new Sprite(16,8,0,SpriteSheet.tiles);
	public static Sprite cmanhole = new Sprite(16,9,0,SpriteSheet.tiles);
	public static Sprite road = new Sprite(16,10,0,SpriteSheet.tiles);
	public static Sprite midroad = new Sprite(16,11,0,SpriteSheet.tiles);
	public static Sprite cwalk = new Sprite(16,12,0,SpriteSheet.tiles);
	public static Sprite cwalktop = new Sprite(16,13,0,SpriteSheet.tiles);
	public static Sprite cwalkleft = new Sprite(16,14,0,SpriteSheet.tiles);
	public static Sprite cwalkdown = new Sprite(16,15,0,SpriteSheet.tiles);
	
	public static Sprite cwalkright = new Sprite(16,0,1,SpriteSheet.tiles);
	public static Sprite hormidroad = new Sprite(16,1,1,SpriteSheet.tiles);
	public static Sprite downleftroad = new Sprite(16,3,1,SpriteSheet.tiles);
	public static Sprite downrightroad = new Sprite(16,2,1,SpriteSheet.tiles);
	public static Sprite uprightroad = new Sprite(16,4,1,SpriteSheet.tiles);
	public static Sprite upleftroad = new Sprite(16,5,1,SpriteSheet.tiles);

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

package graphics;

import entity.mob.type.Player;
import game.level.tile.Tiles;

import java.util.Random;

public class Screen {
	public int width, height;
	public int[] pixels;

	/*private double tilesize = 16;
	double tilesizesqrt = Math.sqrt(tilesize);*/
	public int Xoffset,Yoffset;
	int MAP_SIZE = 128;
	int MAP_OFFSET = MAP_SIZE - 1;
	public int[] tile = new int[MAP_SIZE * MAP_SIZE];

	private Random random = new Random();

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
			tile[i] = random.nextInt(0xffffff);

		}
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void render(int xoff,int yoff) {
		for (int y = 0; y < height; y++) {
			int yy= y + yoff;
			if (yy < 0 || yy >= height) continue;
				
			for (int x = 0; x < width; x++) {
				int xx =x +  xoff;
				if (xx < 0 || xx >= width) continue;		
				pixels[xx + yy * width] = Sprite.grass.pixels[((x & 15) + (y & 15) * Sprite.grass.SIZE)];

				/*int tilenum = random.nextInt(7);
				if (tilenum == 0) pixels[xx + yy * width] = Sprite.grass.pixels[((x & 15) + (y & 15) * Sprite.grass.SIZE)];
				if (tilenum == 1) pixels[xx + yy * width] = Sprite.rock.pixels[((x&15) + (y & 15) * Sprite.rock.SIZE)];
				if (tilenum == 2) pixels[xx + yy * width] = Sprite.mineral.pixels[((x&15) + (y & 15) * Sprite.mineral.SIZE)];
				if (tilenum == 3) pixels[xx + yy * width] = Sprite.wood.pixels[((x&15) + (y & 15) * Sprite.wood.SIZE)];
				if (tilenum == 4) pixels[xx + yy * width] = Sprite.dirt.pixels[((x&15) + (y & 15) * Sprite.dirt.SIZE)];
				if (tilenum == 5) pixels[xx + yy * width] = Sprite.water.pixels[((x&15) + (y & 15) * Sprite.water.SIZE)];
				if (tilenum == 6) pixels[xx + yy * width] = Sprite.dwater.pixels[((x&15) + (y & 15) * Sprite.dwater.SIZE)];
			*/}
		}
	}

	public void renderTile(int xp,int yp,Tiles tile) {
		xp -= Xoffset;
		yp -= Yoffset;
		for(int y = 0; y < tile.sprite.SIZE;y++) {
			int ya = yp + y;
			
			for (int x =0; x < tile.sprite.SIZE;x++) {
				int xa = x+ xp;
				
				if (xa <-tile.sprite.SIZE || xa>=width || ya < 0 || ya >= height) {
					break;
				}
				if (xa < 0) xa=0;
				pixels[xa+ya*width] = tile.sprite.pixels[x+y*tile.sprite.SIZE];
			}
		}
	}
	public void renderPlayer(int xp,int yp,Sprite sprite) {
		xp -= Xoffset;
		yp -= Yoffset;
		for(int y = 0; y < 16;y++) {
			int ya = yp + y;
			
			for (int x =0; x < 	16;x++) {
				int xa = x+ xp;
				
				if (xa <-16 || xa>=width || ya < 0 || ya >= height) {
					break;
				}
				if (xa < 0) xa=0;
				int col = sprite.pixels[x+y*16];
				if (col != 0xffff00ff) {
				pixels[xa+ya*width] = col;
				}
			}
		}
	}
	public void Setoffset(int Xoffset,int Yoffset) {
		this.Xoffset =  Xoffset;
		this.Yoffset = Yoffset;
	}
}
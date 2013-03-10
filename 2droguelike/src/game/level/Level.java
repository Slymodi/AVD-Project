package game.level;

import game.level.tile.Tiles;
import graphics.Screen;

public class Level {
	protected int width,height;
	protected int[] tiles;

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
	}
	private void loadLevel(String path) {
		
	}

	protected void generateLevel() {
	 
	}
	private void time() {
		
	}
	public void update() {
		
	}
	public void render(int yscroll, int xscroll, Screen screen) {
		screen.Setoffset(xscroll, yscroll);
		int x0 = xscroll >> 4;
		int x1 = (xscroll + screen.width+ 16) >> 4;
		int y0 = yscroll >> 4;
		int y1 = (yscroll + screen.height + 16) >> 4;
		
		for(int y = y0; y < y1;y++) {
			for(int x = x0; x < x1;x++) {
				getTile(x,y).render(x, y, screen);
				
			}
		}
	}
	
	
	public Tiles getTile(int x,  int y) {
		if (x <0||y < 0 || x>= width || y>=height ) return Tiles.voidtile;
		if (tiles[x+y*width] == 0) return Tiles.grass;
		if (tiles[x+y*width] == 1) return Tiles.dirt;
		if (tiles[x+y*width] == 2) return Tiles.water;
		if (tiles[x+y*width] == 3) return Tiles.dwater;
		if (tiles[x+y*width] == 4) return Tiles.rock;
		if (tiles[x+y*width] == 5) return Tiles.mineral;
		if (tiles[x+y*width] == 6) return Tiles.wood;
		return Tiles.voidtile;
	}
}

package game.level.tile;

import game.level.tile.type.DWater;
import game.level.tile.type.Dirt;
import game.level.tile.type.Grass;
import game.level.tile.type.Mineral;
import game.level.tile.type.Rock;
import game.level.tile.type.VoidTile;
import game.level.tile.type.Water;
import game.level.tile.type.Wood;
import graphics.Screen;
import graphics.Sprite;

public class Tiles {
	public int x, y;
	public Sprite sprite;

	public static Tiles grass = new Grass(Sprite.grass);
	public static Tiles dirt = new Dirt(Sprite.dirt);
	public static Tiles rock = new Rock(Sprite.rock);
	public static Tiles mineral = new Mineral(Sprite.mineral);
	public static Tiles wood = new Wood(Sprite.wood);
	public static Tiles water = new Water(Sprite.water);
	public static Tiles dwater = new DWater(Sprite.dwater);
	public static Tiles voidtile = new VoidTile(Sprite.VoidSprite);
	
	public Tiles(Sprite sprite) {
		this.sprite = sprite;
	}

	public void render(int x, int y,Screen screen) {

	}
	public boolean solid() {
		return false;
	}




}



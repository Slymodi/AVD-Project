package game.level.tile;

import game.level.tile.type.CollideTile;
import game.level.tile.type.NoncollideTile;
import game.level.tile.type.VoidTile;
import game.level.tile.type.WaterTile;
import graphics.Screen;
import graphics.Sprite;

public class Tiles {
	public int x, y;
	public Sprite sprite;

	public static Tiles grass = new NoncollideTile(Sprite.grass);
	public static Tiles dirt = new NoncollideTile(Sprite.dirt);
	public static Tiles rock = new NoncollideTile(Sprite.rock);
	public static Tiles mineral = new NoncollideTile(Sprite.mineral);
	public static Tiles wood = new NoncollideTile(Sprite.wood);
	public static Tiles water = new WaterTile(Sprite.water);
	public static Tiles dwater = new NoncollideTile(Sprite.dwater);
	public static Tiles voidtile = new VoidTile(Sprite.VoidSprite);
	public static Tiles concrete= new NoncollideTile(Sprite.concrete);
	public static Tiles openManhole= new CollideTile(Sprite.concrete);

	public Tiles(Sprite sprite) {
		this.sprite = sprite;
	}

	public void render(int x, int y,Screen screen) {

	}
	public boolean solid() {
		return false;
	}
	public boolean sink() {
		return false;
	}



}



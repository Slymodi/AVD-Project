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
	public static Tiles openManhole= new CollideTile(Sprite.omanhole);
	public static Tiles closedManhole= new CollideTile(Sprite.cmanhole);
	public static Tiles Road= new CollideTile(Sprite.road);
	public static Tiles Midroad= new CollideTile(Sprite.midroad);
	public static Tiles Cwalk= new CollideTile(Sprite.cwalk);
	public static Tiles Cwalktop= new CollideTile(Sprite.cwalktop);
	public static Tiles Cwalkleft= new CollideTile(Sprite.cwalkleft);
	public static Tiles Cwalkdown= new CollideTile(Sprite.cwalkdown);
	public static Tiles Cwalkright= new CollideTile(Sprite.cwalkright);
	public static Tiles midhorroad= new CollideTile(Sprite.hormidroad);
	public static Tiles downrightroad= new CollideTile(Sprite.downrightroad);
	public static Tiles downleftroad= new CollideTile(Sprite.downleftroad);
	public static Tiles uprightroad= new CollideTile(Sprite.uprightroad);
	public static Tiles upleftroad= new CollideTile(Sprite.upleftroad);


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



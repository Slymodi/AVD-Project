package game.level.tile.type;

import game.level.tile.Tiles;
import graphics.Screen;
import graphics.Sprite;

public class VoidTile extends Tiles {

	public VoidTile(Sprite sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}
	public void render(int x, int y,Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
}

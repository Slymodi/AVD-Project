package game.level.tile.type;

import game.level.tile.Tiles;
import graphics.Screen;
import graphics.Sprite;

public class Wood extends Tiles{
	
	
	public Wood(Sprite sprite) {
		super(sprite);
	}
	public void render(int x, int y,Screen screen) {
		screen.renderTile(x << 4, y << 4, this);

	}	
}

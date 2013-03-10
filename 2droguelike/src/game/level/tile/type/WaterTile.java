package game.level.tile.type;

import game.level.tile.Tiles;
import graphics.Screen;
import graphics.Sprite;

public class WaterTile extends Tiles{
	public WaterTile(Sprite sprite) {
		super(sprite);
	}
	public void render(int x, int y,Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
	public boolean sinks() {
		return true;
	}
}

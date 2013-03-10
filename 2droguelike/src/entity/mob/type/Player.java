package entity.mob.type;

import graphics.Screen;
import graphics.Sprite;
import input.Keyboard;
import entity.mob.Mob;

public class Player extends Mob {
	private Keyboard input;
	public int anim = 0;
	private boolean walking = false;
	
	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
	}

	public Player(Keyboard input) {
		this.input = input;

	}

	public void update() {
		if (anim < 7500) anim++;
		else anim =0;
		//System.out.println("UPDATEING" + y + " " + x);
		input.update(this);
		int xa = 0; int ya = 0;
		if (input.up) ya = -1;
		if (input.down)  ya = 1;
		if (input.left)  xa = -1;
		if (input.right) xa =1;
		if (xa != 0 || ya !=0) {
			move(xa,ya);
			walking = true;
			
		} else {
			walking = false;
		}
			
	}

	public void render(Screen screen) {
		if (dir == 3) {
		if (walking) {
			if (anim % 20 >10) {
				screen.renderPlayer(x, y,Sprite.playerbl);
			} else {
				screen.renderPlayer(x, y,Sprite.playerbr);

			}
		}else{
			screen.renderPlayer(x, y,Sprite.playerbs);
		}
		}
		if (dir == 0) {
			if (walking) {
				if (anim % 20 >10) {
					screen.renderPlayer(x, y,Sprite.playerfl);
				} else {
					screen.renderPlayer(x, y,Sprite.playerfr);

				}
			}else{
		screen.renderPlayer(x, y,Sprite.playerfs);
		}
		}
		if (dir ==1) {
			if (walking) {
				if (anim % 20 >13) {
					screen.renderPlayer(x, y,Sprite.playerrm);
				} else if(anim%20>6) {
					screen.renderPlayer(x, y,Sprite.playerrs);
				}else{
					screen.renderPlayer(x, y,Sprite.playerrm2);
				}
				
			}else{
			screen.renderPlayer(x, y,Sprite.playerrs);
		}
	}
		if (dir ==2) {
			if (walking) {
				if (anim % 20 >13) {
					screen.renderPlayer(x, y,Sprite.playerlm);
				} else if(anim%20>6) {
					screen.renderPlayer(x, y,Sprite.playerls);
				}else{
					screen.renderPlayer(x, y,Sprite.playerlm2);
				}
			}else{
			screen.renderPlayer(x, y,Sprite.playerls);
		}}
		}
}

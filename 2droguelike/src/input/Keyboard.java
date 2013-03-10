package input;

import entity.mob.type.Player;
import game.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Keyboard implements KeyListener{

	private boolean[] keys = new boolean[65536];
	public boolean up,down, left,right;
	
	public void update(Player player) {
		up = keys[KeyEvent.VK_W] ||  keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_I];
		down = keys[KeyEvent.VK_S] ||  keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_K];
		left = keys[KeyEvent.VK_A] ||  keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_J];
		right = keys[KeyEvent.VK_D] ||  keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_L];
		
	}
	
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		
	}

	
	public void keyTyped(KeyEvent e) {
		
		
	}

}

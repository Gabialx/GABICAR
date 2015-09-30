package gabicar.application;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import gabicar.model.Car;
import gabicar.model.Game;

public class KeyboardListener implements KeyListener {
	
	/**
	 * http://docs.oracle.com/javase/7/docs/api/java/awt/event/KeyEvent.html
	 */
	@Override
	public void keyPressed(KeyEvent arg0) {
		Car player = Painter.getPainter().getGame().getPlayer();
		if (player != null) {
			switch (arg0.getKeyCode()) {
			case KeyEvent.VK_UP:
				player.up();
				break;
			case KeyEvent.VK_DOWN:
				player.down();
				break;
			case KeyEvent.VK_LEFT:
				player.left();
				break;
			case KeyEvent.VK_RIGHT:
				player.right();
				break;
			}
		}

		System.out.println(arg0.getKeyChar());
	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}
}

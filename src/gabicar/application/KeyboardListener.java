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
		Game game = Painter.getPainter().getGame();
		Car player = game.getPlayer();
		switch (arg0.getKeyCode()) {
		case KeyEvent.VK_UP:
			if (player != null) {
				player.up();
			}
			break;
		case KeyEvent.VK_DOWN:
			if (player != null) {
				player.down();
			}
			break;
		case KeyEvent.VK_LEFT:
			if (player != null) {
				player.left();
			}
			break;
		case KeyEvent.VK_RIGHT:
			if (player != null) {
				player.right();
			}
			break;
		case KeyEvent.VK_N:
			game.reinitialize();
			break;
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

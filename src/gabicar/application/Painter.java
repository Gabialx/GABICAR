package gabicar.application;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import gabicar.model.Car;
import gabicar.model.Game;
import gabicar.model.Info;
import gabicar.model.Road;

public class Painter extends Thread {

	private JFrame frame;

	private BufferedImage buffer;

	private Graphics2D canvas;

	private Game game;
	
	private static Painter painter;

	public Painter(JFrame frame) {
		painter = this;
		
		this.frame = frame;
		this.buffer = new BufferedImage(500, 700, BufferedImage.TYPE_4BYTE_ABGR);
		this.canvas = buffer.createGraphics();
		this.game = new Game();
		this.game.getObjects().add(new Road());
		this.game.getObjects().add(new Info());

		Car player = new Car("D:\\Workspace\\GABICAR\\src\\gabicar\\resources\\32px_SimpleBrightGreenCarTopView.png");
		player.setPlayer(true);
		this.game.getObjects().add(player);

	}

	public static Painter getPainter() {
		return painter;
	}

	/**
	 * http://stackoverflow.com/questions/9367502/double-buffer-a-jframe
	 */
	@Override
	public void run() {
		try {
			while (true) {

				game.draw(canvas);

				Graphics2D g = (Graphics2D) frame.getGraphics();
				g.drawImage(buffer, null, 0, 0);

				Thread.sleep(1);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Game getGame() {
		return game;
	}
}

package gabicar.application;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
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

	private ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();

	public Painter(JFrame frame) {
		painter = this;

		this.frame = frame;
		this.buffer = new BufferedImage(500, 700, BufferedImage.TYPE_4BYTE_ABGR);
		this.canvas = buffer.createGraphics();
		this.game = new Game(this);
		
		
		try {
			images.add(load("D:\\Workspace\\GABICAR\\src\\gabicar\\resources\\32px_Anonymous-BMW-Z4-top-view.png"));
			images.add(load("D:\\Workspace\\GABICAR\\src\\gabicar\\resources\\32px_car-topview-2.png"));
			images.add(load("D:\\Workspace\\GABICAR\\src\\gabicar\\resources\\32px_car-topview-3.png"));
			images.add(load("D:\\Workspace\\GABICAR\\src\\gabicar\\resources\\32px_car-topview.png"));
			images.add(load("D:\\Workspace\\GABICAR\\src\\gabicar\\resources\\32px_glibersat-Nioubiteul.png"));
			images.add(load("D:\\Workspace\\GABICAR\\src\\gabicar\\resources\\32px_glibersat-Pigeau.png"));
			images.add(load("D:\\Workspace\\GABICAR\\src\\gabicar\\resources\\32px_glibersat-Sapuar.png"));
			images.add(load("D:\\Workspace\\GABICAR\\src\\gabicar\\resources\\32px_simple-travel-car-top-view.png"));
			images.add(load("D:\\Workspace\\GABICAR\\src\\gabicar\\resources\\32px_SimpleBlueCarTopView.png"));
			images.add(load("D:\\Workspace\\GABICAR\\src\\gabicar\\resources\\32px_SimpleBrightGreenCarTopView.png"));
			images.add(load("D:\\Workspace\\GABICAR\\src\\gabicar\\resources\\32px_SimpleDarkBlueCarTopView.png"));
			images.add(load("D:\\Workspace\\GABICAR\\src\\gabicar\\resources\\32px_SimpleGreenCarTopView.png"));
			images.add(load("D:\\Workspace\\GABICAR\\src\\gabicar\\resources\\32px_SimpleOrangeCarTopView.png"));
			images.add(load("D:\\Workspace\\GABICAR\\src\\gabicar\\resources\\32px_SimplePinkCarTopView.png"));
			images.add(load("D:\\Workspace\\GABICAR\\src\\gabicar\\resources\\32px_SimplePurpleCarTopView.png"));
			images.add(load("D:\\Workspace\\GABICAR\\src\\gabicar\\resources\\32px_SimpleTurquoiseCarTopView.png"));
			images.add(load("D:\\Workspace\\GABICAR\\src\\gabicar\\resources\\32px_SimpleYellowCarTopView.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		game.init();
	}

	public BufferedImage load(String fileName) throws IOException {
		File file = new File(fileName);
		return ImageIO.read(file);
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

	public ArrayList<BufferedImage> getImages() {
		return images;
	}

}

package gabicar.model;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Car implements DrawableObject {

	private boolean isPlayer = false;
	private int speed = 10;
	private int x = 350;
	private int y = 600;
	private int width = 0;
	private int height = 0;
	private BufferedImage image;

	public Car(String fileName) {
		try {
			File file = new File(fileName);
			image = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void draw(Graphics2D canvas) {
		canvas.drawImage(image, null, x, y);
	}

	public void move() {

	}

	public void up() {
		y = y - speed;
	}

	public void down() {
		y = y + speed;
	}

	public void left() {
		x = x - speed;
	}

	public void right() {
		x = x + speed;
	}

	public boolean isPlayer() {
		return isPlayer;
	}

	public void setPlayer(boolean isPlayer) {
		this.isPlayer = isPlayer;
	}
	
	
}

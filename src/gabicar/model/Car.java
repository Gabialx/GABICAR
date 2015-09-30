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
			this.image = ImageIO.read(file);
			this.width = this.image.getWidth();
			this.height = this.image.getHeight();
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
		if (y - speed >= 700 / 2) {
			y = y - speed;
		}
	}

	public void down() {
		if (y + speed <= 700 - height) {
			y = y + speed;
		}

	}

	public void left() {
		if (x - speed >= 0) {
			x = x - speed;
		}
	}

	public void right() {
		if (x + speed <= 500 - width) {
			x = x + speed;
		}
	}

	public boolean isPlayer() {
		return isPlayer;
	}

	public void setPlayer(boolean isPlayer) {
		this.isPlayer = isPlayer;
	}

}

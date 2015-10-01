package gabicar.model;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Car implements DrawableObject {

	private boolean isPlayer = false;
	private int speed = 10;
	private int x = 350;
	private int y = 600;

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

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

	public Car(BufferedImage image) {
		this.image = image;
		this.width = this.image.getWidth();
		this.height = this.image.getHeight();
	}

	/**
	 * http://stackoverflow.com/questions/9558981/flip-image-with-graphics2d
	 * http://stackoverflow.com/questions/9132454/how-to-rotate-a-bufferd-image-
	 * in-java?lq=1
	 */
	@Override
	public void draw(Graphics2D canvas) {
		AffineTransformOp operation = null;
		if (!isPlayer) {
			AffineTransform transform = AffineTransform.getScaleInstance(1, -1);
			transform.translate(0, -height);
			operation = new AffineTransformOp(transform, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		}

		canvas.drawImage(image, operation, x, y);
	}

	public void move() {
		y = y + speed;
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

	public boolean intersects(Car car) {
		Rectangle r1 = new Rectangle(x, y, width, height);
		Rectangle r2 = new Rectangle(car.getX(), car.getY(), car.getWidth(), car.getHeight());

		return r1.intersects(r2);
	}

	public boolean isPlayer() {
		return isPlayer;
	}

	public void setPlayer(boolean isPlayer) {
		this.isPlayer = isPlayer;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}

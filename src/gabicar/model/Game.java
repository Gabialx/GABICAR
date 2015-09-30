package gabicar.model;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import gabicar.application.Painter;

public class Game implements DrawableObject {

	private ArrayList<DrawableObject> objects = new ArrayList<DrawableObject>();

	private Painter painter;

	public Game(Painter painter) {
		this.painter = painter;
	}

	@Override
	public void draw(Graphics2D canvas) {
		int top = getTop();
		if (top > 100 || top == Integer.MAX_VALUE) {
			newCars();
		}

		moveCars();
		removeCars();

		for (DrawableObject drawableObject : objects) {
			drawableObject.draw(canvas);
		}
	}

	public ArrayList<DrawableObject> getObjects() {
		return objects;
	}

	public Car getPlayer() {
		for (DrawableObject drawableObject : objects) {
			if (drawableObject instanceof Car) {
				Car car = (Car) drawableObject;
				if (car.isPlayer()) {
					return car;
				}
			}
		}

		return null;
	}

	public int getTop() {
		int top = Integer.MAX_VALUE;
		for (DrawableObject drawableObject : objects) {
			if (drawableObject instanceof Car) {
				Car car = (Car) drawableObject;
				if (!car.isPlayer() && car.getY() < top) {
					top = car.getY();

				}
			}
		}
		return top;
	}

	private static Random random = new Random();

	public void newCars() {
		int imageIndex = random.nextInt(painter.getImages().size());
		BufferedImage image = painter.getImages().get(imageIndex);
		Car car = new Car(image);
		car.setX(Math.abs(random.nextInt(500 - car.getWidth())));
		car.setY(0);
		car.setSpeed(1);

		objects.add(car);

	}

	public void moveCars() {
		for (DrawableObject drawableObject : objects) {
			if (drawableObject instanceof Car) {
				Car car = (Car) drawableObject;
				if (!car.isPlayer()) {
					car.move();
				}
			}
		}
	}

	public void removeCars() {
		Iterator<DrawableObject> iterator = objects.iterator();
		while (iterator.hasNext()) {
			DrawableObject drawableObject = iterator.next();
			if (drawableObject instanceof Car) {
				Car car = (Car) drawableObject;
				if (!car.isPlayer() && car.getY() > 700) {
					iterator.remove();
				}
			}
		}
	}
}

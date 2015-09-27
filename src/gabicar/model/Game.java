package gabicar.model;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class Game implements DrawableObject {

	private ArrayList<DrawableObject> objects = new ArrayList<DrawableObject>();

	@Override
	public void draw(Graphics2D canvas) {
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

}

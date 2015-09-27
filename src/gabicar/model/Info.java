package gabicar.model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Info implements DrawableObject {

	private int fps = 0;

	private int frameCount = 0;

	private long second = 0;

	@Override
	public void draw(Graphics2D canvas) {

		long newSecond = System.currentTimeMillis() / 1000;
		if (second == newSecond) {
			frameCount++;
		} else {
			fps = frameCount;
			frameCount = 0;
			second = newSecond;

		}

		canvas.setColor(Color.RED);
		Font font = new Font("Serif", Font.PLAIN, 14);
		canvas.setFont(font);
		canvas.drawString("FPS: " + Integer.toString(fps), 20, 50);

	}

}

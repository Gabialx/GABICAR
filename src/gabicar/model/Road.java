package gabicar.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class Road implements DrawableObject {

	/**
	 * https://docs.oracle.com/javase/tutorial/2d/geometry/strokeandfill.html
	 */
	@Override
	public void draw(Graphics2D canvas) {
		canvas.setColor(Color.YELLOW);
		canvas.fillRect(0, 0, 500, 700);
		canvas.setColor(Color.BLACK);
		float dash1[] = { 20.0f };
		BasicStroke stroke = new BasicStroke(5.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);
		canvas.setStroke(stroke);
		canvas.drawLine(250, 0, 250, 700);

	}

}

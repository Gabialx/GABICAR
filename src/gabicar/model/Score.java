package gabicar.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Score implements DrawableObject{
	
	private int score;
	private int best;
	

	@Override
	public void draw(Graphics2D canvas) {
		canvas.setColor(Color.YELLOW);
		canvas.fillRect(0, 0, 500, 700);
		canvas.setColor(Color.GREEN);
		canvas.fillRect(150, 300, 200, 100);
	
		canvas.setColor(Color.BLACK);
		Font font = new Font("Serif", Font.PLAIN, 14);
		canvas.setFont(font);
		canvas.drawString("GAME OVER", 170, 320);
		canvas.drawString("Score: " + Integer.toString(score), 170, 340);
		canvas.drawString("Best: " + Integer.toString(best), 170, 360);
		
		canvas.drawString("Press 'N' key for a new game.", 170, 380);
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getBest() {
		return best;
	}
	public void setBest(int best) {
		this.best = best;
	}
	

}

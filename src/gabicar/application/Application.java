package gabicar.application;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Application {

	/**
	 * http://docs.oracle.com/javase/tutorial/uiswing/painting/step1.html
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	private static void createAndShowGUI() {
		// 1. Create the frame.
		JFrame frame = new JFrame("GABICAR");

		// 2. Optional: What happens when the frame closes?
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 3. Setup
		frame.setResizable(false);

		// 4. Size the frame.
		frame.setSize(500, 700);

		// 5. Center it.
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

		// 6. Keyboard.
		KeyboardListener listener = new KeyboardListener();
		frame.addKeyListener(listener);

		// 7. Show it.
		frame.setVisible(true);
		
		/**
		 * https://docs.oracle.com/javase/tutorial/essential/concurrency/
		 * runthread.html
		 */
		Painter painter = new Painter(frame);
		painter.start();
	}
}

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.teachingextensions.logo.ImageBackground;
import org.teachingextensions.logo.Paintable;
import org.teachingextensions.logo.Tortoise;

/**
 * Note: You will need the latest version of the TKP jar:
 * http://school.wintrisstech.org/jars/TeachingKidsProgramming.jar
 **/

public class TurtleTreasureHunt implements KeyEventDispatcher {

	JFrame f = new JFrame();

	JPanel p = new JPanel();

	JLabel l = new JLabel();

	String image = "fetch1.jpg";
	
	Clues clue = new Clues();
	
	Move move = new Move();

	private void feedTheTortoise() throws MalformedURLException {
		
		JOptionPane.showMessageDialog(null, "Instructions: \n Help The Turtle Complete the treasure hunt. \n"
				+ "Use the Up and Down arrow keys to move forwards and backwards, using the right and left to turn. \n"
				+ "If you think you found the next clue, click the space bar to get the next clue. \n "
				+ "Happy Hunting!");

		JOptionPane.showMessageDialog(null,
				"Free the Girl tied up in the ropes.");

	}

	private void spaceBarWasPressed() {

		int tortoiseLocationX = Tortoise.getX();

		int tortoiseLocationY = Tortoise.getY();

		System.out.println(tortoiseLocationX);

		System.out.println(tortoiseLocationY);

		clue.findTheGirl(tortoiseLocationX, tortoiseLocationY);

		clue.findTheDino(tortoiseLocationX, tortoiseLocationY);

		clue.findTheBirds(tortoiseLocationX, tortoiseLocationY);
		
		clue.findTheT(tortoiseLocationX, tortoiseLocationY);

	}
	
	public boolean dispatchKeyEvent(KeyEvent e) {

		if (e.getID() == KeyEvent.KEY_PRESSED) {

			if (e.getKeyCode() == KeyEvent.VK_RIGHT)

				move.goRight();

			else if (e.getKeyCode() == KeyEvent.VK_LEFT)

				move.goLeft();

			else if (e.getKeyCode() == KeyEvent.VK_UP)

				move.goUp();

			else if (e.getKeyCode() == KeyEvent.VK_DOWN)

				move.goDown();

			else if (e.getKeyCode() == KeyEvent.VK_SPACE)

				spaceBarWasPressed();
			
			else if (e.getKeyCode() == KeyEvent.VK_E)
				
				System.exit(0);

		}

		return false;

	}

	private void go() {

		KeyboardFocusManager.getCurrentKeyboardFocusManager()
				.addKeyEventDispatcher(this);

		Paintable backgroundImage = new ImageBackground(
				"http://s30.postimg.org/oi69jth7l/fetch1.jpg");

		Tortoise.getBackgroundWindow().addPaintable(backgroundImage);

		Tortoise.penUp();
	}

	public static void main(String[] args) throws MalformedURLException {

		new TurtleTreasureHunt().go();

		TurtleTreasureHunt tth = new TurtleTreasureHunt();

		tth.feedTheTortoise();

	}
}

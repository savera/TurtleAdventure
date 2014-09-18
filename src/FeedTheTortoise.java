// Copyright Wintriss Technical Schools 2013

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.TurtlePanel;

public class FeedTheTortoise implements KeyEventDispatcher {

	int tortoiseLocationX = Tortoise.getX();

	int tortoiseLocationY = Tortoise.getY();

	JFrame f = new JFrame();

	JPanel p = new JPanel();

	JLabel l = new JLabel();

	String image = "fetch1.jpg";

	private void feedTheTortoise() throws MalformedURLException {

		addFood(50, 50);

		showImage();

		JOptionPane.showMessageDialog(null,
				"Free the Girl tied up in the ropes.");

	}

	private void showImage() throws MalformedURLException {
		
		f.setVisible(true);
  
		f.setSize(1500, 1500);

		f.add(p);

		l = createImage(image);

		p.add(l);

		p.setSize(800, 600);

		// Tortoise.getBackgroundWindow().add(l);

		// Tortoise.getBackgroundWindow().addAdditional(l);
	}

	private JLabel createImage(String fileName) throws MalformedURLException {

		URL imageURL = getClass().getResource(fileName);

		Icon icon = new ImageIcon(imageURL);

		JLabel imageLabel = new JLabel(icon);

		return imageLabel;

	}

	private void goUp() {

		System.out.println("going up");

		Tortoise.move(5);
	}

	private void goDown() {

		Tortoise.move(-5);

	}

	private void goLeft() {

		Tortoise.turn(-90);

		Tortoise.move(5);

		Tortoise.turn(90);

	}

	private void goRight() {

		Tortoise.turn(90);

		Tortoise.move(5);

		Tortoise.turn(-90);

	}

	private void findTheGirl() {

		if (tortoiseLocationX == 550 && tortoiseLocationY == 400) {

			JOptionPane.showMessageDialog(null, "Search the swampy waters");

		}

	}

	private void findTheDino() {

		if (tortoiseLocationX == 400 && tortoiseLocationY == 550) {

			JOptionPane.showMessageDialog(null,
					"Three of them sit side by side.");

		}

	}

	private void findTheBirds() {

		if (tortoiseLocationX == 500 && tortoiseLocationY == 200) {

			JOptionPane.showMessageDialog(null, "Find the Golden T.");

		}

	}
	
	private void checkIfFoodFound() throws Exception {

		System.out.println(tortoiseLocationX);

		System.out.println(tortoiseLocationY);

	}

	private void eatFood() {

		component.setText("");

	}

	private void addFood(int x, int y) {

		component.setLocation(x, y);

		window.add(component);
	}

	TurtlePanel window = Tortoise.getBackgroundWindow();

	Label component = new Label("*");

	public static void main(String[] args) throws MalformedURLException {

		FeedTheTortoise feeder = new FeedTheTortoise();

		feeder.controlTheTortoise();

		feeder.feedTheTortoise();
	}

	private void controlTheTortoise() {

		KeyboardFocusManager.getCurrentKeyboardFocusManager()
				.addKeyEventDispatcher(this);

		Tortoise.show();

		Tortoise.setSpeed(10);
	}

	public boolean dispatchKeyEvent(KeyEvent e) {

		if (e.getID() == KeyEvent.KEY_PRESSED) {

			if (e.getKeyCode() == KeyEvent.VK_RIGHT)

				goRight();

			if (e.getKeyCode() == KeyEvent.VK_LEFT)

				goLeft();

			if (e.getKeyCode() == KeyEvent.VK_UP)

				goUp();

			if (e.getKeyCode() == KeyEvent.VK_DOWN)

				goDown();

			try {

				checkIfFoodFound();

			} catch (Exception exception) {

			}
		}

		return false;
	}

}

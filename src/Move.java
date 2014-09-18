import java.awt.event.KeyEvent;

import org.teachingextensions.logo.Tortoise;

public class Move {

	public void goUp() {
		// System.out.println("going up");

		Tortoise.move(5);
	}

	public void goDown() {

		// System.out.println("going down");

		Tortoise.move(-5);
	}

	public void goLeft() {

		// System.out.println("going left");

		// Tortoise.turn(-90);
		
		Tortoise.setAngle(270);

		Tortoise.move(5);

		Tortoise.setAngle(0);

		Tortoise.move(0);
	}

	public void goRight() {
		
		// System.out.println("going right");

		// Tortoise.turn(90);

		Tortoise.setAngle(90);

		Tortoise.move(5);

		Tortoise.setAngle(0);

		Tortoise.move(0);
	}
}

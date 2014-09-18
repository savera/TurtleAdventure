import java.awt.Color;

import javax.swing.JOptionPane;

//import org.teachingextensions.logo.Colors;
import org.teachingextensions.logo.Tortoise;

public class Clues {

	public boolean isNearGirl(int gx, int gy) {
		
		return gx >= 490 && gx <= 515 && gy >= 290 && gy <= 350;
		
	}

	public boolean isNearDino(int dx, int dy) {
		
		return dx >= 315 && dx <= 340 && dy >= 400 && dy <= 415;
		
	}

	public boolean isNearBirds(int bx, int by) {
		
		return bx >= 405 && bx <= 465 && by >= 90 && by <= 120;
		
	}

	public boolean isNearT(int tx, int ty) {
		
		boolean tFound = tx >= 90 && tx <= 120 && ty >= 275 && ty <= 305;
		
		return tFound;
	}

	public void findTheGirl(int gx, int gy) {
		
		if (isNearGirl(gx, gy)) {
			
			JOptionPane.showMessageDialog(null, "Search the swampy waters");
			
		}
	}

	public void findTheDino(int dx, int dy) {
		
		if (isNearDino(dx, dy)) {
			
			JOptionPane.showMessageDialog(null,
					"Three of them sit side by side.(Hint: Search the trees.)");
			
		}
		
	}

	public void findTheBirds(int bx, int by) {

		if (isNearBirds(bx, by)) {

			JOptionPane.showMessageDialog(null, "Find the Golden T.");

		}

	}

	public void findTheT(int tx, int ty) {
		
		if (isNearT(tx, ty)) {
		
			for (int i = 0; i < 5; i++) {
				
				Tortoise.penDown();
				
				Tortoise.setPenColor(Color.YELLOW);
				
				Tortoise.move(200);
				
				Tortoise.turn(144);
				
			}
			
			JOptionPane
					.showMessageDialog(null,
							"Congrats! You found the trigger. Press the letter 'e' to end the game");
			

		}

	}
}

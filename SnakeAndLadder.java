package SnakeAndLadder;
import java.util.*;

public class SnakeAndLadder {

	//initialized player1 at position 0
	int userPosition = 0;

	public static void main(String args[]) {
		SnakeAndLadder player1 = new SnakeAndLadder();
		System.out.println(player1.rollDice());
	}

	//function for rolling a dice
	public int rollDice() {
		Random rand = new Random();
		int diceRoll = rand.nextInt(6) + 1;
		return diceRoll;
	}
}

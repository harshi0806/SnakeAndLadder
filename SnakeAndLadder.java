package SnakeAndLadder;
import java.util.*;

public class SnakeAndLadder {

	//initialized player1 at position 0
	private int userPosition = 0;

	public static void main(String args[]) {
		SnakeAndLadder player1 = new SnakeAndLadder();
		player1.startGame();
	}

	//function for rolling a dice
	public int rollDice() {
		Random rand = new Random();
		int diceRoll = rand.nextInt(6) + 1;
		return diceRoll;
	}

	//function to start the game
	public void startGame() {
		System.out.println("Let's start the game!");
		//iterate till the player reaches position100
		while(this.getUserPosition() < 100)
		{
			//rolling a dice
			int diceRoll = this.rollDice();
			System.out.println("Dice roll: "+ diceRoll);
			//getting position of the user
			int position = this.getUserPosition();
			position += diceRoll;
			//To check if the player reached the winning position
			if (position > 100)
				continue;
			if (position == 100)
			{
				System.out.println("Hurray! You Won the game.");
				break;
			}
			System.out.println("The position of the player is: "+ position);
			//Calling to check with the option
			int option = this.checkOption();
			switch (option)
			{
				case 0 :
					System.out.println("No Play");
					position += 0;
					this.setUserPosition(position);
					break;
				case 1 :
					System.out.println("Ladder");
						if(position < 100)
						{
						position += diceRoll;
						this.setUserPosition(position);
						break;
						}
				case 2 :
					System.out.println("Snake Bite");
					position -= diceRoll;
					this.setUserPosition(position);
					break;
				default :
					System.out.println("Invalid option");
			}
			System.out.println("Now the position of the player is: "+ this.getUserPosition());
		}
	}

	/**
	  * @return the position
	  */
	public int getUserPosition() {
		return userPosition;
	}

	/**
	  * @param userPosition used to set the position
	  * if userPosition < 0 then user is assigned the position 0
	  */
	public void setUserPosition(int userPosition) {
		if(userPosition < 0)
		{
			userPosition = 0;
		}
		this.userPosition = userPosition;
	}

	/**
	  * This will generate option to check
	  * 0 - No play, 1 - ladder, 2 - snake bite
	  */
	public int checkOption() {
		Random rand = new Random();
		int option = rand.nextInt(3);
		return option;
	}
}



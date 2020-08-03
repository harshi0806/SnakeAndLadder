package SnakeAndLadder;
import java.util.*;
import java.util.Scanner;

public class SnakeAndLadder {

	public static void main(String[] args) {
		SnakeNLadder s = new SnakeNLadder();
		s.startGame();
	}

}

//Created another class for operation
class SnakeNLadder {
	//Initialize static variable for wining position
	final static int WINPOINT = 100;
	/**
	  *Function to roll a dice
	  *@return dice throw
	  */
	public int rollDice()
	{
		int n = 0;
		Random r = new Random();
		n=r.nextInt(7);
		return (n==0?1:n);
	}
	//Function to start playing game
	public void startGame()
	{
		int player1 =0, player2=0;
		int currentPlayer=-1;
		Scanner s = new Scanner(System.in);
		String str;
		int diceValue = 0;
		int playAgain = 0;
		int player = 0;
		int count = 0;
		//Iterate till it reaches winning point
		while(player < WINPOINT)
		{
			if(player > WINPOINT)
				continue;
			do
			{
				//ternary operator used to ask which player turn
				System.out.println(currentPlayer==-1?"\n\nFIRST PLAYER TURN":"\n\nSECOND PLAYER TURN");
				//Asking for the player to roll the dice
				System.out.println("Press r to roll Dice");
				//User input "r" enters here to get check
				str = s.next();
				diceValue = rollDice();
				count += 1;
				System.out.println("Total no. of throws: "+ count);
				//Checks player1 = -1,player2 = 1
				if(currentPlayer == -1)
				{
					player1 = calculatePlayerValue(player1,diceValue);
					System.out.println("First Player :: " + player1);
					System.out.println("Second Player :: " + player2);
					if(isWin(player1))
					{
						System.out.println("First player wins");
						return;
					}
				}
				else
				{
					player2 = calculatePlayerValue(player2,diceValue);
					System.out.println("First Player :: " + player1);
					System.out.println("Second Player :: " + player2);
					if(isWin(player2))
					{
						System.out.println("Second player wins");
						return;
					}
				}
				//setting the variable
				currentPlayer= -currentPlayer;
			}while("r".equals(str));
		}
	}
	/**
	  *Function to calculate particular player position
	  *@return player returns player position
	  */
	public int calculatePlayerValue(int player, int diceValue)
	{
		//Calling to check with the option
		int option = this.checkOption();
		switch (option)
		{
			case 0 :
				System.out.println("No Play");
				player += 0;
				break;
			case 1 :
				System.out.println("Ladder");
					if(player < WINPOINT)
					{
					//For ladder plays again
					player += diceValue;
					diceValue = rollDice();
					player += diceValue;
					break;
					}
			case 2 :
				System.out.println("Snake Bite");
				player -= diceValue;
				break;
			default :
				System.out.println("Invalid option");
		}
		return player;
	}
	//Function checks the player position exactly reaches to the winning point
	public boolean isWin(int player)
	{
		return WINPOINT == player;
	}
	/**
	  *Function to create random no. to check for options
	  *@return random number
	  */
	public int checkOption() {
		Random rand = new Random();
		int option = rand.nextInt(3);
		return option;
	}
}




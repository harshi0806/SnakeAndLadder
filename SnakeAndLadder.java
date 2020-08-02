package SnakeAndLadder;
import java.util.*;

public class SnakeAndLadder implements IPlayersPlay {

	//instance variables
	private LinkedList<PlayersPlay> players;
	private Map<String, PlayersPlay> playersMap;

	public SnakeAndLadder() {
		players = new LinkedList<>();
		playersMap = new HashMap<>();
	}

	public void addPlayersPlay(String player) {
		PlayersPlay playersPlay = new PlayersPlay();
		players.add(playersPlay);
		playersMap.put(player, playersPlay);
	}

	public void startGame() {
		for(int i = 0; i < players.size(); i++)
		{
			PlayersPlay playersPlay = players.get(i);
			playersPlay.setUserPosition(this.startGame(this.getUserPosition()));
			playersPlay.setCount(this.startGame(this.getCount()));
			System.out.println(playersPlay);
		}
	}

	public int getUserPlay(String player) {
		return playersMap.get(player).getUserPosition();
		return playersMap.get(player).getCount();
	}

	public static void main(String args[]) {
		//Create object of Queue for multiple players
		IPlayersPlay SnakeAndLadder = new SnakeAndLadder();
		//Add players to end of Queue
		SnakeAndLadder.addPlayersPlay("player1");
		SnakeAndLadder.addPlayersPlay("player2");
		SnakeAndLadder.startGame();
	}

	//function for rolling a dice
	public int rollDice() {
		Random rand = new Random();
		int diceRoll = rand.nextInt(6) + 1;
		return diceRoll;
	}

	//function to start the game
	public void startGame(PlayersPlay playersPlay) {
		System.out.println("Let's start the game!");
		//iterate till the player reaches position100
		while(this.getUserPosition() < 100) {
			//rolling a dice
			int diceRoll = this.rollDice();
			this.setCount(this.getCount() + 1);
			System.out.println("Dice roll: "+ diceRoll);
			System.out.println("Number of throws to win : "+ this.getCount());
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
     * This will generate option to check
     * 0 - No play, 1 - ladder, 2 - snake bite
     */
   public int checkOption() {
      Random rand = new Random();
      int option = rand.nextInt(3);
      return option;
   }
}
	/**
	  * created another class PlayerPlay
	  */
class Player {
	public String player;
	public int userPosition;
	public int count;

	public Player() {
	}

	public PlayersPlay(String player) {
		this.player = player;
		userPosition = 0;
		count = 0;
	}

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

	//@return the count
	public int getCount() {
		return count;
	}

	//@param to set the count value
	public void setCount(int count) {
		this.count = count;
	}
}

interface IPlayersPlay {
	public void addPlayersPlay(String player);
	public void startGame();
	public void getUserPlay(String player);
}





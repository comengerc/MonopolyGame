import java.util.ArrayList;
import java.util.Scanner;

public class MonopolyGame {

	public MonopolyGame() { // Constructor of monopoly game
	}

	public void StartGame() {
		 // These are inputs for set values...
		Scanner input = new Scanner(System.in);
		System.out.println("How many players going to play ?");
		int numberOfPlayers = input.nextInt();
		System.out.println("Set luxary tax value");
		int luxTax = input.nextInt();
		System.out.println("Set payroll tax value");
		int payTax = input.nextInt();
		System.out.println("Set passing starting point money value");
		int startingMoney = input.nextInt();
		System.out.println("Set initial balance");
		int initialBalance = input.nextInt();
		
		
		ArrayList<ChanceCard> ChanceCards = new ArrayList<ChanceCard>();
		
		int numberOfTurns = 0;// Defining Turn number
		Dice dice1 = new Dice();// These are objects of dices
		Dice dice2 = new Dice();
		Board board1 = new Board(numberOfPlayers, initialBalance, luxTax, payTax,
				startingMoney,ChanceCards); // New board object with set input values.
		board1.createPlayers(numberOfPlayers); // This create Players as given
		board1.createSquaresToBoard(board1.getList()); // This create squares and with their square objects
		board1.createChanceCardList(ChanceCards);
		
		// This loop work until number of players will be 1. In other word until game will be finished
		while (board1.getPlayerArrayListSize() > 1) { 
			// Refreshing the even dice numbers of the players (For rolling three even dice in jail)
			for (int diceCount = 0; diceCount < board1.getPlayerArrayListSize(); diceCount++) { 
				board1.getPlayer(diceCount).setDiceCount(0);
			}
			// This loop work for every cycle
			for (int i = 0; i < board1.getPlayerArrayListSize(); i++) { 
				int a =i;
				//CONTROL jail EVEN NUMBER
				i=board1.getPlayer(i).controlJail(board1, i, dice1, dice2);
				if (a!=i) {
					i--;
					continue;
				}
				board1.checkAndSetRent(board1);
				 // Location of Players before turn
				int beforeTurn = board1.getPlayer(i).getPiece().getlocation();
				// Players information before rolling dice
				System.out.println("\n ---------------------------------------------------------------\n"
						+ "Before rolling dice: \nTurn of " + board1.getPlayer(i).getName());
				System.out.println("Turn number is " + numberOfTurns);
				System.out.println("Played turn " + board1.getPlayer(i).getTurnCount());
				System.out.println("Cycle is " + board1.getPlayer(i).getCycle());
				System.out.println(board1.getPlayer(i).getName() + "'s location is "
						+ board1.getPlayer(i).getPiece().getlocation());
				System.out.println(board1.getPlayer(i).getName() + "'s balance is " + board1.getPlayer(i).getBalance());
				System.out.println("The square's name is: "
						+ board1.getObject(board1.getPlayer(i).getPiece().getlocation() % 40).getName());
				if(board1.getObject(board1.getPlayer(i).getPiece().getlocation() % 40).getBuildingList().size()==5) {
					System.out.println("This City has hotel!");
				}else System.out.println("House count:"+board1.getObject(board1.getPlayer(i).getPiece().getlocation() % 40).getBuildingList().size());
								

				// Moving: Players move on board with piece and moveOn function
				int dice;
				dice = board1.getPlayer(i).getPiece().moveOn(board1, dice1, dice2, i,board1.getPlayer(i)); 
				board1.getPlayer(i).setTurnCount(board1.getPlayer(i).getTurnCount() + 1);

				// if Each player pass on starting Point, player get Starting money and increase his or her cycle count
				int afterTurn = board1.getPlayer(i).getPiece().getlocation();
				if (beforeTurn > afterTurn) {
					board1.getPlayer(i).setCycle(board1.getPlayer(i).getCycle() + 1); // Increase cycle count
					board1.getPlayer(i).setBalance(
					board1.getPlayer(i).getBalance() + board1.getObject(0).getStartingPointPayment()); // Get money if player pass on starting point
				}
				/// BANKRUPT
				if(i > board1.getPlayer(i).bankrupt(board1.getPlayer(i), board1, i)) {
					continue;
				}
				//Winner situation
				if (board1.getPlayerArrayListSize() == 1) {
					System.out.println("Winner is " + board1.getPlayer(0).getName());
					break;
				}
				board1.getPlayer(i).addColorList(board1,board1.getPlayer(i));
				System.out.println(board1.getPlayer(i).getColorList());
				// Rolling even dice in a row
				if (dice == 0) {
					board1.getPlayer(i).setDiceCount(board1.getPlayer(i).getDiceCount() + 1);// If he roll dice less than 2
					
					if (board1.getPlayer(i).getDiceCount() == 2) {// You roll three times even dices
						System.out.println("You roll three times even dices.. \n");
						board1.getPlayer(i).setJail(true);// Go in jail
						board1.getPlayer(i).getPiece().setlocation(10);// If you roll three times even dices
						i++;
					}
					i--;
				}

			}
			
			for (int a = 0; a < board1.getPlayerArrayListSize(); a++) { // Printing outputs
				System.out.println("Output {" + board1.getPlayer(a).getName() + ", "
						+ board1.getPlayer(a).getPiece().getlocation() + ", " + board1.getPlayer(a).getBalance() + "}");

			}

			numberOfTurns++;
		}
		System.out.println("Winner is " + board1.getPlayer(0).getName());
	}
	public static void main(String[] args) {
		
		MonopolyGame monopolyGame = new MonopolyGame(); // Monopoly Game Object
		monopolyGame.StartGame(); // Game is starting
		
	}

}
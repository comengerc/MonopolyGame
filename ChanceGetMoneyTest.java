import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class ChanceGetMoneyTest {

	private String name = "Get 50$ from each player";
	private int moneyAmount = 100;
	
	@Test
	public void test() {

		ArrayList<ChanceCard> ChanceCards = new ArrayList<ChanceCard>();
		Board testBoard = new Board(3, 200, 100, 700, 1, 1, 200, ChanceCards);
	//			int arrayListSize,int numberOfPayrollTax,int numberOfLuxuryTax,int initialBalance,int luxTax,int payTax,int startingMoney, ArrayList<ChanceCard> ChanceCards
		testBoard.createChanceCardList(ChanceCards);
		testBoard.createPlayers(3);
		testBoard.createSquaresToBoard(testBoard.getList());
		
		testBoard.getListP().get(0).setBalance(700);
		testBoard.getListP().get(1).setBalance(600);
		testBoard.getListP().get(2).setBalance(500);
		
		Player testplayer = testBoard.getListP().get(0);
		testplayer.getPiece().setlocation(2);
		
		cardAction(testplayer, testBoard.getObject(testplayer.getPiece().getlocation()), testBoard);
		
		for(Player p : testBoard.getListP()) {
			System.out.println(p.getBalance()+"\n");
		}

		Assert.assertTrue("There is an error. p1.balance must be 900"
				+ "p2.balance must be 500"
				+ "p3.balance must be 400" + "but it is", testBoard.getListP().get(0).getBalance()==900 && testBoard.getListP().get(1).getBalance()==500 && testBoard.getListP().get(2).getBalance()==400);


	}
	public void cardAction(Player player,Square locationSquare, Board board) {
		
		
		if(this.getName().equals("Get 50$ from each player")) {

			System.out.println("\n\n\n");
			System.out.println(player.getName() + " is getting money from all of the players");
			for(Player p: board.getListP() ) {
				if(p != player) {
					
					p.setBalance(  p.getBalance() - moneyAmount  );
					player.setBalance(player.getBalance() + moneyAmount);
				}
			}	
		}

		else if(this.getName().equals("You rent a house and get 120")) {
			System.out.println("\n\n\n You rent a house and earn 120");
			
			
			player.setBalance(player.getBalance() + 120);
			
		}
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}

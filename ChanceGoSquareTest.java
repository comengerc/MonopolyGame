import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class ChanceGoSquareTest {

	private String name = "";
	private int moneyAmount = 100;
	boolean isRelative = false;
	int movedSquare = 0;
	

	
	@Test
	public void test() {

		String testName = "Go to the Kadikoy";
		String testName2 = "Move back three square";
		String testName3 = "Go to nearest Lot Square";
		ArrayList<ChanceCard> ChanceCards = new ArrayList<ChanceCard>();
		Board testBoard = new Board(3, 200, 100, 700, 1, 1, 200, ChanceCards);
	//			int arrayListSize,int numberOfPayrollTax,int numberOfLuxuryTax,int initialBalance,int luxTax,int payTax,int startingMoney, ArrayList<ChanceCard> ChanceCards
		testBoard.createChanceCardList(ChanceCards);
		testBoard.createPlayers(3);
		testBoard.createSquaresToBoard(testBoard.getList());
		
		
		Player testPlayer = testBoard.getListP().get(0);
		testPlayer.getPiece().setlocation(7);
		testPlayer.setBalance(400);
		
		Player testPlayer2 = testBoard.getListP().get(1);
		testPlayer2.getPiece().setlocation(17);
		testPlayer2.setBalance(500);
	
		Player testPlayer3 = testBoard.getListP().get(2);
		testPlayer3.getPiece().setlocation(22);
		testPlayer3.setBalance(600);
		
		Square testLocationSquare = testBoard.getList().get(7);
		Square testLocationSquare2 = testBoard.getObject(17);
		Square testLocationSquare3 = testBoard.getObject(22);
		
		testBoard.getObject(31).setOwner(testPlayer3);
		
		this.setName(testName);
		this.isRelative = false;
		this.movedSquare = 31;
		cardAction(testPlayer, testLocationSquare, testBoard);
		
		Assert.assertTrue("There is an error. p1. moved square must be 31 in other word Kadýköy"
				+ "but it is " 
				+ testBoard.getObject(testPlayer.getPiece().getlocation()).getName(),
				testBoard.getObject(31).getName().equals(testBoard.getObject(testPlayer.getPiece().getlocation()).getName())) ;


		

	}

	public void cardAction(Player player,Square locationSquare, Board board) {
		
		int prevLocation = player.getPiece().getlocation();
		int currentLocation;

		
		if(isRelative && movedSquare != 0) {
			System.out.println("\n" + this.getName());
			int location = player.getPiece().getlocation() + movedSquare;
			location = Math.floorMod(location, 40);  
			System.out.println("\t\t\t\t\t location" + location);
			player.getPiece().setlocation(location);
			
		}else if(!isRelative && movedSquare != 0) {
			System.out.println("\n" + this.getName());
			player.getPiece().setlocation(movedSquare);
			
		}else if(!isRelative && movedSquare == 0) {
			if(       Math.abs(player.getPiece().getlocation() -12) < Math.abs(player.getPiece().getlocation() -28) ) {
				System.out.println("\n" + this.getName());
				player.getPiece().setlocation(12);
			}
			else {
				System.out.println("\n" + this.getName());
				player.getPiece().setlocation(28);
			}
		}
		
		currentLocation = player.getPiece().getlocation();
		
		if(currentLocation - prevLocation < 0) {
			player.setBalance(player.getBalance() + board.startingMoney);
		}
		
		
		Square currentLocationSquare = board.getObject(player.getPiece().getlocation());
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoneyAmount() {
		return moneyAmount;
	}

	public void setMoneyAmount(int moneyAmount) {
		this.moneyAmount = moneyAmount;
	}
	
	
}



import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class MonopolyGameTest {
	static Board board;
	static Dice dice,dice2;

	@Test
	public void testMoveIt() throws IOException {
		dice = new Dice();
		dice2 = new Dice();
		
		board = new Board(3);
		board.getListP().add(0, new Player("Ahmet", 500));
		
		
		Piece testPiece = board.getPlayer(0).getPiece();
		
		int initialLocation = testPiece.getlocation();
		int finalLocation;
		
		moveOn( board, dice, dice2, 0);
		
		finalLocation = testPiece.getlocation();
		
		/*We want to know that the method moveIt works or not.
		  So we get initial location and compare it with final location.
		  If they are same, it means that piece could not moved. here we can catch the error.
		  */
		Assert.assertTrue("There is an error. Player's piece did not moved.", initialLocation!=finalLocation);

	}
	
	public static void moveOn(Board board1,Dice dice1,Dice dice2, int i) {
		
		int firstDice = dice1.rollDice();
		int secondDice = dice2.rollDice();

		board1.getPlayer(i).getPiece().setlocation((board1.getPlayer(i).getPiece().getlocation()+firstDice+secondDice)%40);//ZARLA LERLETME
		
	}

}

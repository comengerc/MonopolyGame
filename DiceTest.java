import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

public class DiceTest {

	@Test
	public void testRoll() {
		int result;
		Dice dice = new Dice();
		dice.rollDice();
		
		result=dice.getFaceValue();
		
			Assert.assertTrue("There is an error. Value of die must be less than or"
					+ "equal to 6 and greater than or equal to 1", result>=1 && result<=6);
	}

}

public class Dice {
	private int faceValue;
	
	public int rollDice() { 
		// it generates number between 1 to 6 for dice
		faceValue= (int)(Math.random()*10 % 6 +1) ; 
		return faceValue;
	}
	public int getFaceValue() {
		return faceValue;
	}	
}

public class StartingPoint extends Square {
    
	private String name="Starting square "; // Default square name
	private	int startingPointPayment ; // defining starting point payment
	
	public StartingPoint(int startingPointPayment, String name) { // constructor
		this.startingPointPayment=startingPointPayment;
		this.name=name;
	}
	public int getStartingPointPayment() { // getting
		return startingPointPayment;
	}
	public void setStartingPointPayment(int startingPointPayment) { // setting
		this.startingPointPayment = startingPointPayment;
	}
	public String getName() { // getting name
		return name;
	}
	public void landedOn(Player player,Square location) {
	}
}
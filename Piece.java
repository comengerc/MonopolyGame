public class Piece{
	
	private int diceValue1,diceValue2,location=0;
	private Square locationSquare;
	
	public int getlocation() { // getting location of players piece
		return location%40;
	}

	public void setlocation(int location) { // setting location
		
		this.location = location;
		
	}
	
	public Square getLocationSquare() {
		return locationSquare;
	}

	public int moveOn(Board board1,Dice dice1,Dice dice2,int i,Player player) { // move on function 
		// rolling dice for players
		diceValue1=dice1.rollDice(); 
		System.out.println("<---------------->");
		System.out.print(player.getName()+" Dice rolling-> First Dice= " + diceValue1 + " ");
		diceValue2=dice2.rollDice(); // rolling dice for players
		System.out.println("Second Dice= " + diceValue2 + " and sum of dices is " + (diceValue1+diceValue2));	
		player.getPiece().setlocation((player.getPiece().getlocation()+diceValue1+diceValue2)%40);//move part 
		System.out.println("<---------------->");
	
		
		//setting new location for landedon
		locationSquare=board1.getObject(player.getPiece().getlocation());
	    //after rolling dice
		System.out.println("\nAfter rolling dice:");

		locationSquare.landedOn(player,locationSquare, board1);		// LANDED ON
		
	    System.out.println(player.getName()+ "'s location is " + player.getPiece().getlocation());
		System.out.println("The square's name is: " + board1.getObject(player.getPiece().getlocation()%40).getName());
		if(board1.getObject(player.getPiece().getlocation() % 40).getBuildingList().size()==5) {
			System.out.println("This City has hotel!");
		}else System.out.println("House count:"+board1.getObject(player.getPiece().getlocation() % 40).getBuildingList().size());
	    System.out.println(player.getName()+ "'s balance is " + player.getBalance());
	    
	    System.out.print("Properties: ");
		for(int k=0;k<player.getPropertysOfPlayer().size();k++) {
			System.out.print(player.getObjectProperty(k).getName() + ", ");//property
		}
		System.out.print("\n");
	    
		return diceValue1-diceValue2;
	}

}



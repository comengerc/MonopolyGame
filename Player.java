import java.util.ArrayList;

public class Player {
	private Piece piece; // Players pieces object
	private String name;
	private int balance=1000; // Initial balance
	private int cycle=0;
	private boolean jail = false; // Jail control
	private int jailCount=0;
	private int diceCount=0;
	private int turnCount=0;
	private ArrayList<Square> propertysOfPlayer = new ArrayList<Square>();
	private ArrayList<String> colorList = new ArrayList<String>();
	
	
	public Player(String name,int balance) { // Constructor 
		this.balance=balance;
		this.name=name;
		Piece piece1 = new Piece();
	    this.piece= piece1;
	}
	//identcial info part
	public String getName() { return name;}
	public Piece getPiece() {return piece;}
	public int getCycle() {return cycle;}
	public void setCycle(int cycle) {this.cycle = cycle;}
	public int getBalance() {return balance;}
	public void setBalance(int balance) {	this.balance = balance;}
	

	//Property of player part
	public ArrayList<Square> getPropertysOfPlayer() {return propertysOfPlayer;}
	public Square getObjectProperty(int i) {return propertysOfPlayer.get(i);}//using in piece for syso
	public void buyProperty(Player player, Square property) {
		propertysOfPlayer.add(property);
	}
	
	//Which color have part
	public ArrayList<String> getColorList() {return colorList;}
	public void setColorList(ArrayList<String> colorList) {this.colorList = colorList;}
	public void addColorList(Board board1,Player player) {
		if(propertysOfPlayer.contains(board1.getObject(1))&&propertysOfPlayer.contains(board1.getObject(3)) && !player.getColorList().contains("Brown")) {player.getColorList().add("Brown");
		} else if (!propertysOfPlayer.contains(board1.getObject(1))||!propertysOfPlayer.contains(board1.getObject(3))) {player.getColorList().remove("Brown");}
		if(propertysOfPlayer.contains(board1.getObject(6))&&propertysOfPlayer.contains(board1.getObject(8))&&propertysOfPlayer.contains(board1.getObject(9)) && !player.getColorList().contains("Sky")) {player.getColorList().add("Sky");
		} else if (!propertysOfPlayer.contains(board1.getObject(6))||!propertysOfPlayer.contains(board1.getObject(8))||!propertysOfPlayer.contains(board1.getObject(9))) {player.getColorList().remove("Sky");}
		if(propertysOfPlayer.contains(board1.getObject(11))&&propertysOfPlayer.contains(board1.getObject(13))&&propertysOfPlayer.contains(board1.getObject(14)) && !player.getColorList().contains("Pink")) {player.getColorList().add("Pink");
		} else if (!propertysOfPlayer.contains(board1.getObject(11))||!propertysOfPlayer.contains(board1.getObject(13))||!propertysOfPlayer.contains(board1.getObject(14))) {player.getColorList().remove("Pink");}
		if(propertysOfPlayer.contains(board1.getObject(16))&&propertysOfPlayer.contains(board1.getObject(18))&&propertysOfPlayer.contains(board1.getObject(19)) && !player.getColorList().contains("Orange")) {player.getColorList().add("Orange");
		} else if (!propertysOfPlayer.contains(board1.getObject(16))||!propertysOfPlayer.contains(board1.getObject(18))||!propertysOfPlayer.contains(board1.getObject(19))) {player.getColorList().remove("Orange");}
		if(propertysOfPlayer.contains(board1.getObject(21))&&propertysOfPlayer.contains(board1.getObject(23))&&propertysOfPlayer.contains(board1.getObject(24)) && !player.getColorList().contains("Red")) {player.getColorList().add("Red");
		} else if (!propertysOfPlayer.contains(board1.getObject(21))||!propertysOfPlayer.contains(board1.getObject(23))||!propertysOfPlayer.contains(board1.getObject(24))) {player.getColorList().remove("Red");}		
		if(propertysOfPlayer.contains(board1.getObject(26))&&propertysOfPlayer.contains(board1.getObject(27))&&propertysOfPlayer.contains(board1.getObject(29)) && !player.getColorList().contains("Yellow")) {player.getColorList().add("Yellow");
		}else if (!propertysOfPlayer.contains(board1.getObject(26))||!propertysOfPlayer.contains(board1.getObject(27))||!propertysOfPlayer.contains(board1.getObject(29))) {player.getColorList().remove("Yellow");}
		if(propertysOfPlayer.contains(board1.getObject(31))&&propertysOfPlayer.contains(board1.getObject(32))&&propertysOfPlayer.contains(board1.getObject(34)) && !player.getColorList().contains("Green")) {player.getColorList().add("Green");
		} else if (!propertysOfPlayer.contains(board1.getObject(31))||!propertysOfPlayer.contains(board1.getObject(32))||!propertysOfPlayer.contains(board1.getObject(34))) {player.getColorList().remove("Green");}
		if(propertysOfPlayer.contains(board1.getObject(37))&&propertysOfPlayer.contains(board1.getObject(39)) && !player.getColorList().contains("Blue")) {player.getColorList().add("Blue");
		}else if (!propertysOfPlayer.contains(board1.getObject(37))||!propertysOfPlayer.contains(board1.getObject(39))) {player.getColorList().remove("Blue");}
	}
	
	public void rentProperty(int rentfee){
		this.setBalance(this.getBalance() - rentfee);
	}
	public void receiveRentPayment(int rentfee){
		this.setBalance(this.getBalance() + rentfee);
	}
	
	//Bankrupt player method part 
	public int bankrupt(Player player, Board board, int i) {
		if (player.isBankrupt(player.getBalance())) {
			System.out.println(player.getName() + " is bankrupted" + "\n");
			board.removePlayer(i);
			return i - 1;
		} else {
			return i;
		}
	}
	public boolean isBankrupt(int balance) { // Control players is or is not bankrupt
		boolean returnValue;
		if(balance<=0) {
			if(propertysOfPlayer.size()>0) {
				propertysOfPlayer.get(propertysOfPlayer.size()-1).setOwner(null);
				receiveRentPayment(propertysOfPlayer.get(propertysOfPlayer.size()-1).getPrice()/2);
				System.out.println(this.getName() + " sold his/her own " + propertysOfPlayer.get(propertysOfPlayer.size()-1).getName()
								+ " property in order to not to bankrupt. ");
				if(!propertysOfPlayer.get(propertysOfPlayer.size()-1).getBuildingList().isEmpty()) {
					propertysOfPlayer.get(propertysOfPlayer.size()-1).getBuildingList().removeAll(propertysOfPlayer.get(propertysOfPlayer.size()-1).getBuildingList());
				}
				propertysOfPlayer.remove(propertysOfPlayer.size()-1);
				System.out.println("His/Her new balance after sold property = " + this.balance);
				returnValue=this.isBankrupt(this.balance);
				return returnValue;
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	 // Control players are in jail or not
	public boolean isInJail(Player player) {
		
		if(player.getPiece().getlocation()==30) {
			
			return true;
		}
		else return false;
	}



	
	//Jail part for player
	public void setJail(boolean jail) {this.jail = jail;}	
	public boolean getJail() {return jail;}
	public int getJailCount() {	return jailCount;}
	public void setJailCount(int jailCount) {	this.jailCount = jailCount;}
	public int getDiceCount() {	return diceCount;}
	public void setDiceCount(int diceCount) {	this.diceCount = diceCount;}
	public int getTurnCount() {return turnCount;}
	public void setTurnCount(int turnCount) {	this.turnCount = turnCount;}
	
	public int controlJail(Board board1, int i,Dice dice1,Dice dice2) {
		if (board1.getPlayer(i).getJail()) { // Get jail info
			System.out.println("\n---------------------------------------------------------------\nPlayer in Jail.. "
					+ "" + board1.getPlayer(i).getName());// Players information before rolling dice
			
			int dice5 = dice1.rollDice();
			int dice6 = dice1.rollDice();
			System.out.println("Dices for escape jail = " + dice5 + "  " + dice6); // Player rolling dice for escape the jail
			System.out.println();
			
			// If player roll even dice, he will escaped
			if (dice5 == dice6) { 
				board1.getPlayer(i).setJail(false); // Boolean is false so player is not in jail
				board1.getPlayer(i).setJailCount(0); // Set jail count 0
				System.out.println("Player dice even and leave from Jail and deserve to play.");
				return i;
			} else if (board1.getPlayer(i).getJailCount() == 3) { // If through 3 cycle, player can not roll even dice, player give 50 money and
				System.out.println("Player gave 50 money and escaped from Jail!");									// escaped from jail
				board1.getPlayer(i).setJail(false);
				board1.getPlayer(i).setJailCount(0);
				board1.getPlayer(i).setBalance(board1.getPlayer(i).getBalance()-50);
				return i;
			}else {
				board1.getPlayer(i).setJailCount(board1.getPlayer(i).getJailCount() + 1); // If player can not roll even dice, set count will update
				return i+1;
			}
		}
		return i;
	}
	

}